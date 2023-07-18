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
    /** 1:建立编辑连接 0：断开连接 */
    private int type;
    /** 共同编辑文档时 连接或断开连接的用户id */
    private String userid;
}
