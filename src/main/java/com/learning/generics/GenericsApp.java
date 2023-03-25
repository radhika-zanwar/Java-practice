package com.learning.generics;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.util.ArrayList;
import java.util.List;

public class GenericsApp {
    public static void main(String[] args) {

        List<Animal> animalList = new ArrayList<Animal>();
        animalList.add(new Dog());
        animalList.add(new Feline());
        animalList.add(new RobotDog());
        /**
         * Below declaration is fine
         * as long as we don't add as of type
         * safety issues.
         * Ex cat object beling added to
         * dogList
         */
        List<? extends Animal> dogList = new ArrayList<Dog>();
        /** why above assignment works but below add fails
         * is because of Generic type mismatch.
         * and when we try to perform add there is an issue
         * with respect to type safety. cats being put in dog array.
         */
        /*dogList.add(new Dog());
        dogList.add(new Feline());
        dogList.add(new RobotDog());
        */

        List<? super Dog> list = new ArrayList<Animal>();
        list.add(new Dog());
        list.add(new RobotDog());
        /**
         * The below adds fail. Why?
         */
        //list.add(new Feline());
        System.out.println("List is "+list);

        /**
         * Below will not work.
         * Generic Type should be same.
         */
        //List<Dog> listAnimal = new ArrayList<Animal>();
        //List<Animal> anmList = new ArrayList<Dog>();
        /*listAnimal.add(new Dog());
        listAnimal.add(new RobotDog());*/

        /**
         * This won't work.
         */
        // List<? super Animal> listSuperTest = new ArrayList<Dog>();

        /**
         * This works because it can take Animal
         * or any class super to Animal.
         */
        List<? super Animal> listWithSuperGenericType = new ArrayList<Object>();

        List<Feline> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new RobotDog());

        AnimalDoctor doctor = new AnimalDoctor();
        doctor.doCheckup(dogs);
    }
}
