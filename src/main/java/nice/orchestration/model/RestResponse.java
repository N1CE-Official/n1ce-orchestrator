package nice.orchestration.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RestResponse<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = -4251462977831091358L;

	private List<Message> errors;
	private List<Message> warnings;
	private List<Message> info;
	private T data;

	public RestResponse() {
	}

	public RestResponse(T data) {
		this.data = data;
	}

	public void addError(Message msg) {
		if (errors == null) {
			errors = new ArrayList<>();
		}
		errors.add(msg);
	}

	public List<Message> getErrors() {
		return errors;
	}



	public void setErrors(List<Message> errors) {
		this.errors = errors;
	}

	public List<Message> getWarnings() {
		return warnings;
	}

	public void setWarnings(List<Message> warnings) {
		this.warnings = warnings;
	}

	public List<Message> getInfo() {
		return info;
	}

	public void setInfo(List<Message> info) {
		this.info = info;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "RestResponse [errors=" + errors + ", warnings=" + warnings + ", info=" + info + ", data=" + data + "]";
	}

}
