package task1;
public class BinarySearch {
    public static int search(Student[] students, int key) {
        int left = 0;
        int right = students.length - 1;
        int numSteps = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            numSteps++;

            if (students[mid].getId() == key) {
                System.out.println("Student found:");
                System.out.println(students[mid]);
                return numSteps;
            }

            if (students[mid].getId() < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Student not found.");
        return numSteps;
    }
}
