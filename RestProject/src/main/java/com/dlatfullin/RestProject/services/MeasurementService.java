package com.dlatfullin.RestProject.services;

import com.dlatfullin.RestProject.models.Measurements;
import com.dlatfullin.RestProject.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorService sensorService;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    public List<Measurements> show() {
        return measurementRepository.findAll();
    }

    public void save(Measurements measurements) {

        enrichMeasurement(measurements);
        measurementRepository.save(measurements);
    }

    private void enrichMeasurement(Measurements measurements) {
        measurements.setSensor(sensorService.show(measurements.getSensor().getName()).get());

        measurements.setChangeAt(LocalDateTime.now());
    }

}
