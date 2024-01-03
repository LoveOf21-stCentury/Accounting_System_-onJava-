package com.sylman.nursery.human_friends.view.commands;

import com.sylman.nursery.human_friends.presenter.exceptions.MenuOptionException;
import com.sylman.nursery.human_friends.view.ConsoleUI;

public abstract class Command {
    String descriptions;
    ConsoleUI consoleUI;
    public Command(ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
    }

    public String getDescription(){
        return descriptions;
    }

    public abstract void execute() throws MenuOptionException;

}
