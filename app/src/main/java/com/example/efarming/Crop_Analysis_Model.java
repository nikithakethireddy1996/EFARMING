package com.example.efarming;

import java.util.ArrayList;

public class Crop_Analysis_Model {
    public static class Soil {
        String name;
        String title;
        String crop;
        double temperature;
        String comment;

        Soil(String name, String title, String crop, double temperature, String comment) {
            this.name = name;
            this.title = title;
            this.crop = crop;
            this.temperature = temperature;
            this.comment = comment;
        }

    }

    public ArrayList<Soil> black;
    public ArrayList<Soil> red;
    public ArrayList<Soil> sandy;

    public void loadSoils() {
        black.add(new Soil("Black0", "How to Grow Apples", "Apples", 65.0, "None"));
        black.add(new Soil("Black1", "How to Grow Bananas", "Bananas", 64.0, "Nope"));
        black.add(new Soil("Black2", "How to Grow Grapes", "Grapes", 64.5, "No"));

        red.add(new Soil("Red0", "How to Grow Apples", "Apples", 65.0, "None"));
        red.add(new Soil("Red1", "How to Grow Bananas", "Bananas", 64.0, "Nope"));
        red.add(new Soil("Red2", "How to Grow Grapes", "Grapes", 64.5, "No"));

        sandy.add(new Soil("Sandy0", "How to Grow Apples", "Apples", 65.0, "None"));
        sandy.add(new Soil("Sandy1", "How to Grow Bananas", "Bananas", 64.0, "Nope"));
        sandy.add(new Soil("Sandy2", "How to Grow Grapes", "Grapes", 64.5, "No"));
    }

    public Crop_Analysis_Model() {
        black = new ArrayList<Soil>();
        red = new ArrayList<Soil>();
        sandy = new ArrayList<Soil>();
        loadSoils();
        ;
    }

    private static Crop_Analysis_Model cpModel = null;

    public static Crop_Analysis_Model getCrop_protection() {
        if (cpModel == null) {
            cpModel = new Crop_Analysis_Model();
        }
        return cpModel;
    }

    public void addBlackSoil(String name, String title, String crop, double temperature, String comment) {
        black.add(new Soil(name, title, crop, temperature, comment));
    }

    public void addRedSoil(String name, String title, String crop, double temperature, String comment) {
        red.add(new Soil(name, title, crop, temperature, comment));
    }

    public void addSandySoil(String name, String title, String crop, double temperature, String comment) {
        sandy.add(new Soil(name, title, crop, temperature, comment));
    }
}


