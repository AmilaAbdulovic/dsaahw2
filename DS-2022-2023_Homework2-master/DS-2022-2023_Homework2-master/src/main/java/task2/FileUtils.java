package task2;

import task1.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {

    public static RedBlackTree<Integer, Student> readFile(String filePath) throws FileNotFoundException {
        RedBlackTree<Integer, Student> tree = new RedBlackTree<>();

        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(";");
            int id = Integer.parseInt(data[0].trim());
            String fullName = data[1];
            Date dateOfBirth = parseDateOfBirth(data[2]);
            String universityName = data[3];
            String departmentCode = data[4];
            String departmentName = data[5];
            int yearOfEnrollment = Integer.parseInt(data[6]);

            Student student = new Student(id, fullName, dateOfBirth, universityName, departmentCode, departmentName, yearOfEnrollment);
            tree.put(id, student);
        }

        scanner.close();
        return tree;
    }

    private static Date parseDateOfBirth(String dateOfBirthStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return dateFormat.parse(dateOfBirthStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}