package in.twobytwo.phabric.core.model;

public enum PhTaskStatus {

	ANY("status-any"), //
	OPEN("status-open"), //
	CLOSED("status-closed"), //
	RESOLVED("status-resolved"), //
	WONTFIX("status-wontfix"), //
	INVALID("status-invalid"), //
	SPITE("status-spite"), //
	DUPLICATE("status-duplicate");

	private String status;

	private PhTaskStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return status;
	}
}
