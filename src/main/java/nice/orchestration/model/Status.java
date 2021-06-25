package nice.orchestration.model;


public enum Status {

	OK("OK");
	
	
	private final String description;

	private Status(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	
}
