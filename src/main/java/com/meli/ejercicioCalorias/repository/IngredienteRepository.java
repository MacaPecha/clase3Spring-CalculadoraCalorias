package com.meli.ejercicioCalorias.repository;

import com.meli.ejercicioCalorias.model.Ingrediente;

public interface IngredienteRepository {
    Ingrediente findIngredientByName(String ingredient);

}
