package org.lboot.onlyoffice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.lboot.onlyoffice.service.OfficeCtl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("office")
@Api(tags = "OnlyOffice相关服务")
@AllArgsConstructor
@ConditionalOnProperty(prefix = "onlyoffice.api",name = "enable",havingValue = "true")
public class OnlyOfficeRestController {

    OfficeCtl officeCtl;

    @SneakyThrows
    @GetMapping("covert/pdf")
    @ApiOperation(value = "网络文档转pdf")
    public String covertPdf(@RequestParam("url") String url){
        return officeCtl.covertToPdf(url);
    }
    @SneakyThrows
    @GetMapping("covert/png")
    @ApiOperation(value = "网络文档生成png")
    public String covertPng(@RequestParam("url") String url){
        return officeCtl.generateThumbnail(url);
    }
}
