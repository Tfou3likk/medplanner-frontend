package com.medplanner.medplanner_frontend.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.medplanner.medplanner_frontend.consumer.PatientConsumer;
import com.medplanner.medplanner_frontend.models.Patient;

import jakarta.servlet.http.HttpSession;

@Controller

public class ConnectionPatientController {

	PatientConsumer patientConsumer;

	public ConnectionPatientController(PatientConsumer patientConsumer) {
		super();
		this.patientConsumer = patientConsumer;
	}
	
	@GetMapping("/login")
	public String formulaireConnection(){
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Model model, @RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		try {
			Patient patient = patientConsumer.connect(email, password);
			
			//session.setAttribute("patient", patient);
			//session.setAttribute("isLogged", true);
			model.addAttribute("patient", patient);
			model.addAttribute("isLogged", true);
			return "home";
			//return"redirect:/home";
		}catch(IllegalArgumentException e){
			model.addAttribute("loginFailure", true);
            return "login";
		}
	}
}
