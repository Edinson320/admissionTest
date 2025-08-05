package com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository;

import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MedicationJpaRepository extends JpaRepository<Medication, Long> {
    @Query(value = "select m.* from medications m " +
            "join categories c on c.id = m.category_id " +
            "where c.name = :categoryName and m.expiration_date > :date ;", nativeQuery = true)
    List<Medication> findByCategoryAndDate(
            @Param("categoryName") String categoryName,
            @Param("date") LocalDate date
            );
}
