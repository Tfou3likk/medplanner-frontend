package com.medplanner.medplanner_frontend.models;

import java.time.LocalDate;
import java.time.LocalTime;



public class RendezVous {

	
    private Integer id;
	
	private Integer idPatient;
	
	private Integer idMedecin;

    private LocalDate dateRdv;

    private LocalTime heure;

    private String compteRenduRdv;
    
    private Medecin medecin;
    
    private Patient patient;
    
    

	public RendezVous() {
		super();
	}
	
	public RendezVous(Integer id, Integer idPatient, Integer idMedecin, LocalDate dateRdv, LocalTime heure,
			String compteRenduRdv, Medecin medecin, Patient patient) {
		super();
		this.id = id;
		this.idPatient = idPatient;
		this.idMedecin = idMedecin;
		this.dateRdv = dateRdv;
		this.heure = heure;
		this.compteRenduRdv = compteRenduRdv;
		this.medecin = medecin;
		this.patient = patient;
	}



	public Medecin getMedecin() {
		return medecin;
	}



	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}



	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	public Integer getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(Integer idMedecin) {
		this.idMedecin = idMedecin;
	}

	public LocalDate getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(LocalDate dateRdv) {
		this.dateRdv = dateRdv;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public String getCompteRenduRdv() {
		return compteRenduRdv;
	}

	public void setCompteRenduRdv(String compteRenduRdv) {
		this.compteRenduRdv = compteRenduRdv;
	}

	public RendezVous editRdvPatient(Integer id2) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
