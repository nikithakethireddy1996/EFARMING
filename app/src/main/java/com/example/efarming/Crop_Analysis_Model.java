package com.example.efarming;

import java.util.ArrayList;

public class Crop_Analysis_Model {
    public static class Soil{
            String title;
            String crop;
            double temperature;

            Soil(String title, String crop, double temperature){
                this.title = title;
                this.crop = crop;
                this.temperature = temperature;
            }

    }

    public ArrayList<Soil> black;
    public ArrayList<Soil> red;
    public ArrayList<Soil> sandy;

    public void loadSoils(){
        black.add(new Soil("Black0", "Apple", 10.0));
        black.add(new Soil("Black1", "Banana", 11.0));
        black.add(new Soil("Black2", "Grape", 12.0));

        red.add(new Soil("Red0", "Apple", 10.0));
        red.add(new Soil("Red1", "Banana", 11.0));
        red.add(new Soil("Red2", "Grape", 12.0));

        sandy.add(new Soil("Sandy0", "Apple", 10.0));
        sandy.add(new Soil("Sandt1", "Banana", 11.0));
        sandy.add(new Soil("Sandy2", "Grape", 12.0));
    }

    public Crop_Analysis_Model() {
        black = new ArrayList<Soil>();
        red = new ArrayList<Soil>();
        sandy = new ArrayList<Soil>();
        loadSoils();;
    }

    private static Crop_Analysis_Model cpModel = null;
    public static Crop_Analysis_Model getCrop_protection(){
        if (cpModel == null){
            cpModel = new Crop_Analysis_Model();
        }
        return cpModel;
    }

    public void addBlackSoil(String title, String crop, double temperature){
        black.add(new Soil(title, crop, temperature));
    }

    public void addRedSoil(String title, String crop, double temperature){
        red.add(new Soil(title, crop, temperature));
    }

    public void addSandySoil(String title, String crop, double temperature){
        sandy.add(new Soil(title, crop, temperature));
    }
}


