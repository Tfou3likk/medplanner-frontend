package com.medplanner.medplanner_frontend.models;

public class Ville {
	
	private Integer id;
	
	private String libelle;

	public Ville() {
		super();
	}
	
	

	public Ville(Integer id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	

}
