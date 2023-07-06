package com.dlatfullin.RestProject.services;

import com.dlatfullin.RestProject.models.Sensor;
import com.dlatfullin.RestProject.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public void save(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    public Optional<Sensor> show(String name) {
        return sensorRepository.findByName(name);
    }


}
