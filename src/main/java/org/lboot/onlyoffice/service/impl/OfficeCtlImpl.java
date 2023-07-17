package org.lboot.onlyoffice.service.impl;

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
import org.lboot.onlyoffice.constant.DocumentType;
import org.lboot.onlyoffice.domain.DocEditor;
import org.lboot.onlyoffice.domain.Document;
import org.lboot.onlyoffice.domain.EditorConfig;
import org.lboot.onlyoffice.service.OfficeCtl;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Service
@AllArgsConstructor
public class OfficeCtlImpl implements OfficeCtl {
    OnlyOfficeProperties officeProps;

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
    public ModelAndView previewRemoteFile(String remoteUrl, HttpServletResponse servletResponse) {
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
        // 配置模式
        EditorConfig editorConfig = new EditorConfig();
        editorConfig.setMode("view");
        // 构建 Editor
        DocEditor docEditor = new DocEditor();
        docEditor.setDocument(document);
        docEditor.setDocumentType(getDocumentType(document.getFileType()));
        docEditor.setEditorConfig(editorConfig);
        docEditor.setHeight("100%");
        docEditor.setWeight("100%");
        return previewFile(docEditor,servletResponse);
    }

    @SneakyThrows
    @Override
    public ModelAndView previewRemoteFile(String remoteUrl) {
        return previewRemoteFile(remoteUrl,null);
    }

    @SneakyThrows
    @Override
    public ModelAndView previewRemoteFileOnMobile(String remoteUrl) {
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
        // 配置模式
        EditorConfig editorConfig = new EditorConfig();
        editorConfig.setMode("view");
        // 构建 Editor
        DocEditor docEditor = new DocEditor();
        docEditor.setDocument(document);
        docEditor.setDocumentType(getDocumentType(document.getFileType()));
        docEditor.setEditorConfig(editorConfig);
        docEditor.setHeight("100%");
        docEditor.setWeight("100%");
        //设置移动端
        docEditor.setType("mobile");
        return previewFile(docEditor);
    }

    @SneakyThrows
    @Override
    public ModelAndView previewFile(DocEditor editor, HttpServletResponse servletResponse) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("OfficeView");
        modelAndView.addObject("editor",editor);
        modelAndView.addObject("title",editor.getDocument().getTitle());
        modelAndView.addObject("apiJs",officeProps.getApiJs());
        return modelAndView;
    }

    @Override
    public ModelAndView previewFile(DocEditor editor) {
        return previewFile(editor,null);
    }
}
