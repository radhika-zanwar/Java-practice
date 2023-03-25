package com.learning.generics;

import java.util.List;

public class AnimalDoctor {

    void doCheckup(List<? super Dog> animals) {
    animals.add(new Dog());
    animals.add(new RobotDog());
    }
}
