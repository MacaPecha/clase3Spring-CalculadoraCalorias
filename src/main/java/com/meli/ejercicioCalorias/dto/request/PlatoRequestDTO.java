package com.meli.ejercicioCalorias.dto.request;

import java.util.List;

public class PlatoRequestDTO {
    private String name;
    private List<IngredienteRequestDTO> ingredienteRequestDTOList;

    public PlatoRequestDTO(String name, List<IngredienteRequestDTO> ingredienteRequestDTOList) {
        this.name = name;
        this.ingredienteRequestDTOList = ingredienteRequestDTOList;
    }

    public PlatoRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredienteRequestDTO> getIngredienteRequestDTOList() {
        return ingredienteRequestDTOList;
    }

    public void setIngredienteRequestDTOList(List<IngredienteRequestDTO> ingredienteRequestDTOList) {
        this.ingredienteRequestDTOList = ingredienteRequestDTOList;
    }

    @Override
    public String toString() {
        return "PlatoRequestDTO{" +
                "name='" + name + '\'' +
                ", ingredienteRequestDTOList=" + ingredienteRequestDTOList +
                '}';
    }
}
