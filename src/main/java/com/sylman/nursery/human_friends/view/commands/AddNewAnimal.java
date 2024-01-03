package com.sylman.nursery.human_friends.view.commands;

import com.sylman.nursery.human_friends.presenter.exceptions.MenuOptionException;
import com.sylman.nursery.human_friends.view.ConsoleUI;

public class AddNewAnimal extends Command {

    public AddNewAnimal(ConsoleUI consoleUI) {
        super(consoleUI);
        descriptions = "Add new animal";
    }

    @Override
    public void execute() throws MenuOptionException {
        consoleUI.addAnimal();
    }
}
