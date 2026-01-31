package com.yatish.ems.util;

import com.yatish.ems.models.Employee;
import com.yatish.ems.repository.EmployeeRepository;
import com.yatish.ems.services.EmployeeServiceImpl;

import java.io.*;

public class FileUtil {

    private static final String FILE = "employees.ser";

    public static void load(EmployeeServiceImpl service) {

        File file = new File(FILE);

        // ✅ Case 1: No file → start with empty map
        if (!file.exists()) {
            System.out.println("No previous data found. Starting fresh.");
            return;
        }

        // ✅ Case 2: File exists → load map
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE))) {

            EmployeeRepository repo =
                    (EmployeeRepository) ois.readObject();

            // Sync IDs from map keys (handles migration from old format)
            repo.getMap().forEach((k, v) -> {
                if (v.getId() == 0) v.setId(k);
            });

            service.setRepo(repo);

            int maxId = repo.findAll().stream()
                    .mapToInt(Employee::getId)
                    .max()
                    .orElse(0);
            Employee.setCount(maxId + 1);

            System.out.println("Previous data loaded successfully.");

        } catch (Exception e) {
            System.out.println("Data corrupted. Starting with empty map.");
        }
    }

    public static void save(EmployeeServiceImpl service) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE))) {

            oos.writeObject(service.getRepo());
            System.out.println("Data saved.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
