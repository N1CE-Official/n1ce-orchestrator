package nice.orchestration.config;

import java.io.IOException;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig {


	@Autowired
	private CamelContext camelContext;

	
	@Bean
	public YamlRoutesConfig ymlRoutesConfig() throws IOException {
		return CamelRouteConfig.getCamelRoutes("camel-routes.yml");
	}
	
}