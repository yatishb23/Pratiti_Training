package com.yatish.training.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.yatish.training.models.EmployeeEntity;
import com.yatish.training.repository.EmployeeRepository;
import com.yatish.training.services.EmployeeServiceImpl;

public class FileUtil {

    private static final String FILE = "employees.ser";

    public static void load(EmployeeServiceImpl service) {  
        File f = new File(FILE);
        if (!f.exists()) {
            System.out.println("No previous data found.");
            return;
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE))) {

            EmployeeRepository repo = (EmployeeRepository) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save(EmployeeServiceImpl service) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE))) {

            // oos.writeObject(service.getRepo());
            System.out.println("Data saved.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
