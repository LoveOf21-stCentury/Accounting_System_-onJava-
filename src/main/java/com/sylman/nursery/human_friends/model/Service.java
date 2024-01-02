package com.sylman.nursery.human_friends.model;

public class Service {
    Animals animals;

    //    public Service(){
//
//    }
    public String printName() {
//        System.out.println("Name is: " + animals.getName());
        return animals.getName();
    }

    public String printSkills() {
//        System.out.println("there's skills of " + animals.getName() + ": " +
//                animals.getSkills());
        return animals.getSkills();
    }

    public void addNewAnimal(String name, String skills) {
        animals = new Animals(name, skills);
        System.out.println("Added");
    }
}
