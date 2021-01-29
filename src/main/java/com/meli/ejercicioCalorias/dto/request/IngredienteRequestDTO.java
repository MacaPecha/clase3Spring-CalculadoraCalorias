package com.meli.ejercicioCalorias.dto.request;

public class IngredienteRequestDTO {
    private String name;
    private double weight;

    public IngredienteRequestDTO(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public IngredienteRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "IngredienteDTO{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
