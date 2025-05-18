package com.example.mbi_calculator;

import java.io.Serializable;

public class BMIResult implements Serializable {
    public enum Gender {
        MAN,
        WOMAN
    }
    public enum BMICategory {
        UNDERNUTRITION,
        NORMAL,
        OVERWEIGHT,
        OBESITY
    }

    public String name;
    public Gender gender;
    public int age;
    public int height;
    public int weight;

    public BMIResult(String name, Gender gender, int age, int height, int weight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getGenderString() {
         if(gender == Gender.MAN)
             return "Man";
         else
             return "Woman";
    }
    public String getUserInfo() {
        return this.name + " (" + this.age + ", " + this.getGenderString() + ")";
    }
    public double getBMIValue() {
        double heightM = this.height / 100.0;
        return weight / (heightM * heightM);
    }
    public BMICategory getBMICategory() {
        double bmiValue = getBMIValue();
        if(bmiValue < 18.5)
            return  BMICategory.UNDERNUTRITION;
        if(bmiValue >= 18.5 && bmiValue < 25.0)
            return BMICategory.NORMAL;
        if(bmiValue >= 25.0 && bmiValue < 30.0)
            return BMICategory.OVERWEIGHT;

        return BMICategory.OBESITY;
    }
    public String getBMICategoryString() {
        BMICategory cat = getBMICategory();
        if(cat == BMICategory.UNDERNUTRITION)
            return "Pothranjenost";
        if(cat == BMICategory.NORMAL)
            return "Normalna težina";
        if(cat == BMICategory.OVERWEIGHT)
            return  "Prekomerna težina";

        return "Gojaznost";
    }
}
