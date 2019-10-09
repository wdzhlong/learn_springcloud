package learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * Eureka注册中心，实现服务治理功能
 * Eureka是基于AP原则构建的
 * CAP定理：C为数据一致性，A为服务可用性，P为服务对网络分区故障的容错性。这三个特性在任何分布式系统中
 * 都不能同时满足，最多同时满足2个
 * 保证AP用Eureka,保证CP用zookeeper
 *
 * @EnableEurekaServer:表示开启Eureka Server
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
	
	@Configuration
	@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	//关闭csrf
	        http.csrf().disable();
	        // 支持httpBasic
	        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	    }
	}
	
}
