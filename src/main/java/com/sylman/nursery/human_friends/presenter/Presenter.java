package com.sylman.nursery.human_friends.presenter;

import com.sylman.nursery.human_friends.model.Service;
import com.sylman.nursery.human_friends.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addNewAnimal() {
        service.addNewAnimal();
    }

    public void printName() {
        service.printName();
    }

    public void printSkills() {
        service.printSkills();
    }

    public void addNewSkill() {
        service.addNewSkill();
    }
}
