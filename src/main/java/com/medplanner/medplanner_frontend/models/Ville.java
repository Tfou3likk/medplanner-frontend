package com.medplanner.medplanner_frontend.models;

public class Ville {
	
	private Integer id;
	
	private String nomVille;

	public Ville() {
		super();
	}
	
	
	public Ville(Integer id, String nomVille) {
		super();
		this.id = id;
		this.nomVille = nomVille;
	}

	

	public String getNomVille() {
		return nomVille;
	}


	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}






	

	
	

}
