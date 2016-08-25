package in.twobytwo.phabric.core.model;

public class PhResponse<Type extends PhObject> {
	private Type result;
	private String error_code;
	private String error_info;

	public Type getResult() {
		return result;
	}

	public void setResult(Type content) {
		this.result = content;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String errorCode) {
		this.error_code = errorCode;
	}

	public String getError_info() {
		return error_info;
	}

	public void setError_info(String errorInfo) {
		this.error_info = errorInfo;
	}
}
