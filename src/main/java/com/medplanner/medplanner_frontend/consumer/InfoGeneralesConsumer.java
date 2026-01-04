package com.medplanner.medplanner_frontend.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.medplanner.medplanner_frontend.models.Medecin;
import com.medplanner.medplanner_frontend.models.Specialite;
import com.medplanner.medplanner_frontend.models.Ville;

@Component
public class InfoGeneralesConsumer {

	private RestClient restClient;

	public InfoGeneralesConsumer(@Value("${medplanner.backend}")String backendUrl) {
		super();
		this.restClient = RestClient.create(backendUrl);
	}
	
	public List<Medecin> getMedecins() {
        return restClient.get()
                .uri("/api/info/medecins")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Medecin>>() {});
    }

    public List<Ville> getVilles() {
        return restClient.get()
                .uri("/api/info/villes")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Ville>>() {});
    }

    public List<Specialite> getSpecialites() {
        return restClient.get()
                .uri("/api/info/specialites")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Specialite>>() {});
    }
	
}
