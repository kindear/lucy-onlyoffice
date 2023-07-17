package org.lboot.onlyoffice.config;

import org.lboot.onlyoffice.loader.DefaultOfficeConfigLoader;
import org.lboot.onlyoffice.loader.OfficeConfigLoader;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author kindear
 * 基础服务实现
 */
@SpringBootConfiguration
public class OfficeServiceConfig {
    // 默认预览方式选择
    @Bean
    @ConditionalOnMissingBean(value = OfficeConfigLoader.class)
    public OfficeConfigLoader officeConfigLoader(){
        return new DefaultOfficeConfigLoader();
    }
}
