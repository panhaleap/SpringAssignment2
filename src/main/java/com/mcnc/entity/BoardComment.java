package com.mcnc.entity;

import java.util.Date;

public class BoardComment extends TrackTimestamp{
	private int id;
	private int boardId;
	private String comments;
	private int createdByType;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getBoardId() {
		return boardId;
	}
	
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public int getCreatedByType() {
		return createdByType;
	}
	
	public void setCreatedByType(int createdByType) {
		this.createdByType = createdByType;
	}
	
	@Override
	public String toString() {
		return "BoardComment [id=" + id + ", boardId=" + boardId + ", comments=" + comments + ", createdByType="
				+ createdByType + ", createdBy=" + this.getCreatedBy() + ", updatedBy=" + this.getUpdatedBy() + ", createdDate="
				+ this.getCreatedDate() + ", updatedDate=" + this.getUpdatedDate() + "]";
	}	
}
