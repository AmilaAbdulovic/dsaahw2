package task2;

import task1.Student;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentSearchV2 {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        RedBlackTree<Integer, Student> tree = FileUtils.readFile("C:\\Users\\Amila\\Downloads\\Global_University_Students.csv");
        System.out.println("Loading the students into the tree...\n");
        System.out.println("The system was built with " + tree.getRedLinksCount() + " red links\n");

        while (true) {
            System.out.print("\nEnter the student ID to search (or -1 to exit): ");
            int studentID = scanner.nextInt();

            if (studentID == -1) {
                System.out.println("Thank you for using the student search system.");
                break;
            }

            Student student = tree.get(studentID);

            if (student != null) {
                System.out.println(student);
                System.out.println("\n \n The student was retrieved in " + tree.getNumSteps() + " steps. ");
            } else {
                System.out.println("\nThe student with the requested ID does not exists.");
                System.out.println("The search was completed in " + tree.getNumSteps() + " steps.");
            }
        }

        scanner.close();
    }
}
