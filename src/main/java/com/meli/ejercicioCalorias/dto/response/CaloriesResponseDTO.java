package com.meli.ejercicioCalorias.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.text.DecimalFormat;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaloriesResponseDTO {
    private Double fullCalories;
    private List<IngredienteResponseDTO> ingredienteResponseDTOList;
    private IngredienteResponseDTO ingredienteResponseDTOMayorCalorias;
    private String errorMessage;

    public CaloriesResponseDTO(Double fullCalories, List<IngredienteResponseDTO> ingredienteResponseDTOList, IngredienteResponseDTO ingredienteResponseDTOMayorCalorias) {
        this.fullCalories = fullCalories;
        this.ingredienteResponseDTOList = ingredienteResponseDTOList;
        this.ingredienteResponseDTOMayorCalorias = ingredienteResponseDTOMayorCalorias;
    }

    public CaloriesResponseDTO(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public CaloriesResponseDTO() {
    }

    public Double getFullCalories() {
        if (fullCalories == null) {
            return null;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(fullCalories));
    }

    public void setFullCalories(Double fullCalories) {
        this.fullCalories = fullCalories;
    }

    public List<IngredienteResponseDTO> getIngredienteResponseDTOList() {
        return ingredienteResponseDTOList;
    }

    public void setIngredienteResponseDTOListList(List<IngredienteResponseDTO> ingredienteDAOList) {
        this.ingredienteResponseDTOList = ingredienteDAOList;
    }

    public IngredienteResponseDTO getIngredienteResponseDTOMayorCalorias() {
        return ingredienteResponseDTOMayorCalorias;
    }

    public void setIngredienteResponseDTOMayorCaloriasCalorias(IngredienteResponseDTO ingredienteResponseDTOMayorCalorias) {
        this.ingredienteResponseDTOMayorCalorias = ingredienteResponseDTOMayorCalorias;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
