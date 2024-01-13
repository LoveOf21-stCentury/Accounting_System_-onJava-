package com.sylman.nursery.human_friends.view.commands;

import com.sylman.nursery.human_friends.view.ConsoleUI;

public class PrintTable extends Command{

    public PrintTable(ConsoleUI consoleUI){
        super(consoleUI);
        descriptions = "Recording full table in .txt file";
    }
    @Override
    public void execute() {
        consoleUI.printTable();
    }
}
