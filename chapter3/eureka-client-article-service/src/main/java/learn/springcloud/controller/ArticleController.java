package learn.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

@RestController
public class ArticleController {

	@Autowired 	
	private RestTemplate restTemplate;  	

	@Autowired     
	private DiscoveryClient discoveryClient;
	/**
	 * 获取想要的Eureka数据
	 */
	@Autowired
	private EurekaClient eurekaClient;
	
	@GetMapping("/article/infos")     
	public Object serviceUrl() {
		return eurekaClient.getInstancesByVipAddress("eureka-client-user-service", false);
		//return discoveryClient.getInstances("eureka-client-user-service");     
	}

	@GetMapping("/article/callHello") 	
	public String callHello() { 		
	    return restTemplate.getForObject(
			"http://localhost:8081/user/hello", String.class); 	
	}
	
	@GetMapping("/article/callHello2") 	
	public String callHello2() {
		// 通过eureka服务来调用
	    return restTemplate.getForObject(
			"http://eureka-client-user-service/user/hello", String.class); 	
	}
	
}
