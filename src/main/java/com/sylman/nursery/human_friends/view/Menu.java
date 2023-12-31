package com.sylman.nursery.human_friends.view;

import com.sylman.nursery.human_friends.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commandList;

    public Menu(ConsoleUI consoleUI) {
        commandList = new ArrayList();
        commandList.add(new AddNewAnimal(consoleUI));
        commandList.add(new PrintName(consoleUI));
        commandList.add(new PrintSkills(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String showMenu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int user) {
        Command command = commandList.get(user - 1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
