package com.meli.ejercicioCalorias.dto.response;

import java.text.DecimalFormat;

public class IngredienteResponseDTO {
    private String name;
    private Double fullCalories;

    public IngredienteResponseDTO(String name, Double calories) {
        this.name = name;
        this.fullCalories = calories;
    }

    public IngredienteResponseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFullCalories() {
        if (fullCalories == null) {
            return null;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(fullCalories));
    }

    public void setFullCalories(Double calories) {
        this.fullCalories = calories;
    }

    @Override
    public String toString() {
        return "IngredienteDTO{" +
                "name='" + name + '\'' +
                ", calories=" + fullCalories +
                '}';
    }
}
