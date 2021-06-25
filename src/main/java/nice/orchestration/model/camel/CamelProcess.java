package nice.orchestration.model.camel;

import java.util.List;

public class CamelProcess {
	
	private String description;
	private List<Step> steps;
	
	
	public CamelProcess() {
		
	}
	
	public CamelProcess(String description, List<Step> steps) {
		super();
		this.description = description;
		this.steps = steps;
		
	}
	
	public String getDescription() {
		return description;
	}
	
	public List<Step> getSteps() {
		return steps;
	}
	
	
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		return "CamelProcess [description=" + description + ", steps=" + steps + "]";
	}

	
	
	
}
