package task1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StudentSearchV1 {

    public static void main (String[]args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Student[] students = FileUtils.readFile("C:\\Users\\Amila\\Downloads\\Global_University_Students.csv");
        System.out.println("Loading the students...");
        System.out.println("Sorting the student array...");
        MergeSort.sort(students);
        System.out.println("Sorting completed.");
        String sortedFilePath ="C:\\Users\\Amila\\Downloads\\Global_University_Students.csv";
        FileUtils.writeToFile(students, sortedFilePath);
        System.out.println("Saving the sorted file: " + sortedFilePath);
        System.out.println("System is ready.");


        int studentId;
        do {
            System.out.print("Enter the ID of the student you want to retrieve (or -1 to exit): ");
            studentId = scanner.nextInt();

            if (studentId == -1) {
                System.out.println("Thank you for using the student search system.");
                break;
            }
            int numSteps = BinarySearch.search(students, studentId);
            if (numSteps != -1) {
                System.out.println("\nThe student was retrieved in " + numSteps + " steps.");
            } else {
                System.out.println("The student with the requested ID does not exists.");
                System.out.println("\nThe search was completed in "+ numSteps + " steps.");
            }
        } while (true);


        scanner.close();
    }
}