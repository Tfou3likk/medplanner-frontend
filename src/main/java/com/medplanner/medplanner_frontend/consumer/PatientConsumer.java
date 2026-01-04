package com.medplanner.medplanner_frontend.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.*;
import org.springframework.web.client.RestClient;

import com.medplanner.medplanner_frontend.dto.PatientConnectRequestDTO;
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
	
	

}
