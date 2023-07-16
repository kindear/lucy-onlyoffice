package org.lboot.onlyoffice.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * onlyoffice定义的文档对象
 * @author: zhangcx
 * @date: 2019/8/7 16:30
 */

/**
 * @author kindear
 * 与 disk 进行集成
 */
@Data
@ApiModel("文档实体")
public class Document implements Serializable {

    /** 【必需】文件唯一标识 */
    @ApiModelProperty(value = "文档 key", example="xYz123")
    private String key;

    /** 【必需】文档名称 */
    @ApiModelProperty(value = "文档标题", example="test.doc")
    private String title;

    /** 【必需】 文档后缀 **/
    @ApiModelProperty(value = "文档类型", example="doc")
    private String fileType;

    /** 【必需】 文档资源地质 **/
    @ApiModelProperty(value = "文档获取url", example="http://10.4.89.60:8080/api/file/xYz123")
    private String url;
}
