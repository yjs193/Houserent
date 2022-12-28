package com.poly;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog("小黑");
        bone bone1 = new bone("bone");
        Master tom = new Master();
        tom.feed(dog,bone1);
        
    }
}
