package com.meli.ejercicioCalorias.service.impl;

import com.meli.ejercicioCalorias.dto.request.IngredienteRequestDTO;
import com.meli.ejercicioCalorias.dto.response.IngredienteResponseDTO;
import com.meli.ejercicioCalorias.model.Ingrediente;
import com.meli.ejercicioCalorias.repository.IngredienteRepository;
import com.meli.ejercicioCalorias.dto.response.CaloriesResponseDTO;
import com.meli.ejercicioCalorias.dto.request.PlatoRequestDTO;
import com.meli.ejercicioCalorias.service.CalculateCaloriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculateCaloriesServiceImpl implements CalculateCaloriesService {
    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Override
    public CaloriesResponseDTO calculateCalories(PlatoRequestDTO platoRequestDTO) { // recibo plato con ingredientes (nombre y peso)
        List<IngredienteRequestDTO> ingredienteRequestDTOList = platoRequestDTO.getIngredienteRequestDTOList(); // listado de nombres de ingredientes del plato

        List<IngredienteResponseDTO> ingredientsByPlate = getIngredientsByPlate(ingredienteRequestDTOList); //listado de ingredientes (nombre y caloria) del plato
        double fullCalories = getFullCalories(ingredientsByPlate); //categorias por plato
        IngredienteResponseDTO ingredienteDAOMasCalorias = calculateIngredienteMasCaloria(ingredientsByPlate); //ingrediente con mas calorias

        CaloriesResponseDTO caloriesResponseDTO = new CaloriesResponseDTO(fullCalories, ingredientsByPlate, ingredienteDAOMasCalorias);
        return caloriesResponseDTO;
    }

    private List<IngredienteResponseDTO> getIngredientsByPlate(List<IngredienteRequestDTO> ingredienteRequestDTO){
        List<IngredienteResponseDTO> ingredienteResponseDTOList = new ArrayList<>(); //lista de respuesta
        for (IngredienteRequestDTO ingredientePeso: ingredienteRequestDTO) { // recorro la request
            IngredienteResponseDTO ingredientePesoCaloria = new IngredienteResponseDTO(); //inicializo el ingrediente para la response
            Ingrediente ingredienteCaloria = ingredienteRepository.findCaloriesByIngredient(ingredientePeso.getName()); // obtengo el ingrediente del repo
            ingredientePesoCaloria.setCalories(ingredienteCaloria.getCalories() * ingredientePeso.getWeight()); //seteo calorias del ingrediente de la response
            ingredientePesoCaloria.setName(ingredienteCaloria.getName()); //seteo nombre del ingrediente de la response

            ingredienteResponseDTOList.add(ingredientePesoCaloria); // agrego el ingrediente a la lista de la response
        }

        return ingredienteResponseDTOList;
    }

    private double getFullCalories(List<IngredienteResponseDTO> ingredienteResponseDTOList){
        double result = 0.0d;
        for (IngredienteResponseDTO ingre: ingredienteResponseDTOList) {
            result += ingre.getCalories();
        }
        return result;
    }

    private IngredienteResponseDTO calculateIngredienteMasCaloria(List<IngredienteResponseDTO> ingredientsByPlate){
        IngredienteResponseDTO ingredienteDAOMayor = ingredientsByPlate.get(0);
        for (IngredienteResponseDTO ingre: ingredientsByPlate) {
            if(ingre.getCalories() > ingredienteDAOMayor.getCalories()){
                ingredienteDAOMayor = ingre;
            }
        }
        return ingredienteDAOMayor;
    }

}
