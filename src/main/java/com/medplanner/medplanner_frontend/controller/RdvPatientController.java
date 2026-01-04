package com.medplanner.medplanner_frontend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.medplanner.medplanner_frontend.consumer.RendezVousConsumer;
import com.medplanner.medplanner_frontend.models.Patient;
import com.medplanner.medplanner_frontend.models.RendezVous;

import jakarta.servlet.http.HttpSession;

@Controller
public class RdvPatientController {
	
	private RendezVousConsumer rdv;

	public RdvPatientController(RendezVousConsumer rdv) {
		super();
		this.rdv = rdv;
	}
	
	@GetMapping("/rdv")
	public String listRdvPatient(Model model, HttpSession session) {
	
			Patient patient = (Patient) session.getAttribute("patient");
			
			List<RendezVous> listRdv = rdv.listerRdvPatient(patient.getId()); 
			
			
			model.addAttribute("listRdv", listRdv);
	        model.addAttribute("patient", patient);
			
			return"rendezvouspatient";
		
		
	}

}
