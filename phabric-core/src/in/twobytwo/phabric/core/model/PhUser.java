package in.twobytwo.phabric.core.model;

import java.util.List;

public class PhUser extends PhItem {
	private String userName;
	private String realName;
	private String image;
	private String uri;
	private List<String> roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return String.format("%s : %s [%s]", getUserName(), getRealName(), getPhid());
	}
}
