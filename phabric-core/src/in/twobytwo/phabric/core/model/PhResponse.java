package in.twobytwo.phabric.core.model;

public class PhResponse<Type extends PhObject> {
	private Type payload;
	private boolean hasError;
	private String errorCode;
	private String errorInfo;

	public Type getPayload() {
		return payload;
	}

	public void setPayload(Type content) {
		this.payload = content;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
}
