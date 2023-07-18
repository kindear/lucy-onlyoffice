package org.lboot.onlyoffice.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kindear
 * 转化结果
 * {
 *     "fileUrl": "http://office.apisev.cn/cache/files/conv_Khirz6zTPdfd7_pdf/output.pdf/outx.pdf?md5=aYyfdCu5ST7vPJVvpDy74Q&expires=1689682859&filename=outx.pdf",
 *     "percent": 100,
 *     "endConvert": true
 * }
 */
@Data
@ApiModel(value = "文档转化结果")
public class OfficeConvertResult {

    @ApiModelProperty(value = "转化文件下载地址")
    String fileUrl;

    @ApiModelProperty(value = "转化进度")
    Integer percent;

    @ApiModelProperty(value = "转化是否结束")
    Boolean endConvert;
}
