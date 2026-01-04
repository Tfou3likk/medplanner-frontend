package com.medplanner.medplanner_frontend.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medplanner.medplanner_frontend.consumer.InfoGeneralesConsumer;
import com.medplanner.medplanner_frontend.consumer.RendezVousConsumer;
import com.medplanner.medplanner_frontend.models.Patient;
import com.medplanner.medplanner_frontend.models.RendezVous;

import jakarta.servlet.http.HttpSession;

@Controller
public class RechercheRdvController {
	
	RendezVousConsumer rdvConsumer;
	InfoGeneralesConsumer ifConsumer;

	
	
	public RechercheRdvController(RendezVousConsumer rdvConsumer, InfoGeneralesConsumer ifConsumer) {
		super();
		this.rdvConsumer = rdvConsumer;
		this.ifConsumer = ifConsumer;
	}



	@GetMapping("/patient/rdv/search")
	public String recherche(Model model, HttpSession session , @RequestParam(required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date, @RequestParam(required = false) Integer idMedecin, @RequestParam(required = false) Integer idVille, @RequestParam(required = false) Integer idSpecialite) {
		
		Patient patient = (Patient) session.getAttribute("patient");
		
		model.addAttribute("patient", patient);
		
		model.addAttribute("medecins", ifConsumer.getMedecins());
        model.addAttribute("villes", ifConsumer.getVilles());
        model.addAttribute("specialites", ifConsumer.getSpecialites());
        
        model.addAttribute("date", date);
        model.addAttribute("idMedecin", idMedecin);
        model.addAttribute("idVille", idVille);
        model.addAttribute("idSpecialite", idSpecialite);
		
		 if (date == null) {
	            model.addAttribute("dateAbs", true);
	            return "search";
	        }

        
        
       
        
        List<RendezVous> listRdv = rdvConsumer.recherche(date, idMedecin, idVille, idSpecialite);
        model.addAttribute("listRdv", listRdv);

        return "search";
	}

}
