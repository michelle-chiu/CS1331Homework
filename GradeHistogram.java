import java.util.Scanner;
import java.io.File;

public class GradeHistogram {

    public static void main(String[] args) throws Exception {
        // READING CSV FILE AND GRABBING THE NUMBER FROM THE LINES
        String fileName = args[0];
        File file = new File(fileName);
        Scanner fileReader = new Scanner(file);
        int[] possibleVals = new int[101];
        while (fileReader.hasNextLine()) {
            String value = fileReader.nextLine().split(",")[1].trim();
            int gradeVal = Integer.parseInt(value);
            for (int indSort = 0; indSort <= 100; indSort++) {
                if (gradeVal == indSort) {
                    possibleVals[indSort] = possibleVals[indSort] + 1;
                }
            }
        }
        fileReader.close();

        // OBTAINING THE BUCKET INCREMENT SIZE FROM THE USER
        System.out.println("Grades loaded!");
        Scanner userInput = new Scanner(System.in);
        int bucketIncrement;
        if (args.length < 2) {
            System.out.println("What bucket size would you like? ");
            bucketIncrement = Integer.parseInt(userInput.nextLine());
        } else {
            bucketIncrement = Integer.parseInt(args[1]);
        }

        // SORTING THE NUMBERS INTO RESPECTIVE BUCKETS
        double numBuckets = (double) (101 / bucketIncrement);
        int numberBuckets = (int) Math.floor(numBuckets);
        int firstRange = 100;
        int secondRange = firstRange - (bucketIncrement - 1);
        int lastRange = 0;
        for (int i = firstRange; i >= 0; i = i - (bucketIncrement - 1)) {
            System.out.printf("%-3d - %-2d | ", firstRange, secondRange);
            for (int j = firstRange; j >= secondRange; j--) {
                if (possibleVals[j] > 0) {
                    for (int k = possibleVals[j]; k > 0; k--) {
                        System.out.print("[]");
                    }
                }
            }
            System.out.print("\n");
            firstRange = firstRange - bucketIncrement;
            secondRange = secondRange - bucketIncrement;
            lastRange = firstRange;
            if (firstRange <= 0) {
                firstRange = 0;
                secondRange = 0;
                System.out.printf("%-3d - %-2d | ", firstRange, secondRange);
                if (possibleVals[0] > 0) {
                    for (int l = possibleVals[0]; l > 0; l--) {
                        System.out.print("[]");
                    }
                    System.out.print("\n");
                }
                break;
            }
            if (secondRange <= 0) {
                firstRange = lastRange;
                secondRange = 0;
                System.out.printf("%-3d - %-2d | ", firstRange, secondRange);
                if (possibleVals[0] > 0) {
                    for (int m = possibleVals[0]; m > 0; m--) {
                        System.out.print("[]");
                    }
                    System.out.print("\n");
                }
                break;
            }
        }
    }
}