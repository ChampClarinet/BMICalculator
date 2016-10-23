package com.example.clarinetmaster.bmicalculator;

public class Human {

    double height;
    double weight;
    double BMI;

    public Human(String h, String w){
        this.height = Double.parseDouble(h)/100;
        this.weight = Double.parseDouble(w);
        calculateBMI();
    }

    private void calculateBMI() {
        BMI = weight/(height*height);
    }

    public String getBMI() {
        String output = Double.toString(BMI);
        return output.substring(0, 5);
    }

    public int getResults(){
        if(BMI < 18.5) return R.string.thin;
        else if(BMI < 25) return R.string.normal;
        else if(BMI < 30) return R.string.high;
        return R.string.obese;
    }

}
