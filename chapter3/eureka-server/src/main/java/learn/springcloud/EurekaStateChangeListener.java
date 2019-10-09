package learn.springcloud;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;

/**
 * 服务上下线监控：
 * 在某些特定的需求下，我们需要对服务的上下线进行监控，上线或下线都进行邮件通知，Eureka中提供了事件监听的方式来扩展
 */
@Component
public class EurekaStateChangeListener {
	/**
	 * EurekaInstanceCanceledEvent:服务下线事件
	 * @param event
	 */
	@EventListener
	public void listen(EurekaInstanceCanceledEvent event) {
		System.err.println(event.getServerId() + "\t" + event.getAppName() + " 服务下线");
	}

	/**
	 * EurekaInstanceRegisteredEvent:服务注册事件
	 * @param event
	 */
	@EventListener
	public void listen(EurekaInstanceRegisteredEvent event) {
		InstanceInfo instanceInfo = event.getInstanceInfo();
		System.err.println(instanceInfo.getAppName() + "进行注册");
	}

	/**
	 * 服务续约事件
	 * @param event
	 */
	@EventListener
	public void listen(EurekaInstanceRenewedEvent event) {
		System.err.println(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约");
	}

	/**
	 * Eureka注册中心启动事件
	 * @param event
	 */
	@EventListener
	public void listen(EurekaRegistryAvailableEvent event) {
		System.err.println("注册中心 启动");
	}

	/**
	 * Eureka Server启动事件
	 * @param event
	 */
	@EventListener
	public void listen(EurekaServerStartedEvent event) {
		System.err.println("Eureka Server 启动");
	}

}
