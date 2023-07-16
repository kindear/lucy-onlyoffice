package org.lboot.onlyoffice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author kindear
 * onlyoffice 参数配置
 */
@Configuration("onlyoffice")
public class OnlyOfficeProperties {

    @Value("${onlyoffice.document.host}")
    private String officeDocumentHost;

    /**
     * 获取接口地址
     * @return
     */
    public String getApiJs(){
        return officeDocumentHost.concat("/web-apps/apps/api/documents/api.js");
    }

    /**
     * 获取服务地址
     * @return
     */
    public String getHost(){
        return officeDocumentHost;
    }
}
