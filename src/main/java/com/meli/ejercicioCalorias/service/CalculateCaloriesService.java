package com.meli.ejercicioCalorias.service;

import com.meli.ejercicioCalorias.dto.response.CaloriesResponseDTO;
import com.meli.ejercicioCalorias.dto.request.PlatoRequestDTO;

public interface CalculateCaloriesService {
    CaloriesResponseDTO calculateCalories(PlatoRequestDTO platoRequestDTO);
}
