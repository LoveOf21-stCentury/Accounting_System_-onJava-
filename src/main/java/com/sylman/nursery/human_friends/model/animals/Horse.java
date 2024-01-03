package com.sylman.nursery.human_friends.model.animals;

public class Horse extends Animals {
    public Horse(String name, String skills) {
        super(name, skills);
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
