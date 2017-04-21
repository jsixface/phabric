package in.twobytwo.phabric.core.model;

/**
 * @author Arumugam Jeganathan
 *
 */
public enum PhTaskOrder {
	PRIORITY("order-priority"), //
	CREATED("order-created"), //
	MODIFIED("order-modified");

	private String order;

	private PhTaskOrder(String order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return order;
	}

}
