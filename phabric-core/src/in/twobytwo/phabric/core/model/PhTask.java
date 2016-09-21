package in.twobytwo.phabric.core.model;

import java.util.List;

public class PhTask extends PhItem{
	private String authorPHID;
	private String ownerPHID;
	private List<String> ccPHIDs;
	private String status;
	private String statusName;
	private boolean isClosed;
	private String priority;
	private String priorityColor;
	private String title;
	private String description;
	private List<String> projectPHIDs;
	private String uri;
	private String objectName;
	private String dateCreated;
	private String dateModified;
	private List<String> dependsOnTaskPHIDs;

	public String getAuthorPHID() {
		return authorPHID;
	}

	public void setAuthorPHID(String authorPHID) {
		this.authorPHID = authorPHID;
	}

	public String getOwnerPHID() {
		return ownerPHID;
	}

	public void setOwnerPHID(String ownerPHID) {
		this.ownerPHID = ownerPHID;
	}

	public List<String> getCcPHIDs() {
		return ccPHIDs;
	}

	public void setCcPHIDs(List<String> ccPHIDs) {
		this.ccPHIDs = ccPHIDs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public boolean isClosed() {
		return isClosed;
	}

	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getPriorityColor() {
		return priorityColor;
	}

	public void setPriorityColor(String priorityColor) {
		this.priorityColor = priorityColor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getProjectPHIDs() {
		return projectPHIDs;
	}

	public void setProjectPHIDs(List<String> projectPHIDs) {
		this.projectPHIDs = projectPHIDs;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateModified() {
		return dateModified;
	}

	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	public List<String> getDependsOnTaskPHIDs() {
		return dependsOnTaskPHIDs;
	}

	public void setDependsOnTaskPHIDs(List<String> dependsOnTaskPHIDs) {
		this.dependsOnTaskPHIDs = dependsOnTaskPHIDs;
	}

}
