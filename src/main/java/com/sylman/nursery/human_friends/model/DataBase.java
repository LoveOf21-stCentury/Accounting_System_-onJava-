package com.sylman.nursery.human_friends.model;

import com.sylman.nursery.human_friends.model.animals.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//
//public class DataBase<T extends Animals> {
//    private final List<T> animals;
//
//    public DataBase() {
//        animals = new ArrayList<>();
//    }
//
//    private void load(String fileName, List<T> list) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] data = line.split(",");
//                if (data.length >= 3) {
//                    String className = data[0];
//                    String name = data[1];
//                    String skills = String.join(",", Arrays.copyOfRange(data, 2, data.length));
//
//                    T animal;
//                    switch (className) {
//                        case "Dog" -> animal = (T) new Dog(name, skills);
//                        case "Cat" -> animal = (T) new Cat(name, skills);
//                        case "Hamster" -> animal = (T) new Hamster(name, skills);
//                        case "Camel" -> animal = (T) new Camel(name, skills);
//                        case "Donkey" -> animal = (T) new Donkey(name, skills);
//                        case "Horse" -> animal = (T) new Horse(name, skills);
//                        default -> {
//                            System.out.println("Unknown class of animal: " + className);
//                            continue;
//                        }
//                    }
//                    list.add(animal);
//                } else {
//                    System.out.println("Invalid data in the file: " + line);
//                }
//            }
//            System.out.println("Database loaded successfully.");
//        } catch (IOException e) {
//            System.out.println("Error while reading the database: " + e.getMessage());
//        }
//    }
//
//    private void save(String fileName, List<T> list) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
//            for (T animal : list) {
//                String className = animal.getClass().getSimpleName();
//                String name = animal.getName();
//                String skills = animal.getSkills().replaceAll(",\\s+", ",");
//
//                String line = className + "," + name + "," + skills;
//                writer.write(line);
//                writer.newLine();
//            }
//            System.out.println("Data saved successfully.");
//        } catch (IOException e) {
//            System.out.println("Error while saving the data: " + e.getMessage());
//        }
//    }
//}
