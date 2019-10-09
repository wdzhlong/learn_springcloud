package learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 服务提供者
 * @EnableDiscoveryClient：表示当前服务是一个Eureka的客户端
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientUserApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientUserApplication.class, args);
	}
}