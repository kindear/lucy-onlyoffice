package org.lboot.onlyoffice.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author kindear
 */
@Slf4j
@Data
@ApiModel(value = "多用户编辑实体")
public class ActionBean {
    /**
     * 0 - 用户断开与文档共同编辑的连接，
     * 1 - 新用户连接到文档共同编辑，
     * 2 - 用户单击 强制保存按钮。
     */
    private int type;
    /** 共同编辑文档时 连接或断开连接的用户id */
    private String userid;
}
