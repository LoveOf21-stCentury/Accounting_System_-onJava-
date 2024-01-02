package com.sylman.nursery.human_friends.model;

import java.time.LocalDate;

public class Service {
    long id;
    Animals animals;

    public void printName() {
        System.out.println("Name is: " + animals.getName());
    }

    public void printSkills() {
        System.out.println("there's skills of " + animals.getName() + ": " +
                animals.getSkills());
    }

    public void addNewAnimal(String name, LocalDate dateBirth, String skills) {
        animals = new Animals(name, dateBirth, skills);
        id++;
    }
    public String getAnimalsInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Full list of animals:\n");
        sb.append(animals.toString());
        return sb.toString();
    }
}
