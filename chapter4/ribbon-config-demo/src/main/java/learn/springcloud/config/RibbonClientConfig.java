package learn.springcloud.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 为某个客户端指定配置
 */
@RibbonClient(name = "ribbon-config-demo", configuration = BeanConfiguration.class) 
public class RibbonClientConfig {  

}
