package learn.springcloud.auth;


import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Feign自定义拦截器
 */
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
	
	public FeignBasicAuthRequestInterceptor() {

	}

	/**
	 * 业务逻辑处理
	 * @param template
	 */
	@Override
	public void apply(RequestTemplate template) {
		System.err.println("进入拦截器了");
	}

}
