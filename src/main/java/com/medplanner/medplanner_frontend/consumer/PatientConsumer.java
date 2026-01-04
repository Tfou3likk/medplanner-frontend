package com.medplanner.medplanner_frontend.consumer;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.*;
import org.springframework.web.client.RestClient;

import com.medplanner.medplanner_frontend.dto.PatientConnectRequestDTO;
import com.medplanner.medplanner_frontend.dto.PatientSignupRequestDTO;
import com.medplanner.medplanner_frontend.models.Patient;

@Component
public class PatientConsumer {
	
	private RestClient restClient;

	public PatientConsumer(@Value("${medplanner.backend}")String backendUrl) {
		super();
		this.restClient = RestClient.create(backendUrl);
	}
	
	public Patient connect(String email, String password) {
		
		return restClient.post().uri("/api/patient/login").body(new PatientConnectRequestDTO(email, password))
				.retrieve().onStatus(HttpStatusCode::is4xxClientError,
				        (req, res) -> { throw new IllegalArgumentException("Identifiants invalides"); })
				.body(Patient.class);
	}
	
	public Patient register(String email, String nom, String prenom, String password, LocalDate dateNaissance) {
		
		return restClient.post().uri("/api/patient/signup").body(new PatientSignupRequestDTO(email, nom, prenom, password, dateNaissance))
				.retrieve().onStatus(status -> status.value() == HttpStatus.CONFLICT.value(),
		        (req, res) -> { throw new IllegalArgumentException("Cet Email est deja utiisé"); })
				.onStatus(status -> status.is4xxClientError() && status.value() != HttpStatus.CONFLICT.value(),
						(req, res) -> { throw new IllegalArgumentException("Des champs sont incorrect"); })
				.body(Patient.class);
	}
	
	

}
