package com.dlatfullin.RestProject.utill;

import com.dlatfullin.RestProject.models.Measurements;
import com.dlatfullin.RestProject.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidator implements Validator {

    private final SensorService sensorService;

    @Autowired
    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurements.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurements measurements = (Measurements) target;

        if(sensorService.show(measurements.getSensor().getName()).isEmpty()) {
            errors.rejectValue("sensor", "400", "sensor with this name don't exist");
        }
    }
}
