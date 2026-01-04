package com.medplanner.medplanner_frontend.consumer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.medplanner.medplanner_frontend.models.RendezVous;

@Component
public class RendezVousConsumer {
	
	private RestClient restClient;

	public RendezVousConsumer(@Value("${medplanner.backend}")String backendUrl) {
		super();
		this.restClient = RestClient.create(backendUrl);
	}
	
	public List<RendezVous> listerRdvPatient(Integer id){
		
		return restClient.get().uri("/api/rdv/patient/{id}", id).retrieve()
				.onStatus(HttpStatusCode::is4xxClientError,
				        (req, res) -> { throw new IllegalArgumentException("Patient non connecter ou acces refuse"); })
		.body(new ParameterizedTypeReference<List<RendezVous>>() {});
	}

	public List<RendezVous> supprimerRdvPatient(Integer id) {
	//public void supprimerRdvPatient(Integer id) {
		return restClient.delete().uri("/api/rdv/patient/delete/{id}", id).retrieve()
				.onStatus(HttpStatusCode::is4xxClientError,
				        (req, res) -> { throw new IllegalArgumentException("Patient non connecter ou acces refuse"); })
		.body(new ParameterizedTypeReference<List<RendezVous>>() {});
	}
	
	public List<RendezVous> recherche(LocalDate date, Integer idMedecin, Integer idVille, Integer idSpecialite){
		
		return restClient.get().uri(uriTotal -> uriTotal.path("/api/rdv/search")
				.queryParam("date", date)
				.queryParamIfPresent("idMedecin", Optional.ofNullable(idMedecin))
				.queryParamIfPresent("idVille", java.util.Optional.ofNullable(idVille))
                .queryParamIfPresent("idSpecialite", java.util.Optional.ofNullable(idSpecialite))
                .build())
        .retrieve()
        .body(new ParameterizedTypeReference<List<RendezVous>>() {});
	}


}
