package nice.orchestration.rule.engine;

import nice.orchestration.model.camel.CamelProcess;

public interface RuleLoader {

	
	public CamelProcess retrieveConfigurations(String process, String channel) throws Exception;
}
