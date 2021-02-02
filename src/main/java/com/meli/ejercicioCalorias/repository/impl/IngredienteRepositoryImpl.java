package com.meli.ejercicioCalorias.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.ejercicioCalorias.model.Ingrediente;
import com.meli.ejercicioCalorias.repository.IngredienteRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository
public class IngredienteRepositoryImpl implements IngredienteRepository {

    @Override
    public Ingrediente findIngredientByName(String ingredientName) {
        List<Ingrediente> ingredientes;
        ingredientes = loadDataBase();
        Ingrediente result = null;
        if( ingredientes != null){
            Optional<Ingrediente> item = ingredientes.stream()
                .filter(ingredientDTO -> ingredientDTO.getName().equalsIgnoreCase(ingredientName))
                .findFirst();
            if(item.isPresent())
                result =item.get();
        }
        return result;
    }

    private List<Ingrediente> loadDataBase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:food.json");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingredientes = null;
        try{
            ingredientes = objectMapper.readValue(file, typeRef);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return ingredientes;
    }
}
