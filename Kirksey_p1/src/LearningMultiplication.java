import java.util.Scanner;
import java.security.SecureRandom;
import java.lang.Math;

public class LearningMultiplication {

    public static double questionType(int a, int b, int type, SecureRandom random, int difficulty) {
        if(type == 5) {
            type = random.nextInt(4) + 1;
        }
        if(type == 4 && b == 0) {
            while(b == 0) {
                b = random.nextInt(difficulty);
            }
        }
        switch(type) {
            case 1:
                System.out.print("How much is " + a + " plus " + b + "? ");
                return (double)a + b;
            case 2:
                System.out.print("How much is " + a + " times " + b + "? ");
                return (double)a * b;
            case 3:
                System.out.print("How much is " + a + " minus " + b + "? ");
                return (double)a - b;
            case 4:
                System.out.print("How much is " + a + " divided by " + b + "? ");
                return (double)a / b;
        }
        return 0;
    }

    public static int difficultyBound(int level) {
        switch(level) {
            case 1:
                return 10;
            case 2:
                return 100;
            case 3:
                return 1000;
            case 4:
                return 10000;
        }
        return 0;
    }

    public static double question(SecureRandom random, int difficulty, int problemType) {
        int a, b;
        double correct;

        a = random.nextInt(difficulty);
        b = random.nextInt(difficulty);
        correct = questionType(a, b, problemType, random, difficulty);
        return correct;
    }

    public static void correctPrompts(SecureRandom random) {
        int select = random.nextInt(4) + 1;
        switch (select) {
            case 1:
                System.out.println("Very good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;
        }
    }

    public static void incorrectPrompts(SecureRandom random) {
        int select = random.nextInt(4) + 1;
        switch (select) {
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don’t give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;
        }
    }

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        Scanner scnr = new Scanner(System.in);
        int i, rightAnswers, difficultyLevel, problemType, quit = 1;
        double correct, result;

        while(quit == 1) {
            for(i = 0; i < 50; i++)
            System.out.println();

            System.out.print("Please enter the difficulty level that you would like to try(1 - 4): ");
            difficultyLevel = scnr.nextInt();
            System.out.print("Please enter the type of problems you would like to try (1 for addition only, 2 for multiplication only, 3 for subtraction only, 4 for division only, and 5 for a mix of all problems: ");
            problemType = scnr.nextInt();
            rightAnswers = 0;
            for (i = 0; i < 10; i++) {
                correct = question(random, difficultyBound(difficultyLevel), problemType);
                result = scnr.nextDouble();
                if (Math.abs(correct - result) < 0.1) {
                    correctPrompts(random);
                    rightAnswers += 10;
                }
                else {
                    incorrectPrompts(random);
                }
                System.out.println();
            }
            System.out.println("The number of correct answers entered: " + (rightAnswers / 10));
            System.out.println("The number of incorrect answers entered: " + ((100 - rightAnswers) / 10));
            if (rightAnswers < 75) {
                System.out.println("Please ask your teacher for extra help.\n");
            } else {
                System.out.println("Congratulations, you are ready to go to the next level!\n");
            }
            System.out.print("Would you like to begin a new session? Enter 1 for yes or 0 for no: ");
            quit = scnr.nextInt();
        }
    }
}