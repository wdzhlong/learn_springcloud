package learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @author zhl
 * Eureka客户端示列
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientArticleApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientArticleApplication.class, args);
	}
}