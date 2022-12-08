import java.util.Random;
import java.util.Scanner;

public class Task7 {

    public static void main(String[] args) {
        driver();
    }

    public static void driver() {
        int mode[] = chooseDifficulty();
        int path = mode[0];
        if (path == 0)
            return;
        int number = createRandom();
        int status;
        if (mode[1] != 4)
            System.out.println("You have " + path + " tries. ");
        for (int i = 1; i <= path; i++) {
            int[] array = retArray(number);
            status = guessRandom(array);
            if (status >= 0) {
                if (status == 4) {
                    System.out.println("Congratulations! You guessed the code!");
                    return;
                }
            } else {
                path = path - 1;
                System.out.println("You lost two tries");
            }
            if (path - 1 >= i) {
                if (mode[1] != 4)
                    System.out.println("You have " + (path - i) + " tries left");
                System.out.println("Try again.");
            }
        }
        System.out.println("You've run out of tries");
        System.out.println("The valid code is: " + number);
        System.out.println("Game over.");
    }

    public static int createRandom() {
        int[] array = new int[4];
        int number;
        int tool;
        int tool1;
        int tool2;
        int tool3;
        do {
            Random random = new Random();
            number = random.nextInt(1000, 9999);
            int memory = number;
            tool = memory % 10;
            memory = memory / 10;
            tool1 = memory % 10;
            memory = memory / 10;
            tool2 = memory % 10;
            memory = memory / 10;
            tool3 = memory % 10;
            array[3] = tool;
            array[2] = tool1;
            array[1] = tool2;
            array[0] = tool3;
        } while (((tool == 0 || tool > 6) ||
                (tool1 == 0 || tool1 > 6) ||
                (tool2 == 0 || tool2 > 6) ||
                (tool3 == 0 || tool3 > 6) ||
                (tool == tool1 || tool == tool2 || tool == tool3 ||
                        tool1 == tool2 || tool1 == tool3 || tool2 == tool3)));
        return number;
    }

    public static int[] retArray(int number) {
        int[] array = new int[4];
        array[3] = number % 10;
        array[2] = (number / 10) % 10;
        array[1] = (number / 100) % 10;
        array[0] = (number / 1000) % 10;
        return array;
    }

    public static int guessRandom(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please try to guess the 4 digits:");
        int status = 0, secondaryStatus = 0;
        int errorCounter = 0;
        int[] numArray = new int[4];

        int inCode = scanner.nextInt();
        boolean validInput = true;
        if (inCode >= 1000 && inCode < 10000) {
            for (int i = 3; i >= 0; i--) {
                numArray[i] = inCode % 10;
                inCode = inCode / 10;
            }


            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 4; j++) {
                    if (numArray[i] == numArray[j]) {
                        validInput = false;
                        break;
                    }
                }
            }

            if (validInput) {
                for (int i = 0; i < 4; i++) {
                    if (numArray[i] < 1 | numArray[i] > 6) {
                        validInput = false;
                        break;
                    }
                }
            }

            if (validInput) {
                status = 0;
                for (int i = 0; i < 4; i++) {
                    if (array[i] == numArray[i])
                        status++;
                }

                System.out.println("You guessed " + status + " numbers right!");

                secondaryStatus = 0;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (array[i] == numArray[j] && i != j)
                            secondaryStatus++;
                    }
                }
                System.out.println("You have " + secondaryStatus + " secondary guesses.");
                return status;
            }
        }

        System.out.println("Invalid entered code!. Penalty!");
        return (-1);
    }

    public static int[] chooseDifficulty() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello!\n Please choose path difficulty:\n" +
                "1) Easy path: 20 attempts.\n" +
                "2) Medium path: 15 attempts.\n" +
                "3) Difficult path: 10 attempts.\n" +
                "4) Surprising path: between 5 and 25 attempts.\n" +
                "Type the section number to start(1-4):");

        int[] path = new int[2];
        path[1] = scanner.nextInt();

        switch (path[1]) {
            case 1:
                path[0] = 20;
                break;
            case 2:
                path[0] = 15;
                break;
            case 3:
                path[0] = 10;
                break;
            case 4:
                int guesses = random.nextInt(5, 25);
                path[0] = guesses;
                break;
            default:
                System.out.println("Invalid section number. Game over");
                path[0] = 0;
        }
        return path;
    }
}//End of Task7 class.