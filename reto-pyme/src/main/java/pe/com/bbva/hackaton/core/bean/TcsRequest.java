package pe.com.bbva.hackaton.core.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TcsRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("requestHeader")
	private RequestHeader requestHeader;

	@JsonProperty("requestBody")
	private Object requestBody;

	public RequestHeader getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}

	public Object getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(Object requestBody) {
		this.requestBody = requestBody;
	}
}
