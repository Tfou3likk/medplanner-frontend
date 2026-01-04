package com.medplanner.medplanner_frontend.models;

public class Patient {

	private Integer id;
	
	private String email;
	
	private String nom;
	
	private String prenom;
	
	
	
	
	
	public Patient() {
		super();
	}

	public Patient(Integer id, String email) {
		super();
		this.id = id;
		this.email = email;
	}
	
	public Patient(String email, String nom, String prenom) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
