package learn.springcloud.controller;

import java.util.HashMap;
import java.util.Map;

import learn.springcloud.feignapi.user.User;
import learn.springcloud.feignapi.user.UserRemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	private UserRemoteClient userRemoteClient;

	@GetMapping("/call")
	public String callHello() {
		String result = userRemoteClient.getName();
		System.out.println("getName调用结果：" + result);
		
		result = userRemoteClient.getUserInfo("yinjihuan1");
		System.out.println("getUserInfo调用结果：" + result);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "yinjihuan2");
		result = userRemoteClient.getUserDetail(param);
		System.out.println("getUserDetail调用结果：" + result);
		
		User user = new User();
		user.setName("yinjihuan3");
		result = userRemoteClient.addUser(user);
		System.out.println("addUser调用结果：" + result);
		return result;
	}
	

}
