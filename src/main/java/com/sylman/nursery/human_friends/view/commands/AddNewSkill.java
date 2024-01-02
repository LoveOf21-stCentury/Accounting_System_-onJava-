package com.sylman.nursery.human_friends.view.commands;

import com.sylman.nursery.human_friends.view.ConsoleUI;

public class AddNewSkill extends Command {
    public AddNewSkill(ConsoleUI consoleUI) {
        super(consoleUI);
        descriptions = "Teach new skill";
    }

    @Override
    public void execute() {
        consoleUI.addNewSkill();
    }
}
