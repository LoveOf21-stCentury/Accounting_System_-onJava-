package com.sylman.nursery.human_friends;

import com.sylman.nursery.human_friends.presenter.exceptions.MenuOptionException;
import com.sylman.nursery.human_friends.view.ConsoleUI;
import com.sylman.nursery.human_friends.view.View;

public class Test {
    public static void main(String[] args) throws MenuOptionException {
        View view = new ConsoleUI();
        view.start();
    }
}
