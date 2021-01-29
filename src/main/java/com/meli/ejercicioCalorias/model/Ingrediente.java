package com.meli.ejercicioCalorias.model;

public class Ingrediente {
    private String name;
    private int calories;

    public Ingrediente(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public Ingrediente() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "name='" + name + '\'' +
                ", calories=" + calories;
    }
}
