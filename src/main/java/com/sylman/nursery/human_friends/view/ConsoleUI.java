package com.sylman.nursery.human_friends.view;

import com.sylman.nursery.human_friends.model.Animals;
import com.sylman.nursery.human_friends.model.Service;
import com.sylman.nursery.human_friends.presenter.Presenter;
import com.sylman.nursery.human_friends.presenter.exceptions.MenuOptionException;

import java.util.Scanner;

public class ConsoleUI implements View {
    private boolean work;
    private Menu menu;
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUI() {
        work = true;
        menu = new Menu(this);
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public Service start() throws MenuOptionException {
        hello();
        while (work) {
            printMenu();
            execute();
        }
        return null;
    }

    public void hello() {
        System.out.println("Welcome to menu");
    }

    public void finish() {
        System.out.println("You are completed work");
        work = false;
    }

    public void printName() {
        System.out.print("Name is: ");
        presenter.printName();

    }

    public void printSkills() {
        System.out.print("there's skills of ");
        presenter.printName();
        System.out.print(": ");
        presenter.printSkills();
    }

    public void addNewAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What name is gonna be");
        String name = scanner.nextLine();
        System.out.println("What skills does he/she has");
        String skills = scanner.nextLine();
        presenter.addNewAnimal(name, skills);
    }

    private boolean checkCommand(int numbCommand) throws MenuOptionException {
        if (numbCommand > menu.getSize()) {
            throw new MenuOptionException("Wrong input");
        } else {
            return true;
        }
    }

    private void printMenu() {
        System.out.println(menu.showMenu());
    }

    private void execute() throws MenuOptionException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numbCommand = Integer.parseInt(line);
            if (checkCommand(numbCommand)) {
                menu.execute(numbCommand);
            }
        }
    }

    public boolean checkTextForInt(String text) throws MenuOptionException {
        if (!text.matches("[0-9]+")) {
            throw new MenuOptionException("You're input not number");
        } else {
            return true;
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}