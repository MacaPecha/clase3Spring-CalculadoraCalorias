package com.meli.ejercicioCalorias.repository;

import com.meli.ejercicioCalorias.model.Ingrediente;

public interface IngredienteRepository {
    Ingrediente findCaloriesByIngredient(String ingredient);

}
