package com.sylman.nursery.human_friends.model;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.Period;

public class Animals {
    private long id;
    private String name;
    private String skills;
    private LocalDate dateBirth;
    private LocalDate dateDeath;

    public Animals(String name, LocalDate dateBirth, LocalDate dateDeath, String skills) {
        this.id = 1;
        this.name = name;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.skills = skills;
    }

    public Animals(String name, LocalDate dateBirth, String skills) {
        this(name, dateBirth, null, skills);
    }

    public long getId() {
        return id;
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

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString(){
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id + 1);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", age: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSkills());
        return sb.toString();
    }

    // TODO: 12/31/2023 override toString method
}
