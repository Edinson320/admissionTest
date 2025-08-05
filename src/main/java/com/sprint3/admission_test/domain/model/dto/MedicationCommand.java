package com.sprint3.admission_test.domain.model.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class MedicationCommand {
    @NotNull(message = "name is mandatory")
    @Size(min = 5, max = 100, message = "the name must be between 5 and 100 characters.")
    private String name;
    @NotNull(message = "description is mandatory")
    @Size(min = 30, max = 255, message = "the description must be between 30 and 255 characters.")
    private String description;
    @NotNull(message = "price is mandatory")
    @DecimalMin(value = "0.0", message = "the price must be greater than 0.")
    private BigDecimal price;
    @NotNull(message = "expiration_date is mandatory")
    private LocalDate expiration_date;
    @NotNull(message = "category_name is mandatory")
    @Size(min = 3, max = 50, message = "the name must be between 3 and 50 characters.")
    private String category_name;
}
