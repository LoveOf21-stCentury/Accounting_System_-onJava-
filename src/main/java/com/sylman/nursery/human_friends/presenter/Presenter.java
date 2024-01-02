package com.sylman.nursery.human_friends.presenter;

import com.sylman.nursery.human_friends.model.Service;
import com.sylman.nursery.human_friends.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void printName() {
        service.printName();
    }

    public void printSkills() {
        service.printSkills();
    }

    public void addNewAnimal(String name, LocalDate dateBirth, String skills){
        service.addNewAnimal(name, dateBirth, skills);
    }

    public void getAnimalsInfo(){
        service.getAnimalsInfo();
    }
}
