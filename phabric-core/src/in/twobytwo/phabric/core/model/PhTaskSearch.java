package in.twobytwo.phabric.core.model;

import java.util.List;

/**
 * @author Arumugam Jeganathan
 *
 */
public class PhTaskSearch {
	private List<Integer> ids;
	private List<String> phids;
	private List<String> authors;
	private List<String> projects;
	private String query;
	private List<PhTaskStatus> statuses;
	private int limit;
	private int offset;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public List<String> getPhids() {
		return phids;
	}

	public void setPhids(List<String> phids) {
		this.phids = phids;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public List<String> getProjects() {
		return projects;
	}

	public void setProjects(List<String> projects) {
		this.projects = projects;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public List<PhTaskStatus> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<PhTaskStatus> statuses) {
		this.statuses = statuses;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

}
