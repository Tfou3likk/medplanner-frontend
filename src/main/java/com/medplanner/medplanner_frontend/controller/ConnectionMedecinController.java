package com.medplanner.medplanner_frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medplanner.medplanner_frontend.consumer.MedecinConsumer;
import com.medplanner.medplanner_frontend.models.Medecin;
import com.medplanner.medplanner_frontend.models.Patient;

import jakarta.servlet.http.HttpSession;

@Controller
public class ConnectionMedecinController {

	MedecinConsumer medecinConsumer;

	public ConnectionMedecinController(MedecinConsumer medecinConsumer) {
		super();
		this.medecinConsumer = medecinConsumer;
	}
	
	@GetMapping("/loginmedecin")
	public String formulaireConnection(){
		return "medecinLogin";
	}
	
	@PostMapping("/loginmedecin")
	public String connect(Model model, @RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		try {
			Medecin medecin = medecinConsumer.connect(email, password);
			
			session.setAttribute("medecin", medecin);
			session.setAttribute("isLogged", true);
	
			return"redirect:/homemedecin";
		}catch(IllegalArgumentException e){
			model.addAttribute("loginFailure", true);
            return "medecinLogin";
		}
		
	}
}
