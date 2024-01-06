package com.sylman.nursery.human_friends.model;

import com.sylman.nursery.human_friends.model.animals.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Service {
    public Animals animals;
    Scanner scanner;

    public Service() {
        scanner = new Scanner(System.in);
    }

    public Animals addNewAnimal() {
        System.out.println("What name is gonna be");
        String name = scanner.nextLine();

        LocalDate dateBirth = checkDate();

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
            case 1 -> animals = new Cat(name, dateBirth, skills);
            case 2 -> animals = new Dog(name, dateBirth, skills);
            case 3 -> animals = new Hamster(name, dateBirth, skills);
            case 4 -> animals = new Camel(name, dateBirth, skills);
            case 5 -> animals = new Donkey(name, dateBirth, skills);
            case 6 -> animals = new Horse(name, dateBirth, skills);
            default -> {
                System.out.println("Wrong input");
            }
        }

        animals.setName(name);
        animals.setDateBirth(dateBirth);
        animals.setSkills(skills);
        return animals;
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

    public LocalDate checkDate() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        try {
//            return LocalDate.parse(dateOfBirth, formatter);
//        } catch (DateTimeParseException e) {
//            throw new DateException();
//        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        boolean validInput = false;
        LocalDate dateBirth = null;

        while (!validInput) {
            try {
                System.out.print("Enter date of birth IN FORMAT: YYYY-MM-DD:\n");
                String input = scanner.nextLine();
                dateBirth = LocalDate.parse(input, formatter);
                validInput = true;
            } catch (Exception e) {
                System.err.println("Incorrect format of date. Try again.");
                scanner.nextLine();
            }
        }
        return dateBirth;
    }
}
