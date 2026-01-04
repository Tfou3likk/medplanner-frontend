package com.medplanner.medplanner_frontend.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record RdvRequestDTO(LocalDate date, LocalTime heure) {

}
