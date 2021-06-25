package nice.orchestration.rule.engine;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nice.orchestration.config.YamlRoutesConfig;
import nice.orchestration.model.camel.CamelProcess;

@Service
public class YmlRuleLoader implements RuleLoader {

	private static final Logger log = LoggerFactory.getLogger(YmlRuleLoader.class);


	@Autowired 
	private YamlRoutesConfig yamlRoutesConfig;


	@Override
	public CamelProcess retrieveConfigurations(String processName, String channel) throws Exception {
		log.info("YmlRuleLoader - start retrieveConfigurations from process {} ", processName);
		//recupero tutte le regole per il processo
		log.debug("Trying to find relus for Process: {}, Channel: {}", processName, channel);
		CamelProcess process = null;
		Map<String,CamelProcess> camelList = yamlRoutesConfig.getRoutesMap();

		if(camelList == null) {
			throw new Exception ("yml list is empty!");
		}
		process = camelList.get(processName);
		if(process == null){
			throw new Exception("Cannot find process: "+ processName);
		}

		return process ; 
	}

}
