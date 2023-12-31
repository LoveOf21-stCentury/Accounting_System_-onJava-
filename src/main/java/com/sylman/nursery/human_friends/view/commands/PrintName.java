package com.sylman.nursery.human_friends.view.commands;

import com.sylman.nursery.human_friends.view.ConsoleUI;

public class PrintName extends Command{

    public PrintName(ConsoleUI consoleUI){
        super(consoleUI);
        descriptions = "Print name of animal";
    }
    @Override
    public void execute() {
        consoleUI.printName();
    }
}
