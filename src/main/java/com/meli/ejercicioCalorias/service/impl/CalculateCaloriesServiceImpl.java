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
import java.util.Comparator;
import java.util.List;

@Service
public class CalculateCaloriesServiceImpl implements CalculateCaloriesService {
    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Override
    public CaloriesResponseDTO calculateCalories(PlatoRequestDTO platoRequestDTO) { // recibo plato con ingredientes (nombre y peso)
        List<IngredienteRequestDTO> ingredienteRequestDTOList = platoRequestDTO.getIngredienteRequestDTOList(); // listado de ingredientes del plato

        List<IngredienteResponseDTO> ingredientsByPlate = getIngredientsByPlate(ingredienteRequestDTOList); //listado de ingredientes (nombre y (peso * caloria)) del plato
        double fullCalories = getFullCalories(ingredientsByPlate); //calorias por plato
        IngredienteResponseDTO ingredienteResponseDTO = getHigherCaloriesIngredient(ingredientsByPlate); //ingrediente con mas calorias

        CaloriesResponseDTO caloriesResponseDTO = new CaloriesResponseDTO(fullCalories, ingredientsByPlate, ingredienteResponseDTO);
        return caloriesResponseDTO;
    }

    private List<IngredienteResponseDTO> getIngredientsByPlate(List<IngredienteRequestDTO> ingredienteRequestDTOList) {
        List<IngredienteResponseDTO> ingredienteResponseDTOList = new ArrayList<>(); //lista de respuesta
        for (IngredienteRequestDTO ingredientePeso : ingredienteRequestDTOList) { // recorro la request
            IngredienteResponseDTO ingredientePesoCaloria = new IngredienteResponseDTO(); //inicializo el ingrediente para la response
            Ingrediente ingredienteCaloria = ingredienteRepository.findIngredientByName(ingredientePeso.getName()); // obtengo el ingrediente del repo
            if (ingredienteCaloria == null) {
                throw new IllegalArgumentException("Ingrediente no encontrado");
            }
            ingredientePesoCaloria.setFullCalories(ingredienteCaloria.getCalories() * ingredientePeso.getWeight()); //seteo calorias del ingrediente de la response
            ingredientePesoCaloria.setName(ingredienteCaloria.getName()); //seteo nombre del ingrediente de la response

            ingredienteResponseDTOList.add(ingredientePesoCaloria); // agrego el ingrediente a la lista de la response
        }

        return ingredienteResponseDTOList;
    }

    private double getFullCalories(List<IngredienteResponseDTO> ingredienteResponseDTOList) {
        double result = 0.0d;
        for (IngredienteResponseDTO ingre : ingredienteResponseDTOList) {
            result += ingre.getFullCalories();
        }
        return result;
    }

    private IngredienteResponseDTO getHigherCaloriesIngredient(List<IngredienteResponseDTO> ingredientsByPlate) {
        IngredienteResponseDTO ingredienteResponseDTOMayor = ingredientsByPlate.get(0); // inicializo al mayor como el primer elemento de la lista
//         TODO averiguar como hacerlo con Comparator... DONE
        Comparator<Double> comparator = (a, b) -> (int) (a-b);
        for (IngredienteResponseDTO ingre : ingredientsByPlate) {
            if(comparator.compare(ingre.getFullCalories(), ingredienteResponseDTOMayor.getFullCalories()) > 0){ // comparo calorias totales de ambos ingredientes
//            if (ingre.getFullCalories() > ingredienteResponseDTOMayor.getFullCalories()) {
                ingredienteResponseDTOMayor = ingre; // entonces el mayor elemento es el que estoy iterando
            }
        }
        return ingredienteResponseDTOMayor; // devuelvo el ingrediente de mayor calorias
    }

}
