package com.meli.ejercicioCalorias.dto.response;

import java.util.List;

public class CaloriesResponseDTO {
    private double fullCalories;
    private List<IngredienteResponseDTO> ingredienteDAOList;
    private IngredienteResponseDTO ingredienteDAOMayorCalorias;

    public CaloriesResponseDTO(double fullCalories, List<IngredienteResponseDTO> ingredienteDAOList, IngredienteResponseDTO ingredienteDAOMayorCalorias) {
        this.fullCalories = fullCalories;
        this.ingredienteDAOList = ingredienteDAOList;
        this.ingredienteDAOMayorCalorias = ingredienteDAOMayorCalorias;
    }

    public CaloriesResponseDTO() {
    }

    public double getFullCalories() {
        return fullCalories;
    }

    public void setFullCalories(double fullCalories) {
        this.fullCalories = fullCalories;
    }

    public List<IngredienteResponseDTO> getIngredienteDAOList() {
        return ingredienteDAOList;
    }

    public void setIngredienteDAOList(List<IngredienteResponseDTO> ingredienteDAOList) {
        this.ingredienteDAOList = ingredienteDAOList;
    }

    public IngredienteResponseDTO getIngredienteDAOMayorCalorias() {
        return ingredienteDAOMayorCalorias;
    }

    public void setIngredienteDAOMayorCalorias(IngredienteResponseDTO ingredienteDAOMayorCalorias) {
        this.ingredienteDAOMayorCalorias = ingredienteDAOMayorCalorias;
    }
}
