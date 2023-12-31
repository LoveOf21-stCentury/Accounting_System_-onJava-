package com.sylman.nursery.human_friends;

public class Dog extends Animals{
    public Dog(String name, String skills) {
        super(name, skills);
    }

    @Override
    public void printName() {
        System.out.println("Dog name is: " + getName());
    }

    @Override
    public void printSkills() {
        System.out.println("there's skills of " + getName() + ": " + getSkills());
    }
}
