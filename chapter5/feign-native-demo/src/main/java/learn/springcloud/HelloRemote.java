package learn.springcloud;

import feign.RequestLine;

public interface HelloRemote {
	
	@RequestLine("GET /user/hello") 
	String hello();
	
}
