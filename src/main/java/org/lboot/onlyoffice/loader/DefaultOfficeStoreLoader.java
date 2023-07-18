package org.lboot.onlyoffice.loader;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lboot.onlyoffice.domain.Document;

import java.io.InputStream;

/**
 * @author kindear
 * Office 第三方存储系统实现
 */
@Slf4j
@AllArgsConstructor
public class DefaultOfficeStoreLoader implements OfficeStoreLoader{
    @Override
    public Document readFile(String fileKey) {
        log.error("请实现OfficeStoreLoader");
        return null;
    }

    @Override
    public boolean writeFile(String fileKey, InputStream stream) {
        log.error("请实现OfficeStoreLoader");
        return false;
    }
}
