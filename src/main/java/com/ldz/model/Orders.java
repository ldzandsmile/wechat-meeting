package com.ldz.model;

import java.util.Date;

public class Orders {
	private Long id;

	private String username;

	private boolean isSuccess;

	private Date startTime;

	private Date endTime;

	private String meetingroom;

	private String host;

	private String contents;

	private String participants;

	private String organizer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getMeetingroom() {
		return meetingroom;
	}

	public void setMeetingroom(String meetingroom) {
		this.meetingroom = meetingroom;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", username=" + username + ", isSuccess=" + isSuccess + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", meetingroom=" + meetingroom + ", host=" + host + ", contents=" + contents
				+ ", participants=" + participants + ", organizer=" + organizer + "]";
	}

	public Orders(Long id, String username, boolean isSuccess, Date startTime, Date endTime, String meetingroom,
			String host, String contents, String participants, String organizer) {
		super();
		this.id = id;
		this.username = username;
		this.isSuccess = isSuccess;
		this.startTime = startTime;
		this.endTime = endTime;
		this.meetingroom = meetingroom;
		this.host = host;
		this.contents = contents;
		this.participants = participants;
		this.organizer = organizer;
	}

	public Orders() {
		super();
	}

}