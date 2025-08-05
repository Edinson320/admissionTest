package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.domain.model.dto.MedicationCommand;

import java.time.LocalDate;
import java.util.List;

public interface IMedicationUseCase {
    Medication getMedicationById(Long id);
    Medication createMedication(MedicationCommand command);
    List<Medication> getMedicationsByCategory(String categoryName, LocalDate expirationDate);
}
