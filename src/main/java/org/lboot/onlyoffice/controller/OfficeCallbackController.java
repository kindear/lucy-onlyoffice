package org.lboot.onlyoffice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lboot.onlyoffice.service.OfficeCtl;
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
@AllArgsConstructor
public class OfficeCallbackController {
    OfficeCtl officeCtl;

    @PostMapping("callback")
    public Object officeCallBack(@RequestBody Map<String,Object> params){
        return officeCtl.editCallback(params);
    }
}
