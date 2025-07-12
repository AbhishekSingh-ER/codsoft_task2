import java.util.*;

public class GradeCalculator {
    public static void main(String[] args) {
        System.out.println("***** Student Grade Calculator *****");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many subjects in your course: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] subName = new String[n];
        float[] marks = new float[n];

        System.out.println("\nEnter all " + n + " subject names:");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name for subject " + (i + 1) + ": ");
            subName[i] = sc.nextLine();
        }

        float sum = 0;
        boolean pass = true;

        System.out.println("\nEnter marks for each subject (0-100):");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter marks for " + subName[i] + ": ");
                try {
                    float inputMarks = sc.nextFloat();
                    if (inputMarks >= 0 && inputMarks <= 100) {
                        marks[i] = inputMarks;
                        if (inputMarks < 40) {
                            pass = false; // Fail in any subject means fail overall
                        }
                        sum += inputMarks;
                        break; // valid input, exit loop
                    } else {
                        System.out.println("Invalid input! Marks must be between 0 and 100.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.nextLine(); // Clear invalid input
                }
            }
        }

        float average = sum / n;

        String grade;
        if (pass) {
            if (average >= 85) {
                grade = "A+";
            } else if (average >= 75) {
                grade = "A";
            } else if (average >= 65) {
                grade = "B+";
            } else if (average >= 55) {
                grade = "B";
            } else if (average >= 50) {
                grade = "C";
            } else if (average >= 40) {
                grade = "D";
            } else {
                grade = "F";
            }
        } else {
            grade = "F"; // Fail if any subject mark < 40
        }

        System.out.println("\n********** RESULT **********");
        System.out.printf("%-20s %10s\n", "Subject", "Marks");
        System.out.println("------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-20s %10.2f\n", subName[i], marks[i]);
        }
        System.out.println("------------------------------");
        System.out.printf("%-20s %10.2f\n", "Total Marks:", sum);
        System.out.printf("%-20s %10.2f\n", "Average Percentage:", average);
        System.out.printf("%-20s %10s\n", "Grade:", grade);

        sc.close();
    }
}
