package com.medplanner.medplanner_frontend.models;

public class Patient {

	private Integer id;
	
	private String email;
	
	

	public Patient(Integer id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
