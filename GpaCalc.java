import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class GpaCalc {

    public static void main(String[] args) throws Exception {
        String anotherSemester;
        Scanner userInput = new Scanner(System.in);
        do {
            processInput();
            System.out.print("Would you like to calculate for another");
            System.out.print(" semester? (y/n) ");
            anotherSemester = userInput.nextLine();
        } while (anotherSemester.equals("y"));

    }

    static void processInput() throws Exception {
        Scanner userInput = new Scanner(System.in);
        String calcSemester = "y";
        String calcCourse = "y";
        String courseTitle;
        int numCredits = 0;
        int numGrades = 0;
        String currentSemester;
        String fn;
        int sumGrades = 0;
        int sumCredits = 0;
        String anotherCourse;
        String anotherSemester;
        System.out.print("Enter the semester: ");
        currentSemester = userInput.nextLine();
        currentSemester = currentSemester.toLowerCase();
        fn = currentSemester + ".txt";
        fn = fn.replaceAll("\\s+", "");
        File semesterGrades = new File(fn);
        PrintWriter newF = new PrintWriter(semesterGrades);
        do {
            System.out.print("Enter the course title: ");
            courseTitle = userInput.nextLine();
            System.out.print("Enter the number of credits: ");
            numCredits = userInput.nextInt();
            sumCredits = numCredits + sumCredits;
            System.out.print("Enter the grade (A=4, B=3, etc.) ");
            userInput.nextLine();
            numGrades = userInput.nextInt();
            sumGrades = sumGrades + (numGrades * numCredits);
            newF.println(courseTitle + " - " + numCredits
                + " credits. Grade: " + numGrades);
            System.out.print("Would you like to enter another course? ");
            userInput.nextLine();
            anotherCourse = userInput.nextLine();
        } while (anotherCourse.equals("y"));
        double overallGPA = (double) sumGrades / sumCredits;
        System.out.printf("Overall GPA: %.2f \n", overallGPA);
        newF.printf("GPA: %.2f", overallGPA);
        newF.close();
    }
}