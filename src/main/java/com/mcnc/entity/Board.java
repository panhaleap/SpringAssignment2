package com.mcnc.entity;

public class Board extends TrackTimestamp{
	private int id;
	private String typeCode;
	private Type type;
	private String title;
	private String html;
	private int viewCount;
	private int isDisplayed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getIsDisplayed() {
		return isDisplayed;
	}
	public void setIsDisplayed(int isDisplayed) {
		this.isDisplayed = isDisplayed;
	}
	@Override
	public String toString() {
		return "Board [id=" + id + ", typeCode=" + typeCode + ", type=" + type + ", title=" + title + ", html=" + html
				+ ", viewCount=" + viewCount + ", isDisplayed=" + isDisplayed 
				+ ", createdBy=" + this.getCreatedBy() 
				+ ", updatedBy=" + this.getUpdatedBy() 
				+ ", createdDate=" + this.getCreatedDate() 
				+ ", updatedDate=" + this.getUpdatedDate() 
				+ "]";
	}

	
}
