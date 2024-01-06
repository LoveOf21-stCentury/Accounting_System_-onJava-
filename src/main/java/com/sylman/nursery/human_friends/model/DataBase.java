package com.sylman.nursery.human_friends.model;

import com.sylman.nursery.human_friends.model.animals.Animals;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    //    For educational purposes, we will leave these data as CONSTANTS here.
//    In a real project, this data would be stored in a separate external file
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/nurserydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    private static Connection connection;
    Service service = new Service();


    static {
        try {
            Class.forName("org.mysql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Animals> index() {
        List<Animals> animals = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM nursery";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Animals animal = service.addNewAnimal();
                animal.setId(resultSet.getLong("id"));
                animal.setName(resultSet.getString("name"));
                animal.setDateBirth(resultSet.getDate("age").toLocalDate());
                animal.setSkills(resultSet.getString("skills"));

                animals.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animals;
    }

    public Animals show(int id) {
        Animals animals = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM nursery WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            animals = service.addNewAnimal();

            animals.setId(resultSet.getInt("id"));
            animals.setName(resultSet.getString("name"));
            animals.setDateBirth(resultSet.getDate("age").toLocalDate());
            animals.setSkills(resultSet.getString("skills"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animals;
    }

    public void save(Animals animals) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO nursery VALUES(?,?,?)");
            preparedStatement.setString(1, animals.getName());
            preparedStatement.setDate(2, Date.valueOf(animals.getDateBirth()));
            preparedStatement.setString(3, animals.getSkills());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
