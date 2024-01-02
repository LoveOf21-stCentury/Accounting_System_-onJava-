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

    public void printName() {
        presenter.printName();
    }

    public void printSkills() {
        presenter.printSkills();
    }

    public void addNewAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What name is gonna be");
        String name = scanner.nextLine();
        LocalDate dateBirth = checkDate();
        System.out.println("What skills does he/she has");
        String skills = scanner.nextLine();
        presenter.addNewAnimal(name, dateBirth, skills);
    }

    public void getAnimalsInfo() {
        presenter.getAnimalsInfo();
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

    public LocalDate checkDate() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        try {
//            return LocalDate.parse(dateOfBirth, formatter);
//        } catch (DateTimeParseException e) {
//            throw new DateException();
//        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        boolean validInput = false;
        LocalDate dateBirth = null;

        while (!validInput) {
            try {
                System.out.print("Enter date of birth IN FORMAT: DD-MM-YYYY:\n");
                String input = scanner.nextLine();
                dateBirth = LocalDate.parse(input, formatter);
                validInput = true;
            } catch (Exception e) {
                System.err.println("Incorrect format of date. Try again.");
                scanner.nextLine();
            }
        }
        return dateBirth;
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