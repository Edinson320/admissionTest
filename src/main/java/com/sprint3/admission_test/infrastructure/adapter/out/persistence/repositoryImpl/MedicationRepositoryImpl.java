package com.sprint3.admission_test.infrastructure.adapter.out.persistence.repositoryImpl;

import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository.MedicationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MedicationRepositoryImpl implements IMedicationRepository {

    private final MedicationJpaRepository medicationJpaRepository;

    @Override
    public Optional<Medication> findById(Long id) {
        return medicationJpaRepository.findById(id);
    }

    @Override
    public Medication create(Medication medication){
        return medicationJpaRepository.save(medication);
    }

    @Override
    public List<Medication> findByCategoryAndDate(String categoryName, LocalDate date) {
        return medicationJpaRepository.findByCategoryAndDate(categoryName, date);

    }
}
