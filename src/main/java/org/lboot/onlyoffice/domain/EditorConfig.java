package org.lboot.onlyoffice.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class EditorConfig {
    @ApiModelProperty("回调地址")
    String callbackUrl;

    // 预览就是 view
    @ApiModelProperty("模式")
    String mode;
}
