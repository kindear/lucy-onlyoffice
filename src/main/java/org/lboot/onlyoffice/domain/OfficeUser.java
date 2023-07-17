package org.lboot.onlyoffice.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户信息")
public class OfficeUser {
    @ApiModelProperty("用户ID")
    String id;

    @ApiModelProperty("用户名称")
    String name;
}
