package com.niit.todo.model;

import java.util.Date;

public class MyToDo {

	private String toDoId;
	private String subject;
	private String detail;
	private Date assignmentDate;
	private Date targetDate;
	private String targetTime;
	private String status;
	public MyToDo()
	{
		
	}
	public MyToDo(String toDoId, String subject, String detail, Date assignmentDate, Date targetDate, String targetTime,
			String status) {
		super();
		this.toDoId = toDoId;
		this.subject = subject;
		this.detail = detail;
		this.assignmentDate = assignmentDate;
		this.targetDate = targetDate;
		this.targetTime = targetTime;
		this.status = status;
	}
	public String getToDoId() {
		return toDoId;
	}
	public void setToDoId(String toDoId) {
		this.toDoId = toDoId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getAssignmentDate() {
		return assignmentDate;
	}
	public void setAssignmentDate(Date assignmentDate) {
		this.assignmentDate = assignmentDate;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public String getTargetTime() {
		return targetTime;
	}
	public void setTargetTime(String targetTime) {
		this.targetTime = targetTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "MyToDo [toDoId=" + toDoId + ", subject=" + subject + ", detail=" + detail + ", assignmentDate="
				+ assignmentDate + ", targetDate=" + targetDate + ", targetTime=" + targetTime + ", status=" + status
				+ "]";
	}
	
}
