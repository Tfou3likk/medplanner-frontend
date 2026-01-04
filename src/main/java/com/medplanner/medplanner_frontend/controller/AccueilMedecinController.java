package com.medplanner.medplanner_frontend.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;

import com.medplanner.medplanner_frontend.models.Medecin;


import jakarta.servlet.http.HttpSession;

@Controller
public class AccueilMedecinController {

	@GetMapping("/homemedecin")
	public String home(HttpSession session) {
		Medecin medecin = (Medecin) session.getAttribute("medecin");
		return "medecinHome";
	}
}
