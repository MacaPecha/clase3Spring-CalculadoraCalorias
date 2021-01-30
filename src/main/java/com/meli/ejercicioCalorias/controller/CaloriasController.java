package com.meli.ejercicioCalorias.controller;

import com.meli.ejercicioCalorias.dto.response.CaloriesResponseDTO;
import com.meli.ejercicioCalorias.dto.request.PlatoRequestDTO;
import com.meli.ejercicioCalorias.service.impl.CalculateCaloriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloriasController {
    @Autowired
    private CalculateCaloriesServiceImpl calculateCaloriesService;

    @PostMapping(path="/calorias")
    @ResponseBody
    public ResponseEntity<CaloriesResponseDTO> calcularEdadesPost(@RequestBody PlatoRequestDTO platoRequestDTO){
        try {
            CaloriesResponseDTO  response = calculateCaloriesService.calculateCalories(platoRequestDTO);
            return new ResponseEntity<CaloriesResponseDTO>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            CaloriesResponseDTO response = new CaloriesResponseDTO("Ingrediente no encontrado");
            return new ResponseEntity<CaloriesResponseDTO>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
