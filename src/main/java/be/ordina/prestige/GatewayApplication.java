package be.ordina.prestige;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableRetry
public class GatewayApplication  {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
