import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        driver();
    }
    public static void driver()
    {
        char[] array = new char[9];
        int indexP;
        boolean nextFirstGamer = true;
        boolean wInner = false;
        String gameQue;
        char gamerSymbol;
        while (!wInner) {
            if (nextFirstGamer) {
                gamerSymbol = 'X';
                gameQue = "First gamer";
            } else {
                gamerSymbol = 'O';
                gameQue = "SecondGamer";
            }
            System.out.println(gameQue + ", Your symbol is " + gamerSymbol);
            while (true) {
                indexP = getPositionFromUser(array);
                if (indexP >= 0) break;
            }
            wInner = placeSymbolOnBoard(array, indexP, gamerSymbol);
            nextFirstGamer = !nextFirstGamer;
        }
    }

    public static void printBoard(char[] array) {
        System.out.print(array[0] + "\t" + array[1] + "\t" + array[2]);
        System.out.println();
        System.out.print(array[3] + "\t" + array[4] + "\t" + array[5]);
        System.out.println();
        System.out.println(array[6] + "\t" + array[7] + "\t" + array[8]);
    }

    public static boolean isAvailable(char[] array, int index) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'X' || array[i] == 'O') {
                return false;
            }
        }
        return true;
    }

    public static int getPositionFromUser(char[] array) {
        int number;
        printBoard(array);
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please enter a number between 1-9 to choose your position:");
            number = scanner.nextInt();
            if (number < 1 || number > 9) {
                System.out.println("Sorry,but chosen number does not fit the requirements.");
            }

        } while (number < 1 || number > 9);


        if (array[number - 1] == 'X' || array[number - 1] == 'O') {

            System.out.println("Sorry,but current position is already used.");

            return (-1);
        }
        return (number - 1);
    }


    public static char checkWinner(char[] array) {
        if ((array[0] == 'X' && array[1] == 'X' && array[2] == 'X')
                || (array[3] == 'X' && array[4] == 'X' && array[5] == 'X')
                || (array[6] == 'X' && array[7] == 'X' && array[8] == 'X') ||
                (array[0] == 'X' && array[3] == 'X' && array[6] == 'X') ||
                (array[1] == 'X' && array[4] == 'X' && array[7] == 'X') ||
                (array[2] == 'X' && array[5] == 'X' && array[8] == 'X') ||
                (array[0] == 'X' && array[4] == 'X' && array[8] == 'X') ||
                (array[2] == 'X' && array[4] == 'X' && array[6] == 'X')) {
            System.out.println("***  X is the winner!   ***");
            return 'X';
        }
        if ((array[0] == 'O' && array[1] == 'O' && array[2] == 'O')
                || (array[3] == 'O' && array[4] == 'O' && array[5] == 'O')
                || (array[6] == 'O' && array[7] == 'O' && array[8] == 'O') ||
                (array[0] == 'O' && array[3] == 'O' && array[6] == 'O') ||
                (array[1] == 'O' && array[4] == 'O' && array[7] == 'O') ||
                (array[2] == 'O' && array[5] == 'O' && array[8] == 'O') ||
                (array[0] == 'O' && array[4] == 'O' && array[8] == 'O') ||
                (array[2] == 'O' && array[4] == 'O' && array[6] == 'O')) {
            System.out.println("***  O is the winner!   ***");
            return 'O';
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 'O' && array[i] != 'X')
                return '-';
        }
        System.out.println("***  Tie.   ***");
        return '*';
    }

    public static boolean placeSymbolOnBoard(char[] array, int index, char symbol) {
        array[index] = symbol;
        printBoard(array);
        char result = checkWinner(array);
        if (result == 'X' || result == 'O' || result == '*') {
            return true;
        }
        return false;
    }
}//End of Task5 class.


