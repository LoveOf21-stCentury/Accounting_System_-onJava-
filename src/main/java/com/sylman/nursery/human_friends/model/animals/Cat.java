package com.sylman.nursery.human_friends.model.animals;

import java.time.LocalDate;

public class Cat extends Animals {
    public Cat(String name, String skills) {
        super(name, skills);
    }

    @Override
    public void printSkills() {
        System.out.println("Skills of cats: ");
        System.out.println(getSkills());
    }

    @Override
    public void addNewSkill(String skill) {
        String newSkill = getSkills() + ", " + skill;
        setSkills(newSkill);
    }
}
