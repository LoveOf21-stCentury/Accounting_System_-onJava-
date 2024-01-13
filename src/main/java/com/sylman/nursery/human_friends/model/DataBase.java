package com.sylman.nursery.human_friends.model;

import com.sylman.nursery.human_friends.model.animals.*;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DataBase {

    //    For educational purposes, we will leave these data as CONSTANTS here.
    //    In a real project, this data would be stored in a separate external file.
    private static final String URL = "jdbc:mysql://localhost:3306/nurserydb";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    private Scanner scanner;

    public DataBase() {
        this.scanner = new Scanner(System.in);
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private boolean isAdded = false;

    public Animals addNewAnimal() {
        if (isAdded) {
            System.out.println("Added");
            return null;
        }
        System.out.println("Enter the name of the animal:");
        String name = scanner.nextLine();

        LocalDate dateBirth = checkDate();

        System.out.println("Enter the skills of the animal:");
        String skills = scanner.nextLine();

        System.out.println("Select the type of animal:");
        System.out.println("1. Cat");
        System.out.println("2. Dog");
        System.out.println("3. Hamster");
        System.out.println("4. Camel");
        System.out.println("5. Donkey");
        System.out.println("6. Horse");

        Animals animal = null;
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                animal = new Cat(name, dateBirth, skills);
                break;
            case 2:
                animal = new Dog(name, dateBirth, skills);
                break;
            case 3:
                animal = new Hamster(name, dateBirth, skills);
                break;
            case 4:
                animal = new Camel(name, dateBirth, skills);
                break;
            case 5:
                animal = new Donkey(name, dateBirth, skills);
                break;
            case 6:
                animal = new Horse(name, dateBirth, skills);
                break;
            default:
                System.out.println("Invalid option selected.");
                return null;
        }

        insertAnimalIntoDB(animal);
        isAdded = true;
        return animal;
    }

    private void insertAnimalIntoDB(Animals animal) {
        String sql = "INSERT INTO nursery (type, name, dateBirth, skills) VALUES (?, ?, ?, ?)";
        try (Connection connection = this.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, animal.getClass().getSimpleName());
            preparedStatement.setString(2, animal.getName());
            preparedStatement.setDate(3, java.sql.Date.valueOf(animal.getDateBirth()));
            preparedStatement.setString(4, animal.getSkills());
            preparedStatement.executeUpdate();
            System.out.println("Animal added to database successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private LocalDate checkDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateBirth = null;
        while (dateBirth == null) {
            try {
                System.out.print("Enter date of birth (YYYY-MM-DD):\n");
                String input = scanner.nextLine();
                dateBirth = LocalDate.parse(input, formatter);
            } catch (Exception e) {
                System.err.println("Incorrect format of date. Try again.");
            }
        }
        return dateBirth;
    }

    public void printFullTable() {
        String sql = "SELECT * FROM nursery";
        try (Connection connection = this.connect();
             BufferedWriter writer = Files.newBufferedWriter(Paths.get("nursery.txt"));
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                Date dateBirth = resultSet.getDate("dateBirth");
                String skills = resultSet.getString("skills");

                writer.write("Type: " + type + "\n");
                writer.write("Name: " + name + "\n");
                writer.write("Date of birth: " + dateBirth + "\n");
                writer.write("Skills: " + skills + "\n\n");
            }
            System.out.println("Successfully recorded. " +
                    "The file will be created after finishing work in the console menu.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewSkill(String animalName, String newSkills) {
        String sql = "UPDATE nursery SET skills = CONCAT(skills, ', ', ?) WHERE name = ?";
        try (Connection connection = this.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newSkills);
            preparedStatement.setString(2, animalName);
            preparedStatement.executeUpdate();
            System.out.println("Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printSkills(String animalName) {
        String sql = "SELECT skills FROM nursery WHERE name = ?";
        try (Connection connection = this.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, animalName);
            ResultSet resultSet = preparedStatement.executeQuery();
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("skills.txt"))) {
                while (resultSet.next()) {
                    String skills = resultSet.getString("skills");
                    writer.write("Skills of: " + animalName + " is: " + skills + "\n");
                }
                System.out.println("Successfully recorded." +
                        "The file will be created after finishing work in the menu.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

