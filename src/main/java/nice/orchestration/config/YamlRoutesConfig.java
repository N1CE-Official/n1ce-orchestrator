package nice.orchestration.config;

import java.util.Map;

import nice.orchestration.model.camel.CamelProcess;

public class YamlRoutesConfig {
	
	String version;
	Map<String, CamelProcess> routesMap;
	
	public YamlRoutesConfig() {
		//Don't need to be initialized
	}
	

	public Map<String, CamelProcess> getRoutesMap() {
		return routesMap;
	}



	public void setRoutesMap(Map<String, CamelProcess> routesMap) {
		this.routesMap = routesMap;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	@Override
	public String toString() {
		return "YamlRoutesConfig [version=" + version + ", routesMap=" + routesMap + "]";
	}
	
	
	
	
	
	
}
