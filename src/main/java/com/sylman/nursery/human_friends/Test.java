package com.sylman.nursery.human_friends;

import com.sylman.nursery.human_friends.model.Animals;
import com.sylman.nursery.human_friends.model.Cat;
import com.sylman.nursery.human_friends.model.Dog;
import com.sylman.nursery.human_friends.presenter.exceptions.MenuOptionException;
import com.sylman.nursery.human_friends.view.ConsoleUI;
import com.sylman.nursery.human_friends.view.View;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws MenuOptionException {
        View view = new ConsoleUI();
        view.start();
    }
}
