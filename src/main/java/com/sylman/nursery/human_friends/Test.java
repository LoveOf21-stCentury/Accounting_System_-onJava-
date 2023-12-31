package com.sylman.nursery;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What name is gonna be");
        String name = scanner.nextLine();
        System.out.println("What skills does he/she has");
        String skills = scanner.nextLine();
        Animals dog = new Dog(name, skills);
        dog.printName();
        dog.printSkills();
        Animals cat = new Cat(name, skills);
        cat.printName();
        cat.printSkills();

    }
}
