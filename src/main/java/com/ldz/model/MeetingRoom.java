package com.ldz.model;

public class MeetingRoom {
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "MeetingRoom [id=" + id + ", name=" + name + "]";
	}

	public MeetingRoom(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public MeetingRoom() {
		super();
	}
}