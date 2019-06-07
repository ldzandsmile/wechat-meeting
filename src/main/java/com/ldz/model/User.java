package com.ldz.model;

public class User {
	private Long id;

	private String name;

	private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

	public User(Long id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public User() {
		super();
	}
}