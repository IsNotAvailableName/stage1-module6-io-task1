package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {

        String name = null;
        Integer age = null;
        String email = null;
        Long phone = null;

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            name = bufferedReader
                    .readLine()
                    .replaceFirst("Name: ", "");
            age = Integer.parseInt(bufferedReader
                    .readLine()
                    .replaceFirst("Age: ", ""));
            email = bufferedReader.readLine().replaceFirst("Email: ", "");
            phone = Long.parseLong(bufferedReader
                    .readLine()
                    .replaceFirst("Phone: ", ""));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new Profile(name, age, email, phone);
    }
}
