package nice.orchestration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableAutoConfiguration
//@ComponentScan(basePackages = "nice.orchestration")
@ComponentScan(basePackages = {"nice.orchestration.config", "nice.orchestration.controller","nice.orchestration.processor"})
public class N1ceOrchestratorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(N1ceOrchestratorApplication.class, args);
	}
	
	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
		return new OpenAPI()
				.components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info().title("N1ceOrchestrator API").description("N1ceOrchestrator API").version(appVersion));
	}


}
