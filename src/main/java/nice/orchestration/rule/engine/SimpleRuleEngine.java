package nice.orchestration.rule.engine;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nice.orchestration.model.camel.CamelProcess;
import nice.orchestration.model.camel.Step;

@Service
public class SimpleRuleEngine implements GenericRuleEngine {
	private static final String INIT_ENDPOINT = "init";

	@Autowired
	private RuleLoader ruleLoader;
	
	private static final Logger log = LoggerFactory.getLogger(ComponentDynamicRouterBean.class);


	
	@Override
	public String getNextEndpoint(String processName, String channel, Date insertDate, String previousEndpoint) throws Exception {
		log.debug("SimpleRuleEngine - START getNextEndpoint with process {} channel {} insertDate {} previousEndpoint {} ", processName, channel, insertDate, previousEndpoint);

		CamelProcess process = ruleLoader.retrieveConfigurations(processName, channel);
		
		Step nextStep = retrieveConfigurationStep(processName, process , previousEndpoint);
		
		String nextEndpoint = nextStep != null ? nextStep.getRoute() : null;
		
		log.debug("SimpleRuleEngine - END getNextEndpoint with process {} channel {} insertDate {} nextEndpoint {} ", process, channel, insertDate, nextEndpoint);
		return nextEndpoint != null ? nextEndpoint : ComponentDynamicRouterBean.FINISH_PROCESS_STATE;

	}
	
	
	
	private Step retrieveConfigurationStep(String processName, CamelProcess camelProcess, String previousEndpoint) {

		List<Step> configurationSteps = camelProcess.getSteps();

		Optional<Step> optionalNextEndpoint = null;
		Step configurationStep = null;
		if (INIT_ENDPOINT.equals(previousEndpoint)) {
			optionalNextEndpoint = configurationSteps.stream().filter(conf -> conf.getPosition() == 1 ).findAny();			
		} 
		
		else {
			Optional<Step> optionalConfigurationStep = configurationSteps.stream().filter(conf -> conf.getRoute().equals(previousEndpoint)).findAny();
			if (optionalConfigurationStep.isPresent()) {
				configurationStep = optionalConfigurationStep.get();
				int orderConf = configurationStep.getPosition();
				 optionalNextEndpoint = configurationSteps.stream().filter(conf -> conf.getPosition() == (orderConf + 1)).findAny();
				
			}
			
			else {
				log.error("SimpleRuleEngine - error in configurationRule {} ", processName);
				return null;
			}	
			
		}

		if (optionalNextEndpoint.isPresent()) {
			log.info("nextEndpoint: {}", optionalNextEndpoint.get());
			return optionalNextEndpoint.get();
		}
		
		else
			return null;

	}



	@Override
	public boolean invalidRules() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	
}
