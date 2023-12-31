package com.sylman.nursery.human_friends;

public class Cat extends Animals{

    public Cat(String name, String skills) {
        super(name, skills);
    }

    @Override
    public void printName() {
        System.out.println("Cat name is: " + getName());
    }

    @Override
    public void printSkills() {
        System.out.println("there's skills of " + getName() + ": " + getSkills());
    }
}
