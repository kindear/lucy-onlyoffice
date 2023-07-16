package org.lboot.onlyoffice.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kindear
 * 文档编辑器
 * 2023-07-14
 */
@Data
@ApiModel(value = "文档编辑参数")
public class DocEditor {

    @ApiModelProperty("文档基础信息")
    Document document;

    // 使用 OfficeCtl 中方法获取
    @ApiModelProperty("文档类型")
    String documentType;

    // mobile 是在移动设备预览
    @ApiModelProperty("类型")
    String type;

    @ApiModelProperty("模式配置")
    EditorConfig editorConfig;


    @ApiModelProperty(value = "高度设置",name = "100%")
    String height;

    @ApiModelProperty(value = "宽度设置",name = "100%")
    String weight;
}
