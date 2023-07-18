package org.lboot.onlyoffice.loader;

import org.lboot.onlyoffice.domain.Document;

import java.io.InputStream;

/**
 * @author kindear
 * office 文档存储服务
 * 该服务与第三方或者本地文件系统集成
 */
public interface OfficeStoreLoader {
    /**
     * 根据文件 key 获取文件信息
     * @param fileKey
     * @return
     */
    Document readFile(String fileKey);

    /**
     * 修改文件
     * @param fileKey
     * @param stream
     * @return
     */
    boolean writeFile(String fileKey, InputStream stream);

}
