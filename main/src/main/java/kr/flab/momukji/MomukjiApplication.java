package kr.flab.momukji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MomukjiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MomukjiApplication.class, args);
	}
}
