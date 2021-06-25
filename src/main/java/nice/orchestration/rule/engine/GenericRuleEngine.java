package nice.orchestration.rule.engine;

import java.util.Date;

public interface GenericRuleEngine {

	public String getNextEndpoint(String process, String channel, Date insertDate, String previousEndpoint) throws Exception;

	
	public boolean invalidRules();
}
