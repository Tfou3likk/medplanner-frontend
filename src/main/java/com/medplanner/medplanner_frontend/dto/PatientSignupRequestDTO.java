package com.medplanner.medplanner_frontend.dto;

import java.time.LocalDate;

public record PatientSignupRequestDTO(String email, String nom, String prenom, String password, LocalDate dateNaissance) {

}
