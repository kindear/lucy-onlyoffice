package org.lboot.onlyoffice.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "编辑配置")
public class EditorConfig {
    @ApiModelProperty("回调地址")
    String callbackUrl;

    @ApiModelProperty("编辑用户")
    OfficeUser user;

    // 预览就是 view
    @ApiModelProperty("模式")
    String mode;

    @ApiModelProperty("语言")
    String lang = "zh-CN";
}
