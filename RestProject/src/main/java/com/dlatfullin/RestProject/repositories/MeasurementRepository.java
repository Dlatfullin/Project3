package com.dlatfullin.RestProject.repositories;

import com.dlatfullin.RestProject.models.Measurements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurements, Integer> {
}
