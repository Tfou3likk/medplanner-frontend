package com.medplanner.medplanner_frontend.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.medplanner.medplanner_frontend.dto.MedecinConnectRequestDTO;
import com.medplanner.medplanner_frontend.dto.PatientConnectRequestDTO;
import com.medplanner.medplanner_frontend.models.Medecin;
import com.medplanner.medplanner_frontend.models.Patient;

@Component
public class MedecinConsumer {
	
	private RestClient restClient;

	public MedecinConsumer(@Value("${medplanner.backend}")String backendUrl) {
		super();
		this.restClient = RestClient.create(backendUrl);
	}
	
	public Medecin connect(String email, String password) {
		
		return restClient.post().uri("/api/medecins/login").body(new MedecinConnectRequestDTO(email, password))
				.retrieve().onStatus(HttpStatusCode::is4xxClientError,
				        (req, res) -> { throw new IllegalArgumentException("Identifiants invalides"); })
				.body(Medecin.class);
	}

}
