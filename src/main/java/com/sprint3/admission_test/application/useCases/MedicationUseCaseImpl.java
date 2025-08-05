package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.application.ports.out.ICategoryRepository;
import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.exceptions.DateException;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.domain.model.dto.MedicationCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicationUseCaseImpl implements IMedicationUseCase {

    private final IMedicationRepository medicationRepository;
    private final ICategoryRepository categoryRepository;

    @Override
    public Medication getMedicationById(Long id) {
        return medicationRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Could not find medication with ID: " + id
        ));
    }

    @Override
    public Medication createMedication(MedicationCommand command) {

        if(LocalDate.now().isAfter(command.getExpiration_date())){
            throw new DateException("Expiration date is exceeded: " + command.getExpiration_date());
        }

        Optional<Category> exists = Optional.ofNullable(categoryRepository
                .findByName(command.getCategory_name())
                .orElseThrow(() -> new NotFoundException(
                        "Could not find category with name: " + command.getCategory_name()
                )));

        return medicationRepository.create(Medication.builder()
                .price(command.getPrice())
                .name(command.getName())
                .description(command.getDescription())
                .expirationDate(command.getExpiration_date())
                .category(exists.get())
                .build());
    }

    @Override
    public List<Medication> getMedicationsByCategory(String categoryName, LocalDate expirationDate) {
        return medicationRepository.findByCategoryAndDate(categoryName, expirationDate);
    }
}
