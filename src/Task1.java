import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        printBiggestNumbers();
    }

    public static void printBiggestNumbers() {
        Scanner scanner = new Scanner(System.in);
        int index = 10;
        System.out.println("Please enter first number:");
        int n1 = scanner.nextInt();
        System.out.println("Please enter second number:");
        int n2 = scanner.nextInt();
        System.out.println("Please enter third number:");
        int n3 = scanner.nextInt();
        System.out.println("Please enter fourth number:");
        int n4 = scanner.nextInt();
        System.out.println("Please enter fifth number:");
        int n5 = scanner.nextInt();
        System.out.println("Please enter sixth number:");
        int n6 = scanner.nextInt();
        System.out.println("Please enter seventh number:");
        int n7 = scanner.nextInt();
        System.out.println("Please enter eighth number:");
        int n8 = scanner.nextInt();
        System.out.println("Please enter nineth number:");
        int n9 = scanner.nextInt();
        System.out.println("Please enter tenth number:");
        int n10 = scanner.nextInt();
        double average = ((n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10) / index);
        if (n1 == n2 && n2 == n3 && n3 == n4 && n4 == n5 && n5 == n6 && n6 == n7 && n7 == n8 && n8 == n9 && n9 == n10) {
            System.out.println("There is no numbers that bigger than average.");
            return;
        }
        System.out.println("The numbers that bigger than average are: ");
        if (n1 > average) {
            System.out.println(n1);
        }
        if (n2 > average) {
            System.out.println(n2);
        }
        if (n3 > average) {
            System.out.println(n3);
        }
        if (n4 > average) {
            System.out.println(n4);
        }
        if (n5 > average) {
            System.out.println(n5);
        }
        if (n6 > average) {
            System.out.println(n6);
        }
        if (n7 > average) {
            System.out.println(n7);
        }
        if (n8 > average) {
            System.out.println(n8);
        }
        if (n9 > average) {
            System.out.println(n9);
        }
        if (n10 > average) {
            System.out.println(n10);
        }
    }
}//End of Task1 class.