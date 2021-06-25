package nice.orchestration.model;

import java.io.Serializable;

public class ErrorData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String code ;
	private String description;
	
	public ErrorData(){
		//Don't need to be initialized
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ErrorData [code=" + code + ", description=" + description + "]";
	}

	public ErrorData(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}
	
	

}
