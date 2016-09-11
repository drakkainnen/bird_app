package pl.server.birds.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "stackTrace", "cause", "suppressed", "localizedMessage" })
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public CustomException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return this.getClass().getTypeName();
	}

	public void setCode(String code) {
	}

}
