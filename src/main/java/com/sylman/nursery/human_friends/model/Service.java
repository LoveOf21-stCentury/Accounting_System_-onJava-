package com.sylman.nursery.human_friends.model;

import com.sylman.nursery.human_friends.model.animals.Animals;
import com.sylman.nursery.human_friends.model.animals.Cat;
import com.sylman.nursery.human_friends.model.animals.Dog;
import com.sylman.nursery.human_friends.model.animals.Hamster;
import com.sylman.nursery.human_friends.model.pack_animals.Camel;
import com.sylman.nursery.human_friends.model.pack_animals.Donkey;
import com.sylman.nursery.human_friends.model.pack_animals.Horse;
import com.sylman.nursery.human_friends.model.pack_animals.PackAnimal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private List<Animals> animalList = new ArrayList<>();
    public long id;
    public Animals animals;
    public PackAnimal packAnimal;

    //    public void addNewAnimal(String name, LocalDate dateBirth, String skills) {
//        animals = new Animals(name, dateBirth, skills);
//        id++;
//    }
    public void addNewAnimal(int userAnswer, String name, LocalDate dateBirth, String skills) {
        switch (userAnswer) {
            case 1 -> animals = new Cat(name, dateBirth, skills);
            case 2 -> animals = new Dog(name, dateBirth, skills);
            case 3 -> animals = new Hamster(name, dateBirth, skills);
            case 4 -> packAnimal = new Camel(name, dateBirth, skills);
            case 5 -> packAnimal = new Donkey(name, dateBirth, skills);
            case 6 -> packAnimal = new Horse(name, dateBirth, skills);
            default -> {
                System.out.println("Wrong input");
            }
        }
    }

    public void printName() {
        System.out.println("Name is: " + animals.getName());
    }

//    public void printSkills() {
//        System.out.println("Enter the name of whose skills need to be printed");
//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//        for (Animals animal : animalList) {
//            if (animal.getName().equals(name)) {
//                System.out.println("Here's skills of " + animals.getName() + ": " +
//                        animals.getSkills());
//            }
//        }
//    }

    public void addNewSkill() {
        System.out.println("Type new skill: ");
        Scanner scanner = new Scanner(System.in);
        String newSkill = scanner.nextLine();
        animals.setSkills(newSkill);
    }
}
