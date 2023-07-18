package org.lboot.onlyoffice.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.URLUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.lboot.onlyoffice.config.OnlyOfficeProperties;
import org.lboot.onlyoffice.constant.DocEditorType;
import org.lboot.onlyoffice.constant.DocumentStatus;
import org.lboot.onlyoffice.constant.DocumentType;
import org.lboot.onlyoffice.constant.EditorConfigMode;
import org.lboot.onlyoffice.domain.*;
import org.lboot.onlyoffice.event.OfficeEditBuildEvent;
import org.lboot.onlyoffice.event.OfficeEditCloseEvent;
import org.lboot.onlyoffice.loader.OfficeAuthLoader;
import org.lboot.onlyoffice.loader.OfficeConfigLoader;
import org.lboot.onlyoffice.loader.OfficeStoreLoader;
import org.lboot.onlyoffice.service.OfficeCtl;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author kindear
 * Office服务实现
 */
@Slf4j
@Service
@AllArgsConstructor
public class OfficeCtlImpl implements OfficeCtl {
    OnlyOfficeProperties officeProps;

    OfficeConfigLoader configLoader;

    OfficeAuthLoader authLoader;

    OfficeStoreLoader storeLoader;

    @Resource
    ApplicationContext context;

    @Override
    public String getDocumentType(String extName) {
        if (DocumentType.WORD_FILE.contains(extName)){
            return "word";
        }
        else if (DocumentType.CELL_FILE.contains(extName)){
            return "cell";
        }
        else if (DocumentType.SLIDE_FILE.contains(extName)){
            return "slide";
        }
        return null;
    }

    @SneakyThrows
    @Override
    public Document buildRemoteDocument(String remoteUrl) {
        HttpResponse response = HttpRequest.get(remoteUrl).execute();
        // log.info(response.headers().toString());
        String fileNameHeader = response.header(Header.CONTENT_DISPOSITION);
        // log.info(fileNameHeader);
        String contentType = response.header(Header.CONTENT_TYPE);
        // log.info(contentType);
        String fileName = remoteUrl;
        if (contentType.equals("application/octet-stream")){
            fileName = StringUtils.substringAfterLast(fileNameHeader,"=");
            fileName = URLUtil.decode(fileName);
            if (Validator.isNotEmpty(fileName)){
                fileName = fileName.replace("UTF-8''", "");
            }
        }else if (contentType.startsWith("image")){
            // 图片
            fileName = StringUtils.substringAfterLast(remoteUrl,"/");
        }else {
            fileName = StringUtils.substringAfterLast(fileNameHeader,"=");
            fileName = URLUtil.decode(fileName);
            if (Validator.isNotEmpty(fileName)){
                fileName = fileName.replace("UTF-8''", "");
            }
        }
        // 进行MD5 编码
        String fileKey = SecureUtil.md5(response.bodyStream());
        // 构建 Document
        Document document = new Document();
        document.setKey(fileKey);
        document.setTitle(fileName);
        String fileType = FileNameUtil.extName(fileName);
        document.setFileType(fileType);
        document.setUrl(remoteUrl);
        //log.info(document.toString());
        return document;
    }

    @SneakyThrows
    @Override
    public DocEditor buildPreviewDocEditor(Document document) {
        // 配置模式
        EditorConfig editorConfig = new EditorConfig();
        editorConfig.setMode(EditorConfigMode.VIEW);
        editorConfig.setLang(configLoader.getLang());
        // 设置用户
        OfficeUser officeUser = new OfficeUser();
        officeUser.setId(authLoader.getUserId());
        officeUser.setName(authLoader.getUserName());
        editorConfig.setUser(officeUser);
        // 构建 Editor
        DocEditor docEditor = new DocEditor();
        docEditor.setDocument(document);
        docEditor.setDocumentType(getDocumentType(document.getFileType()));
        docEditor.setEditorConfig(editorConfig);
        docEditor.setHeight("100%");
        docEditor.setWeight("100%");
        return docEditor;
    }

    @SneakyThrows
    @Override
    public DocEditor buildEditDocEditor(Document document) {
        // 配置模式
        EditorConfig editorConfig = new EditorConfig();
        editorConfig.setMode(EditorConfigMode.EDIT);
        editorConfig.setLang(configLoader.getLang());
        // 设置用户
        OfficeUser officeUser = new OfficeUser();
        officeUser.setId(authLoader.getUserId());
        officeUser.setName(authLoader.getUserName());
        editorConfig.setUser(officeUser);
        // 设置回调 URL
        editorConfig.setCallbackUrl(officeProps.getCallbackUrl());
        // 构建 Editor
        DocEditor docEditor = new DocEditor();
        docEditor.setDocument(document);
        docEditor.setDocumentType(getDocumentType(document.getFileType()));
        docEditor.setEditorConfig(editorConfig);
        docEditor.setHeight("100%");
        docEditor.setWeight("100%");
        return docEditor;
    }

    @SneakyThrows
    @Override
    public ModelAndView previewRemoteFile(String remoteUrl, HttpServletResponse servletResponse) {
        Document document = buildRemoteDocument(remoteUrl);
        // 构建 Editor
        DocEditor docEditor = buildPreviewDocEditor(document);
        return previewFile(docEditor);
    }

    @SneakyThrows
    @Override
    public ModelAndView previewRemoteFile(String remoteUrl) {
        return previewRemoteFile(remoteUrl,null);
    }

    @SneakyThrows
    @Override
    public ModelAndView previewRemoteFileOnMobile(String remoteUrl) {
        Document document = buildRemoteDocument(remoteUrl);
        // 构建 Editor
        DocEditor docEditor = buildPreviewDocEditor(document);
        //设置移动端
        docEditor.setType(DocEditorType.MOBILE);
        return previewFile(docEditor);
    }

    @SneakyThrows
    @Override
    public ModelAndView previewRemoteFileOnEmbedded(String remoteUrl) {
        Document document = buildRemoteDocument(remoteUrl);
        // 构建 Editor
        DocEditor docEditor = buildPreviewDocEditor(document);
        //设置移动端
        docEditor.setType(DocEditorType.EMBEDDED);
        return previewFile(docEditor);
    }

    @SneakyThrows
    @Override
    public ModelAndView previewFile(DocEditor editor) {
        return previewFile(editor, null);
    }

    @SneakyThrows
    @Override
    public ModelAndView previewFile(DocEditor editor, String title) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("OfficeView");
        modelAndView.addObject("editor",editor);
        if (Validator.isEmpty(title)){
            modelAndView.addObject("title",editor.getDocument().getTitle());
        }
        else {
            modelAndView.addObject("title", title);
        }
        modelAndView.addObject("apiJs",officeProps.getOfficeDocumentApiJs());
        return modelAndView;
    }

    @SneakyThrows
    @Override
    public ModelAndView editFile(DocEditor editor) {
        return previewFile(editor, null);
    }


    @SneakyThrows
    @Override
    public ModelAndView editFile(Document document) {
        // 构建 Editor
        DocEditor docEditor = buildEditDocEditor(document);
        // 渲染编辑
        return editFile(docEditor);
    }

    @SneakyThrows
    @Override
    public ModelAndView editRemoteFile(String remoteUrl) {
        Document document = buildRemoteDocument(remoteUrl);
        // 构建 Editor
        DocEditor docEditor = buildEditDocEditor(document);
        // 渲染编辑
        return editFile(docEditor);
    }

    @SneakyThrows
    @Override
    public boolean editCallback(Map<String, Object> params) {
        DocumentEditCallback callback = BeanUtil.fillBeanWithMap(params,new DocumentEditCallback(),false);
        log.info(callback.toString());
        // 如果是状态 1
        if (callback.getStatus().equals(DocumentStatus.BEING_EDITED.getCode())){
            // 获取用户操作信息
            List<ActionBean> actions = callback.getActions();
            // 获取文件ID
            String fileKey = callback.getKey();
            for (ActionBean action:actions){
                // 用户断开编辑
                if (action.getType() == 0){
                    context.publishEvent(new OfficeEditCloseEvent(this, action.getUserid(), fileKey));
                }
                // 用户新建编辑
                else if (action.getType() == 1){
                    context.publishEvent(new OfficeEditBuildEvent(this, action.getUserid(), fileKey));
                }
            }
        }
        // status == 2
        else if (callback.getStatus().equals(DocumentStatus.READY_FOR_SAVING.getCode())){
            // 获取文件ID
            String fileKey = callback.getKey();
            HttpResponse response = HttpRequest.get(callback.getUrl()).execute();
            // 获取流
            InputStream stream = response.bodyStream();
            // 更新文件
            storeLoader.writeFile(fileKey, stream);
            // 关闭请求连接
            response.close();
            // 更新文件
            return true;
        }
        return false;
    }
}
