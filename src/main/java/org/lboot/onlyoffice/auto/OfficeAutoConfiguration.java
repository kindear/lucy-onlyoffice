package org.lboot.onlyoffice.auto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

/**
 * @author kindear
 * office 模块
 */
@Slf4j
@AutoConfiguration
@ComponentScan(basePackages = {
        "org.lboot.onlyoffice"
})
public class OfficeAutoConfiguration implements EnvironmentAware {
    @Override
    public void setEnvironment(Environment environment) {
        // 此处注册全局环境
    }
}
