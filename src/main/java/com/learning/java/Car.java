package com.learning.java;

/**
 * Class with constructor example.
 */
public class Car {
    String model;
    int year;


    /**
     * default constructors
     */
    public Car() {
    }

    /**
     * Parameterised constructor
     */
    public Car(String model){
        this.model = model;
    }

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    /**
     *
     * @return exampleType
     */
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * This method will show
     * current value of field
     * exampleType
     */
    void drive() {
        System.out.println("car being driven");
    }

    @Override
    public String toString() {
        return "Car{" +
                  "model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
