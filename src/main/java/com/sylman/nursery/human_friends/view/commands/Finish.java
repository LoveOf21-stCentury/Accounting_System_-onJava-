package com.sylman.nursery.human_friends.view.commands;

import com.sylman.nursery.human_friends.view.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI){
        super(consoleUI);
        descriptions = "Finish";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}
