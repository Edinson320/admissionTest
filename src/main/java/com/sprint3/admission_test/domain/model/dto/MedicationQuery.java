package com.sprint3.admission_test.domain.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class MedicationQuery {
    private LocalDate expiration_after;
}
