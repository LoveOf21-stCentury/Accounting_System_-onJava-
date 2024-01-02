package com.sylman.nursery.human_friends.view.commands;

import com.sylman.nursery.human_friends.view.ConsoleUI;

public class GetAnimalsInfo extends Command {
    public GetAnimalsInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        descriptions = "Get info about animals";
    }

    @Override
    public void execute() {
        consoleUI.getAnimalsInfo();
    }
}
