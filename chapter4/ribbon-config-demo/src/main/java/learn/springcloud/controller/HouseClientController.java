package learn.springcloud.controller;

import learn.springcloud.dto.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HouseClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	

	@GetMapping("/call/data")     
	public HouseInfo getData(@RequestParam("name") String name) {
	    return restTemplate.getForObject(
	    		"http://ribbon-config-demo/house/data?name="+name, HouseInfo.class);     
	}       


}
