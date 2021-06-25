package nice.orchestration.rule.engine;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nice.orchestration.payload.OrchestrationPayload;
import nice.orchestration.util.ProcessorUtil;


@Component
public class ComponentDynamicRouterBean {
	public static final String FINISH_PROCESS_STATE = "STOP";
	
	private static final Logger log = LoggerFactory.getLogger(ComponentDynamicRouterBean.class);

	@Autowired
	private GenericRuleEngine ruleEngine;

	public String route(Exchange exchange, @Header(Exchange.SLIP_ENDPOINT) String previous) throws Exception {

		String previousEndpoint = previous == null ? "init" : previous;
		OrchestrationPayload orchestrationBody = (OrchestrationPayload) exchange
				.getProperty(ProcessorUtil.ORCHESTRATION_DATA_PROPERTY_NAME);

		log.info("Enter DynamicRouterBean, route={}, with previous={}", orchestrationBody.getProcess(),previousEndpoint);

		String nextEndpoint = ruleEngine.getNextEndpoint(orchestrationBody.getProcess(), orchestrationBody.getChannel(), orchestrationBody.getInsertDate(), previousEndpoint);
		return FINISH_PROCESS_STATE.equals(nextEndpoint) ? null : nextEndpoint;
	}
}