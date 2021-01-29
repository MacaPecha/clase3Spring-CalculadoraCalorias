package com.meli.ejercicioCalorias.controller;

import com.meli.ejercicioCalorias.dto.response.CaloriesResponseDTO;
import com.meli.ejercicioCalorias.dto.request.PlatoRequestDTO;
import com.meli.ejercicioCalorias.service.impl.CalculateCaloriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    public CaloriesResponseDTO calcularEdadesPost(@RequestBody PlatoRequestDTO platoRequestDTO){
        return calculateCaloriesService.calculateCalories(platoRequestDTO);
    }
}
