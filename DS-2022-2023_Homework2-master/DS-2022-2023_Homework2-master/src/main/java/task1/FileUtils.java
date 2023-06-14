package task1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public static Student[] readFile(String filePath) throws FileNotFoundException{
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Amila\\Downloads\\Global_University_Students.csv"))) {
            String line;
            int lineNumber = 0;
            Student[] students = new Student[1000000]; // Assuming the file contains 1 million students

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 7) {
                    throw new  FileNotFoundException("Invalid CSV format at line " + (lineNumber + 1));
                }

                int id = Integer.parseInt(parts[0]);
                String fullName = parts[1];
                Date dateOfBirth = parseDate(parts[2]);
                String universityName = parts[3];
                String departmentCode = parts[4];
                String departmentName = parts[5];
                int yearOfEnrollment = Integer.parseInt(parts[6]);

                Student student = new Student(id, fullName, dateOfBirth, universityName, departmentCode, departmentName, yearOfEnrollment);
                students[lineNumber] = student;
                lineNumber++;
            }

            return students;
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + "C:\\Users\\Amila\\Downloads\\Global_University_Students.csv" , e);
        }
    }

    public static void writeToFile(Student[] students, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : students) {
                writer.write(student.getId() + ";" + student.getFullName() + ";" +
                        formatDate(student.getDateOfBirth()) + ";" + student.getUniversityName() + ";" +
                        student.getDepartmentCode() + ";" + student.getDepartmentName() + ";" +
                        student.getYearOfEnrollment());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }

    private static Date parseDate(String dateString) {
        try {
            return DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dateString, e);
        }
    }

    private static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }
}