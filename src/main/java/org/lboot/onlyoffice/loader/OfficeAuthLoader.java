package org.lboot.onlyoffice.loader;

/**
 * @author kindear
 * Office 鉴权信息加载
 */
public interface OfficeAuthLoader {
    /**
     * 获取当前登录用户ID
     * @return
     */
    default String getUserId(){
        return "0";
    }

    /**
     * 获取当前登录用户名称
     * @return
     */
    default String getUserName(){
        return "guest";
    }
}
