package learn.springcloud.config;

import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * 默认配置
 */
@RibbonClients(defaultConfiguration = DefaultRibbonConfig.class)
public class RibbonClientDefaultConfigurationTestsConfig {

  
}