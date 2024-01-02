package com.sylman.nursery.human_friends.model;

public class Service {
    Animals animals;

    public void printName() {
        System.out.println("Name is: " + animals.getName());
    }

    public void printSkills() {
        System.out.println("there's skills of " + animals.getName() + ": " +
                animals.getSkills());
    }
    public void addNewAnimal(String name, String skills){
       animals = new Animals(name, skills);
    }
}
