package com.dlatfullin.RestProject.dto;

import com.dlatfullin.RestProject.models.Sensor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class MeasurementDTO {
    @Min(value = -100, message = "temperature can't be less than -100")
    @Max(value = 100, message = "temperature can't be more than 100")
    @NotNull(message = "value can't be empty")
    private float value;


    @NotNull(message = "Error Info")
    private boolean raining;


    @NotNull(message = "sensor can't be empty")
    private Sensor sensor;

    public MeasurementDTO() {
    }

    public MeasurementDTO(float value, boolean raining, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
