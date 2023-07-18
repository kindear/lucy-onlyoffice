package org.lboot.onlyoffice.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author kindear
 * Office 文档转化参数
 */
@Slf4j
@Data
@ApiModel(value = "文档转化参数")
public class OfficeConvertParams {
    @ApiModelProperty(value = "异步执行")
    Boolean async;

    @ApiModelProperty(value = "文件类型",example = "docx")
    String filetype;

    @ApiModelProperty(value = "文件Key")
    String key;

    @ApiModelProperty(value = "输出文件类型")
    String outputtype;

    @ApiModelProperty(value = "文件标题")
    String title;

    @ApiModelProperty(value = "文件下载地址")
    String url;

    /**
     * 根据 office Document 构建
     * @param document
     */
    public OfficeConvertParams(Document document){
        // 设置为同步
        this.async = false;
        // filetype
        this.filetype = document.getFileType();
        this.key = document.getKey();
        this.title = document.getTitle();
        this.url = document.getUrl();
    }

    public OfficeConvertParams(){

    }
}
