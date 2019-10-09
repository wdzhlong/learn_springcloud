package learn.springcloud.demo2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import learn.springcloud.demo1.MyHystrixCommand;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

public class CacheApp {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		HystrixRequestContext context = HystrixRequestContext.initializeContext();
		String result = new MyHystrixCommand("yinjihuan").execute();
		System.out.println(result);
		Future<String> future = new MyHystrixCommand("yinjihuan").queue();
		System.out.println(future.get());
		context.shutdown();

	}
}
