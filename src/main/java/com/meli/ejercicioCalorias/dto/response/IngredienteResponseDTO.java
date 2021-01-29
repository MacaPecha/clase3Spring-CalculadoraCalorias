package com.meli.ejercicioCalorias.dto.response;

public class IngredienteResponseDTO {
    private String name;
    private double calories;

    public IngredienteResponseDTO(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public IngredienteResponseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "IngredienteDTO{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}
