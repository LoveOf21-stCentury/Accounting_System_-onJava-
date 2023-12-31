package com.sylman.nursery.human_friends.view.commands;

import com.sylman.nursery.human_friends.view.ConsoleUI;

public class PrintSkills extends Command{
    public PrintSkills(ConsoleUI consoleUI){
        super(consoleUI);
        descriptions = "Print Skills";
    }
    @Override
    public void execute() {
        consoleUI.printSkills();
    }
}
