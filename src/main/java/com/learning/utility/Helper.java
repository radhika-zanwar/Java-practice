package com.learning.utility;


import com.learning.java.Car;

public class Helper {
    /**
     * variable values which are used frequently in other classes
     * 4Methods which are used to help other classes.
    */
    public static void increaseMakeYearBy(Car car){
        int currYear = car.getYear();
        int newMakeYear = currYear + 2;
        car.setYear(newMakeYear);

    }

}
