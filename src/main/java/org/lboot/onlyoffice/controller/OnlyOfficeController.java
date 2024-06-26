package org.lboot.onlyoffice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.lboot.onlyoffice.service.OfficeCtl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author kindear
 * office 测试 API
 */
@Slf4j
@Controller
@RequestMapping("office")
@Api(tags = "OnlyOffice相关服务")
@AllArgsConstructor
@ConditionalOnProperty(prefix = "onlyoffice.api",name = "enable",havingValue = "true")
public class OnlyOfficeController {
    OfficeCtl officeCtl;

    @SneakyThrows
    @RequestMapping("preview/remote")
    @ApiOperation(value = "网络文档预览",notes = "支持各种类型文档")
    public ModelAndView previewRemote(@RequestParam("url") String url) {
        return officeCtl.previewRemoteFile(url);
    }

    @SneakyThrows
    @RequestMapping("preview/mobile/remote")
    @ApiOperation(value = "网络文档预览(移动端)",notes = "支持各种类型文档")
    public ModelAndView previewRemoteOnMobile(@RequestParam("url") String url) {
        return officeCtl.previewRemoteFileOnMobile(url);
    }

    @SneakyThrows
    @RequestMapping("preview/embedded/remote")
    @ApiOperation(value = "网络文档预览(嵌入)",notes = "支持各种类型文档")
    public ModelAndView previewRemoteOnEmbedded(@RequestParam("url") String url) {
        return officeCtl.previewRemoteFileOnEmbedded(url);
    }

    @SneakyThrows
    @RequestMapping("preview/{id}")
    @ApiOperation(value = "文档预览(存储系统)")
    public ModelAndView preview(@PathVariable("id") String id){
        return officeCtl.previewFile(id);
    }

    @SneakyThrows
    @RequestMapping("edit/remote")
    @ApiOperation(value = "网络文档编辑",notes = "支持各种类型文档")
    public ModelAndView editRemote(@RequestParam("url") String url){
        return officeCtl.editRemoteFile(url);
    }

    @SneakyThrows
    @RequestMapping("edit/{id}")
    @ApiOperation(value = "文档编辑(存储系统)",notes = "支持word,excel等")
    public ModelAndView edit(@PathVariable("id") String id){
        return officeCtl.editFile(id);
    }
}
