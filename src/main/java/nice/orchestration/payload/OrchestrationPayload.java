package nice.orchestration.payload;

import java.io.Serializable;
import java.util.Date;


public class OrchestrationPayload implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String process;
	private String product;
	private String channel;
	private Date insertDate;
	
	
	public OrchestrationPayload(String process, String product, String channel, Date insertDate) {
		super();
		this.process = process;
		this.product = product;
		this.channel = channel;
		this.insertDate = insertDate;
	}

	
	public OrchestrationPayload() {
		
	}
	
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	@Override
	public String toString() {
		return "OrchestrationPayload [process=" + process + ", product=" + product + ", channel=" + channel
				+ ", insertDate=" + insertDate + "]";
	}
	
	
}