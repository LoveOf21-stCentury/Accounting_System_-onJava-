package com.sylman.nursery.human_friends.model.pack_animals;

import com.sylman.nursery.human_friends.model.animals.Animals;

import java.time.LocalDate;

public class Camel extends PackAnimal {
    public Camel(String name, LocalDate dateBirth, String skills) {
        super(name, dateBirth, skills);
    }

    @Override
    public void printSkills() {
        System.out.println("Skills of camels: ");
        System.out.println(getSkills());
    }

    @Override
    public void addNewSkill(String skill) {
        String newSkill = getSkills() + ", " + skill;
        setSkills(newSkill);
    }
}
