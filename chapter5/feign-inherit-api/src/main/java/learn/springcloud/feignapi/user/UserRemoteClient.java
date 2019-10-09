package learn.springcloud.feignapi.user;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign客户端定义
 * @FeignClient:标识当前是一个Feign客户端，value属性是对应的服务名称，也就是你需要调用哪个服务中的接口
 */
@FeignClient("feign-inherit-provide")
public interface UserRemoteClient {
	
	@GetMapping("/user/name")
	String getName();
	
	@GetMapping("/user/info")
	String getUserInfo(@RequestParam("name")String name);
	
	@GetMapping("/user/detail")
	String getUserDetail(@RequestParam Map<String, Object> param);
	
	@PostMapping("/user/add")
	String addUser(@RequestBody User user);
	
}
