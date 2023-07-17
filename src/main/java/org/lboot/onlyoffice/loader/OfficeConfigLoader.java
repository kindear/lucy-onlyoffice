package org.lboot.onlyoffice.loader;

/**
 * @author kindear
 * OnlyOffice配置加载
 */
public interface OfficeConfigLoader {
    /**
     * 获取客制化LOGO地址
     * @return
     */
    @Deprecated
    default String getCustomLogo(){
        return "";
    }

    /**
     * 获取默认语言
     * 默认 zh-CN 中文
     * @return
     */
    default String getLang(){
        return "zh-CN";
    }

}
