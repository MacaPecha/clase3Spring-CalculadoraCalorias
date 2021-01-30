package com.meli.ejercicioCalorias.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaloriesResponseDTO {
    private Double fullCalories;
    private List<IngredienteResponseDTO> ingredienteDAOList;
    private IngredienteResponseDTO ingredienteDAOMayorCalorias;
    private String errorMessage;

    public CaloriesResponseDTO(Double fullCalories, List<IngredienteResponseDTO> ingredienteDAOList, IngredienteResponseDTO ingredienteDAOMayorCalorias) {
        this.fullCalories = fullCalories;
        this.ingredienteDAOList = ingredienteDAOList;
        this.ingredienteDAOMayorCalorias = ingredienteDAOMayorCalorias;
    }

    public CaloriesResponseDTO(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public CaloriesResponseDTO() {
    }

    public Double getFullCalories() {
        return fullCalories;
    }

    public void setFullCalories(Double fullCalories) {
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
