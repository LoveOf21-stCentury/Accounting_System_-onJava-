package com.sylman.nursery.human_friends.model;

import com.sylman.nursery.human_friends.model.animals.*;

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

    public Animals addNewAnimal() {
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

    public void print(Animals animals) {
        String sql = "SELECT * FROM nursery";
        try (Connection connection = this.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                Date dateBirth = resultSet.getDate("dateBirth");
                String skills = resultSet.getString("skills");

                System.out.println("Type: " + type);
                System.out.println("Name: " + name);
                System.out.println("Date of birth: " + dateBirth);
                System.out.println("Skills: " + skills);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
