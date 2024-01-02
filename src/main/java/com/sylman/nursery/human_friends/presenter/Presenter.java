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

    public void printName() {
        String answer = service.printName();
        view.printAnswer(answer);
    }

    public void printSkills() {
        String skills = service.printSkills();
        System.out.println(skills);
    }

    public void addNewAnimal(String name, String skills) {
        service.addNewAnimal(name, skills);
    }

}
