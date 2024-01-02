package com.sylman.nursery.human_friends.model.pack_animals;

import java.time.LocalDate;
import java.time.Period;

public abstract class PackAnimal {
    private String name;
    private String skills;
    private LocalDate dateBirth;
    private LocalDate dateDeath;

    public PackAnimal(String name, LocalDate dateBirth, LocalDate dateDeath, String skills) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.skills = skills;
    }

    public PackAnimal(String name, LocalDate dateBirth, String skills) {
        this(name, dateBirth, null, skills);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public LocalDate getDateDeath() {
        return dateDeath;
    }

    public String getSkills() {
        return skills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setDateDeath(LocalDate dateDeath) {
        this.dateDeath = dateDeath;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getAge() {
        if (dateDeath == null) {
            return getPeriod(dateBirth, LocalDate.now());
        } else {
            return getPeriod(dateBirth, dateDeath);
        }
    }

    private int getPeriod(LocalDate dateBirth, LocalDate dateDeath) {
        Period diff = Period.between(dateBirth, dateDeath);
        return diff.getYears();
    }

    public abstract void printSkills();
    public abstract void addNewSkill(String skill);

}
