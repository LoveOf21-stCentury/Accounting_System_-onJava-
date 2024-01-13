package com.sylman.nursery.human_friends.model;

import com.sylman.nursery.human_friends.model.animals.*;

import java.util.Scanner;

public class Service {
    public Animals animals;
    Scanner scanner;
    DataBase dataBase;

    public Service() {
        scanner = new Scanner(System.in);
    }

    public Animals addNewAnimal() {
        dataBase = new DataBase();
        dataBase.addNewAnimal();

        return dataBase.addNewAnimal();
    }

    public void printTable() {
        dataBase = new DataBase();
        dataBase.print();
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
