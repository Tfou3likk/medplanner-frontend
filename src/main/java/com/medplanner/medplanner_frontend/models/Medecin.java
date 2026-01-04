package com.medplanner.medplanner_frontend.models;

public class Medecin {

	private Integer id;
	
	private String email;
	
	private String nom;
	
	private String prenom;
	
	private Ville ville;
	
	private Specialite specialite;

	public Medecin() {
		super();
	}

	public Medecin(Integer id, String email, String nom, String prenom) {
		super();
		this.id = id;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	
	public Medecin(Integer id, String email, String nom, String prenom, Ville ville, Specialite specialite) {
		super();
		this.id = id;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.specialite = specialite;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
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
	
	
}
