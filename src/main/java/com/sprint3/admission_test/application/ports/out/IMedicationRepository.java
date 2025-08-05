package com.sprint3.admission_test.application.ports.out;

import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.domain.model.dto.MedicationCommand;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IMedicationRepository {

    Optional<Medication> findById(Long id);
    Medication create(Medication medication);
    List<Medication> findByCategoryAndDate(String categoryName, LocalDate date);
}
