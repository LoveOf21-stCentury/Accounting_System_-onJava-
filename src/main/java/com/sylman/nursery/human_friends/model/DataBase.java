package com.sylman.nursery.human_friends.model;

import com.sylman.nursery.human_friends.model.animals.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {

    //    For educational purposes, we will leave these data as CONSTANTS here.
//    In a real project, this data would be stored in a separate external file
    private static final String URL = "jdbc:mysql://localhost:3306/nurserydb";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    private static Connection connection;

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
        // Add more options if needed

        Animals animal = null;
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline

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
            // Add more cases as needed
            default:
                System.out.println("Invalid option selected.");
                return null;
        }

        // Insert the data into the database
        insertAnimalIntoDB(animal);

        // Return the constructed animal object
        return animal;
    }

//    private Animals chooseAnimalType(String name, LocalDate dateBirth, String skills) {
//        System.out.println("Select the class: ");
//        System.out.println("1. Cat");
//        System.out.println("2. Dog");
//        System.out.println("3. Hamster");
//        System.out.println("4. Camel");
//        // ... other options
//        int choice = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        switch (choice) {
//            case 1:
//                return new Cat(name, dateBirth, skills);
//            case 2:
//                return new Dog(name, dateBirth, skills);
//            case 3:
//                return new Hamster(name, dateBirth, skills);
//            case 4:
//                return new Camel(name, dateBirth, skills);
//            // ... other cases
//            default:
//                return null;
//        }
//    }

    private void insertAnimalIntoDB(Animals animal) {
        String sql = "INSERT INTO nursery (name, dateBirth, skills) VALUES (?, ?, ?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, animal.getName());
            pstmt.setDate(2, java.sql.Date.valueOf(animal.getDateBirth()));
            pstmt.setString(3, animal.getSkills());
            pstmt.executeUpdate();
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
//    Service service = new Service();
//
//
//    static {
//        try {
//            Class.forName("org.mysql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Animals> index() {
//        List<Animals> animals = new ArrayList<>();
//
//        try {
//            Statement statement = connection.createStatement();
//            String SQL = "SELECT * FROM nursery";
//            ResultSet resultSet = statement.executeQuery(SQL);
//
//            while (resultSet.next()) {
//                Animals animal = service.addNewAnimal();
//                animal.setId(resultSet.getLong("id"));
//                animal.setName(resultSet.getString("name"));
//                animal.setDateBirth(resultSet.getDate("age").toLocalDate());
//                animal.setSkills(resultSet.getString("skills"));
//
//                animals.add(animal);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return animals;
//    }
//
//    public Animals show(int id) {
//        Animals animals = null;
//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("SELECT * FROM nursery WHERE id=?");
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            resultSet.next();
//            animals = service.addNewAnimal();
//
//            animals.setId(resultSet.getInt("id"));
//            animals.setName(resultSet.getString("name"));
//            animals.setDateBirth(resultSet.getDate("age").toLocalDate());
//            animals.setSkills(resultSet.getString("skills"));
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return animals;
//    }
//
//    public void save(Animals animals) {
//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("INSERT INTO nursery VALUES(?,?,?)");
//            preparedStatement.setString(1, animals.getName());
//            preparedStatement.setDate(2, Date.valueOf(animals.getDateBirth()));
//            preparedStatement.setString(3, animals.getSkills());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
