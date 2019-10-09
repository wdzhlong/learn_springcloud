package learn.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import learn.springcloud.loadbalanced.MyLoadBalanced;

@Configuration
public class BeanConfiguration {
	/**
	 * @LoadBalanced:具有负载均衡的能力
	 */
	@Bean
	//@LoadBalanced
	@MyLoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
