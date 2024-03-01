package com.example.slide1.model;

public class CatModel {
    private int id;
    private String name;

    public CatModel(String name) {
        this.name = name;
    }

    public CatModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CatModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
