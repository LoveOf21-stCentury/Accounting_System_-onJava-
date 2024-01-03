package com.sylman.nursery.human_friends.model;

import com.sylman.nursery.human_friends.model.animals.*;

import java.util.Scanner;

public class Service {
    public Animals animals;
    Scanner scanner;

    public Service() {
        scanner = new Scanner(System.in);
    }

    public void addNewAnimal() {
        System.out.println("What name is gonna be");
        String name = scanner.nextLine();
        System.out.println("What skills does he/she has");
        String skills = scanner.nextLine();

        System.out.println("Select the class: ");
        System.out.println("1. Cat");
        System.out.println("2. Dog");
        System.out.println("3. Hamster");
        System.out.println("4. Camel");
        System.out.println("5. Donkey");
        System.out.println("6. Horse");
        int user = scanner.nextInt();
        scanner.nextLine();

        switch (user) {
            case 1 -> animals = new Cat(name, skills);
            case 2 -> animals = new Dog(name, skills);
            case 3 -> animals = new Hamster(name, skills);
            case 4 -> animals = new Camel(name, skills);
            case 5 -> animals = new Donkey(name, skills);
            case 6 -> animals = new Horse(name, skills);
            default -> {
                System.out.println("Wrong input");
            }
        }
    }

    public void printName() {
        System.out.println("Name is: " + animals.getName());
    }

    public void printSkills() {
        System.out.println("Enter the name of whose skills need to be printed");
        String name = scanner.nextLine();
        // TODO: 1/3/2024 method for printing. maybe in database
    }

    public void addNewSkill() {
        System.out.println("Type new skill: ");
        Scanner scanner = new Scanner(System.in);
        String newSkill = scanner.nextLine();
        animals.setSkills(newSkill);
    }
}
