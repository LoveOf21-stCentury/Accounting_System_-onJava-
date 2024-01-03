package com.sylman.nursery.human_friends.model.animals;

public abstract class Animals {
    private String name;
    private String skills;

    public Animals(String name, String skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getSkills() {
        return skills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public abstract void printSkills();

    public abstract void addNewSkill(String skill);

    // TODO: 12/31/2023 override toString method
}
