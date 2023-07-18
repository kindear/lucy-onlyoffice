package org.lboot.onlyoffice.config;

import cn.hutool.core.lang.Validator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.lboot.onlyoffice.loader.OfficeConfigLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author kindear
 * onlyoffice 参数配置
 */
@Data
@Slf4j
@Configuration("onlyoffice")
public class OnlyOfficeProperties {

    OfficeConfigLoader configLoader;

    @Value("${onlyoffice.document.host}")
    private String officeDocumentHost;

    @Value("${onlyoffice.document.callback.host}")
    private String officeDocumentCallbackUrl;

    /**
     * 获取接口地址
     * @return
     */
    public String getOfficeDocumentApiJs(){
        return officeDocumentHost.concat("/web-apps/apps/api/documents/api.js");
    }

    /**
     * 获取编辑修改回调地址
     * @return
     */
    public String getCallbackUrl(){
        // 配置文件为空
        if (Validator.isEmpty(officeDocumentCallbackUrl)){
            return configLoader.getCallbackUrl();
        }
        return officeDocumentCallbackUrl;
    }
}
