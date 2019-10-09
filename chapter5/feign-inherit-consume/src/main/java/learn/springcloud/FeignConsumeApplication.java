package learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Feign示列
 */
@EnableDiscoveryClient
// 开启Feign,如果Feign接口定义跟启动类不在同一个包名下，还需要制定扫描的包名
@EnableFeignClients(basePackages= {"learn.springcloud.feignapi"})
@SpringBootApplication
public class FeignConsumeApplication {
	public static void main(String[] args) {
		SpringApplication.run(FeignConsumeApplication.class, args);
	}
}