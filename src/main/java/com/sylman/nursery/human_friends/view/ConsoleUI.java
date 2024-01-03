package com.sylman.nursery.human_friends.view;

import com.sylman.nursery.human_friends.model.Service;
import com.sylman.nursery.human_friends.presenter.Presenter;
import com.sylman.nursery.human_friends.presenter.exceptions.MenuOptionException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public void addAnimal() throws MenuOptionException {
        presenter.addNewAnimal();
    }

    public void printName() {
        presenter.printName();
    }

    public void printSkills() {
        presenter.printSkills();
    }

    public void addNewSkill() {
        presenter.addNewSkill();
    }

    private boolean checkCommand(int numbCommand) throws MenuOptionException {
//        if (numbCommand > menu.getSize()) {
//            throw new MenuOptionException("Wrong input");
//        } else {
//            return true;
//        }
        try {
            if (numbCommand > menu.getSize()) {
                System.err.println("Please select an option from 1 to " + menu.getSize() + ".");
                return false;
            }
            return true;
        } catch (Exception e) {
            throw new MenuOptionException();
        }
    }

    public boolean checkTextForInt(String text) throws MenuOptionException {
//        if (!text.matches("[0-9]+")){
//            throw new MenuOptionException("You're input not number");
//        } else {
//            return true;
//        }
        try {
            if (!text.matches("[0-9]+")) {
                System.err.println("Please enter integer number.");
                return false;
            }
            return true;
        } catch (Exception e) {
            throw new MenuOptionException();
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

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}