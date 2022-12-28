package com.poly;

public class Master {
    public void feed(Animal animal, Food food) {
        System.out.println("animal" + animal + "food" + food);
        System.out.println(animal.getName() + "吃" + food.getName());
    }
}
