package in.twobytwo.phabric.core.model;

public class PhItem extends PhObject {
	private String phid;
	private Integer id;

	public String getPhid() {
		return phid;
	}

	public void setPhid(String phid) {
		this.phid = phid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
