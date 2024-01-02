package com.sylman.nursery.human_friends.model.pack_animals;

import java.time.LocalDate;

public class Horse extends PackAnimal{
    public Horse(String name, LocalDate dateBirth, String skills) {
        super(name, dateBirth, skills);
    }

    @Override
    public void printSkills() {
        System.out.println("Skills of horses: ");
        System.out.println(getSkills());
    }

    @Override
    public void addNewSkill(String skill) {
        String newSkill = getSkills() + ", " + skill;
        setSkills(newSkill);
    }

}
