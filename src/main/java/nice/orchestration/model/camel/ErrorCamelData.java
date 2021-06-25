
package nice.orchestration.model.camel;

import nice.orchestration.model.ErrorData;
import nice.orchestration.model.Status;


public class ErrorCamelData extends ErrorData{
	
	private static final long serialVersionUID = 1L;
	private String processName;
	private String step;
	private Status status; 
	
	public ErrorCamelData (){
		//Don't need to be initialized
	}

	
	public ErrorCamelData(String code,String codeDescription, String processName, String step, Status status) {
		super(code,codeDescription);
		this.processName = processName;
		this.step = step;
		this.status = status;
	}
	
	
	
	public ErrorCamelData(String code,String processName, String step, Status status) {
		super(code,"camel error");
		this.processName = processName;
		this.step = step;
		this.status = status;
	}
	
	

}
