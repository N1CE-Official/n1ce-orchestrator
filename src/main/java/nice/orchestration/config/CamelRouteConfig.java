package nice.orchestration.config;


import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import nice.orchestration.model.camel.CamelProcess;
import nice.orchestration.model.camel.Step;

public class CamelRouteConfig {
	private static final String PREFIX_CAMEL_ROUTE_DIRECT = "direct://";
	private CamelRouteConfig () {}
	

	private static final Logger log = LoggerFactory.getLogger(CamelRouteConfig.class);

	public static YamlRoutesConfig getCamelRoutes(String ymlFileName) throws IOException {
		Map<String, CamelProcess> map = null;
		YamlRoutesConfig data = null;
		Constructor constructor = new Constructor(YamlRoutesConfig.class);
		Yaml yaml = new Yaml(constructor);
		Resource resource = new ClassPathResource(ymlFileName);
        InputStream inputStream = resource.getInputStream();
		data = yaml.loadAs(inputStream, YamlRoutesConfig.class);
		
		if (data != null) {
			map = data.getRoutesMap();
			for (Entry<String, CamelProcess> pair : map.entrySet()) {
				CamelProcess cm = pair.getValue();
				if (cm != null && CollectionUtils.isNotEmpty(cm.getSteps())) {
					cm.setSteps(cm.getSteps().stream().sorted(Step.ASCENDING_COMPARATOR).collect(Collectors.toList()));
					cm.getSteps().forEach(f -> {
						if (f.getRoute() != null) {
							f.setRoute(PREFIX_CAMEL_ROUTE_DIRECT + f.getRoute().trim());
						}
					});
				}
				log.info("La mappa caricata è :" + data.toString());
			}
		}
		
		return data;
	}
}
