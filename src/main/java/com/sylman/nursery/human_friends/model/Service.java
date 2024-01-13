package com.sylman.nursery.human_friends.model;

import com.sylman.nursery.human_friends.model.animals.*;

import java.util.Scanner;

public class Service {
    public Animals animals;
    Scanner scanner;
    DataBase dataBase;

    public Service() {
        scanner = new Scanner(System.in);
        dataBase = new DataBase();
    }

    public Animals addNewAnimal() {
        dataBase.addNewAnimal();

        return dataBase.addNewAnimal();
    }

    public void printTable() {
        dataBase.printFullTable();
    }

    public void printSkills() {
        System.out.println("Enter the name of whose skills need to be printed");
        String name = scanner.nextLine();
        dataBase.printSkills(name);
        // TODO: 1/3/2024 method for printing. maybe in database
    }

    public void addNewSkill() {
//        System.out.println("Type new skill: ");
//        Scanner scanner = new Scanner(System.in);
//        String newSkill = scanner.nextLine();
//        animals.setSkills(newSkill);
        // TODO: 1/13/2024 clear
        System.out.println("Type name ");
        String name = scanner.nextLine();
        System.out.println("Type new skills: ");
        String newSkill = scanner.nextLine();
        dataBase.addNewSkill(name, newSkill);
    }
}
