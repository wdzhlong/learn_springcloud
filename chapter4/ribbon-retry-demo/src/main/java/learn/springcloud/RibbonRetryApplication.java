package learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Ribbon重试示列
 */
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonRetryApplication {
	public static void main(String[] args) {
		SpringApplication.run(RibbonRetryApplication.class, args);
	}
}