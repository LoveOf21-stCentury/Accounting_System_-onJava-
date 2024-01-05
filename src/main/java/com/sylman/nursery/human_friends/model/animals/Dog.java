package com.sylman.nursery.human_friends.model.animals;

import java.time.LocalDate;

public class Dog extends Animals {
    public Dog(String name, LocalDate dateBirth, String skills) {
        super(name, dateBirth, skills);
    }

    @Override
    public void printSkills() {
        System.out.println("Skills of dogs: ");
        System.out.println(getSkills());
    }

    @Override
    public void addNewSkill(String skill) {
        String newSkill = getSkills() + ", " + skill;
        setSkills(newSkill);
    }
}
