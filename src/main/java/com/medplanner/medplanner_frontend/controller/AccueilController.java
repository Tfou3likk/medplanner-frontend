package com.medplanner.medplanner_frontend.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;

import com.medplanner.medplanner_frontend.models.Patient;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccueilController {
	
	@GetMapping("/home")
	public String home(HttpSession session) {
		Patient patient = (Patient) session.getAttribute("patient");
		return "home";
	}

}
