package org.lboot.onlyoffice.controller;

import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.lboot.onlyoffice.service.OfficeCtl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kindear
 * office 测试 API
 */
@Slf4j
@Controller
@RequestMapping("office")
@Api(tags = "OnlyOffice相关服务")
@AllArgsConstructor
public class OnlyOfficeController {
    OfficeCtl officeCtl;

    @SneakyThrows
    @RequestMapping("preview/remote")
    @ApiOperation(value = "网络文档预览",notes = "支持各种类型文档")
    public ModelAndView previewRemote(@RequestParam("url") String url) {
        return officeCtl.previewRemoteFile(url);
    }
}
