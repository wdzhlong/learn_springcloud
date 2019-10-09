package learn.springcloud.config;

import learn.springcloud.auth.FeignBasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfiguration {
	/**
	 * Feign日志配置
	 * 日志级别
	 * @return
	 */
	@Bean
	Logger.Level feignLoggerLevel() {
		// NONE:不输出日志
		// BASIC:只输出请求方法的URL和响应的状态码以及接口执行的时间
		// HEADERS:将BASIC信息和请求头信息输出
		// FULL:输出完整的请求信息
		return Logger.Level.FULL;
	}

	/**
	 * 配置basic认证
	 * @return
	 */
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("user", "password");
	}

	/**
	 * 自定义拦截
	 * @return
	 */
	@Bean
	public FeignBasicAuthRequestInterceptor feignBasicAuthRequestInterceptor() {
		return new FeignBasicAuthRequestInterceptor();
	}

	/**
	 * 超时时间配置
	 * @return
	 */
	@Bean
	public Request.Options options() {
		// 第一个参数是连接超时时间(ms),默认是10*1000,
		// 第二个参数是取超时时间(ms)，默认是60*1000
		return new Request.Options(5000, 10000);
	}

}
