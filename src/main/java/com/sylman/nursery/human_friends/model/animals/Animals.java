package com.sylman.nursery.human_friends.model.animals;

import java.time.LocalDate;
import java.time.Period;

public abstract class Animals {
    private String name;
    private String skills;
    private LocalDate dateBirth;

    public Animals(String name, LocalDate dateBirth, String skills) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public String getSkills() {
        return skills;
    }

    public int getAge() {
        return getPeriod(dateBirth, LocalDate.now());
    }

    public int getPeriod(LocalDate dateBirth, LocalDate endDate) {
        Period diff = Period.between(dateBirth, endDate);
        return diff.getDays();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public abstract void printSkills();

    public abstract void addNewSkill(String skill);

    // TODO: 12/31/2023 override toString method
}
