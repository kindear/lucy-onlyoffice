package org.lboot.onlyoffice.service;

import org.lboot.onlyoffice.domain.DocEditor;
import org.lboot.onlyoffice.domain.Document;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author kindear
 * onlyoffice 服务实现类
 */
public interface OfficeCtl {
    /**
     * 根据文件后缀 获取office 中类型
     * @param extName
     * @return 文件类型
     */
     String getDocumentType(String extName);

    /**
     * 构建远程文档访问 Document
     * @param remoteUrl
     * @return
     */
     Document buildRemoteDocument(String remoteUrl);

    /**
     * 构建文档预览 DocEditor
     * @param document
     * @return
     */
     DocEditor buildPreviewDocEditor(Document document);

    /**
     * 构建文档编辑 DocEditor
     * @param document
     * @return
     */
     DocEditor buildEditDocEditor(Document document);

    /**
     * 预览远程文件
     * @return file-temp
     */
    @Deprecated
    ModelAndView previewRemoteFile(String remoteUrl, HttpServletResponse servletResponse);

    /**
     * 预览远程文件
     * @param remoteUrl
     * @return
     */
     ModelAndView previewRemoteFile(String remoteUrl);

    /**
     * 移动端预览远程文件
     * @param remoteUrl
     * @return
     */
     ModelAndView previewRemoteFileOnMobile(String remoteUrl);

    /**
     * 嵌入式预览远程文件
     * @param remoteUrl
     * @return
     */
     ModelAndView previewRemoteFileOnEmbedded(String remoteUrl);

    /**
     * 文件预览
     * @param editor
     * @return
     */
    ModelAndView previewFile(DocEditor editor);

    /**
     * 文件预览 制定预览标题
     * @param editor
     * @param title
     * @return
     */
    ModelAndView previewFile(DocEditor editor, String title);


    /**
     * 编辑远程文件
     * @param remoteUrl
     * @return
     */
    ModelAndView editRemoteFile(String remoteUrl);

    /**
     * 文件编辑
     * @param editor
     * @return
     */
    ModelAndView editFile(DocEditor editor);

}
