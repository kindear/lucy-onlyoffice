package org.lboot.onlyoffice.service;

import org.lboot.onlyoffice.domain.DocEditor;
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
    public String getDocumentType(String extName);

    /**
     * 预览远程文件
     * @return file-temp
     */
    @Deprecated
    public ModelAndView previewRemoteFile(String remoteUrl, HttpServletResponse servletResponse);

    /**
     * 预览远程文件
     * @param remoteUrl
     * @return
     */
    public ModelAndView previewRemoteFile(String remoteUrl);

    /**
     * 移动端预览远程文件
     * @param remoteUrl
     * @return
     */
    public ModelAndView previewRemoteFileOnMobile(String remoteUrl);

    /**
     * 文件预览
     * @param editor
     * @param servletResponse
     * @return
     */
    @Deprecated
    public ModelAndView previewFile(DocEditor editor, HttpServletResponse servletResponse);

    /**
     * 文件预览
     * @param editor
     * @return
     */
    public ModelAndView previewFile(DocEditor editor);
}
