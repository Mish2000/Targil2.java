import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        printMobileNumber();
    }

    public static String printMobileNumber() {
        String format0 = ("");
        String format1 = ("0500000000");
        String format2 = ("050-0000000");
        String format3 = ("972500000000");
        String phoneNum;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your mobile number:");
        phoneNum = scanner.nextLine();

        if (phoneNum.charAt(0) != '0' && phoneNum.charAt(0) != '9') {
            return format0;
        }
        if (phoneNum.length() == format2.length()) {
            return ("Your mobile number is: " + phoneNum);
        }
        if (phoneNum.length() == format1.length()) {

            String result1 = phoneNum.substring(0, 3);
            String result2 = phoneNum.substring(3, 10);
            return ("Your mobile number is: " + result1 + '-' + result2);
        }
        if (phoneNum.length() == format3.length()) {
            String result3 = phoneNum.substring(5, 12);
            String result4 = phoneNum.substring(3, 5);
            return ("Your mobile number is: " + '0' + result4 + '-' + result3);
        }
        return format0;
    }
}//End of Task2 class.
