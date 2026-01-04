package com.medplanner.medplanner_frontend.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;						  
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			
			if(patient == null) {
				return"redirect:/login";
			}
			
			List<RendezVous> listRdv = rdv.listerRdvPatient(patient.getId()); 
			
			
			model.addAttribute("listRdv", listRdv);
	        model.addAttribute("patient", patient);
			
			return"rendezvouspatient";
	}	
	@PostMapping("/rdv/edit")
	public String editerRdvPatient(Model model, @RequestParam("idRdv") Integer idRdv, HttpSession session) {

		RendezVous rdvPatient = rdv.editerRdvPatient(idRdv);		
		model.addAttribute("rdvPatient", rdvPatient);

		return"editrdv";
	}	
	@PostMapping("/rdv/modif")
	public String modifierRdvPatient(Model model, @RequestParam("idRdv") Integer idRdv, @RequestParam("date") String date, @RequestParam("heure") String heure, HttpSession session) {
						
		Patient patient = (Patient) session.getAttribute("patient");
		
		LocalDate dateRdv = LocalDate.parse(date);
		LocalTime heureRdv =LocalTime.parse(heure);     

		List<RendezVous> listRdv = rdv.modifierRdvPatient(idRdv, dateRdv, heureRdv);
		
		model.addAttribute("listRdv", listRdv);
		model.addAttribute("patient", patient);

		return "rendezvouspatient";
	}
	
	

	@PostMapping("/rdv/delete")
	public String supprimerRdvPatient(Model model, @RequestParam("idRdv") Integer idRdv, HttpSession session) {
		
		Patient patient = (Patient) session.getAttribute("patient");
		
		rdv.supprimerRdvPatient(patient.getId()); 
		
        return"redirect:/rdv";
	
	
}
	

}
