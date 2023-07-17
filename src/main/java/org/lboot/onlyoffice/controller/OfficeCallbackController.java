package org.lboot.onlyoffice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author kindear
 * 回调接口
 */
@Slf4j
@RestController
@RequestMapping("office")
public class OfficeCallbackController {

    @PostMapping("callback")
    public Object officeCallBack(@RequestBody Map<String,Object> params){
        log.info(params.toString());
        return null;
    }
}
