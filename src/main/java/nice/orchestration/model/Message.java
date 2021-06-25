package nice.orchestration.model;

import java.io.Serializable;
import java.util.List;

public class Message implements Serializable {

	private static final long serialVersionUID = -4745876900790768364L;

	private String code;
	private String type;
	private String description;
	private String severity;
	private List<Serializable> sources;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public List<Serializable> getSources() {
		return sources;
	}

	public void setSources(List<Serializable> sources) {
		this.sources = sources;
	}

}
