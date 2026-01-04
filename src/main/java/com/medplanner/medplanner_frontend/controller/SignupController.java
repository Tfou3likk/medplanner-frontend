package com.medplanner.medplanner_frontend.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.medplanner.medplanner_frontend.consumer.PatientConsumer;
import com.medplanner.medplanner_frontend.models.Patient;

import jakarta.servlet.http.HttpSession;

@Controller
public class SignupController {

	PatientConsumer patientConsumer;
	
	
	
	public SignupController(PatientConsumer patientConsumer) {
		super();
		this.patientConsumer = patientConsumer;
	}

	@GetMapping("/signup")
	public String formulaireInscription() {
		return"signup";
	}
	
	@PostMapping("/signup")
	public String sign(Model model, @RequestParam("email") String email, @RequestParam("nom") String nom, @RequestParam("prenom") String prenom, @RequestParam("password") String password,  HttpSession session) {
		
		try {
            
            Patient patient = patientConsumer.register(email, nom, prenom, password) ;
            
            session.setAttribute("isLogged", true);
            session.setAttribute("patient", patient);
            return "redirect:/home";
           
        } catch (IllegalArgumentException e){
            model.addAttribute("signupFailure", true);
            return "signup";
        }
	}
}
