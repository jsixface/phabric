package in.twobytwo.phabric.core.model;

import java.util.ArrayList;
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

	/*
	 * Functionality functions
	 */

	public String getSearchQuery() {
		return null;
	}

	public void addId(Integer id) {
		if (ids == null) {
			ids = new ArrayList<>();
		}
		ids.add(id);
	}

	public void addPhid(String phid) {
		if (phids == null) {
			phids = new ArrayList<>();
		}
		phids.add(phid);
	}

	public void addAuthors(String author) {
		if (authors == null) {
			authors = new ArrayList<>();
		}
		authors.add(author);
	}

	public void addProjects(String project) {
		if (projects == null) {
			projects = new ArrayList<>();
		}
		projects.add(project);
	}
	

	/*
	 * Getters and setters
	 */

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
