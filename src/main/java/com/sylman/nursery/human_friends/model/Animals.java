package com.sylman.nursery.human_friends;

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

    public abstract void printName();

    public abstract void printSkills();


}
