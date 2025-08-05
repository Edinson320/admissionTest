package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.domain.model.dto.MedicationCommand;
import com.sprint3.admission_test.domain.model.dto.MedicationQuery;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/medications")
@RequiredArgsConstructor
public class MedicationController {

    private final IMedicationUseCase medicationUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationById(id));
    }

    @PostMapping
    public ResponseEntity<Medication> createMedication(@RequestBody @Valid MedicationCommand command){
        return ResponseEntity.ok(medicationUseCase.createMedication(command));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Medication>> getMedicationsByCategory(
            @PathVariable String category,
            @ModelAttribute MedicationQuery query
            ){
        return ResponseEntity.ok(medicationUseCase.getMedicationsByCategory(category, query.getExpiration_after()));
    }

}
