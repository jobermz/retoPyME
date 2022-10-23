package pe.com.bbva.hackaton.core.bean;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TcsResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ResponseHeader responseHeader;
	private Object responseBody;

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public Object getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(Object responseBody) {
		this.responseBody = responseBody;
	}
	
	/**
	 * Serialize this instance.
	 * 
	 * @param out Target to which this instance is written.
	 * @throws IOException Thrown if exception occurs during serialization.
	 */
	private void writeObject(final ObjectOutputStream out) throws IOException
	{
		out.writeObject(this.responseHeader);
		out.writeObject(this.responseBody);
	}

	/**
	 * Deserialize this instance from input stream.
	 * 
	 * @param in Input Stream from which this instance is to be deserialized.
	 * @throws IOException Thrown if error occurs in deserialization.
	 * @throws ClassNotFoundException Thrown if expected class is not found.
	 */
	private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		this.responseHeader = (ResponseHeader) in.readObject();
		this.responseBody = in.readObject();
	}
}
