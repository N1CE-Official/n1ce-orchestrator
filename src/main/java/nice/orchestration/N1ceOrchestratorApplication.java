package nice.orchestration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableAutoConfiguration
//@ComponentScan(basePackages = "nice.orchestration")
@ComponentScan(basePackages = {"nice.orchestration.config", "nice.orchestration.controller"})
public class N1ceOrchestratorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(N1ceOrchestratorApplication.class, args);
	}


}
