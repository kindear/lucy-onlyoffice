package org.lboot.onlyoffice.config;

import org.lboot.onlyoffice.loader.DefaultOfficeAuthLoader;
import org.lboot.onlyoffice.loader.DefaultOfficeConfigLoader;
import org.lboot.onlyoffice.loader.OfficeAuthLoader;
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
    // 默认Office配置
    @Bean
    @ConditionalOnMissingBean(value = OfficeConfigLoader.class)
    public OfficeConfigLoader officeConfigLoader(){
        return new DefaultOfficeConfigLoader();
    }

    // 默认Office鉴权
    @Bean
    @ConditionalOnMissingBean(value = OfficeAuthLoader.class)
    public OfficeAuthLoader officeAuthLoader(){
        return new DefaultOfficeAuthLoader();
    }
}
