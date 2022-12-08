import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
       driver();
    }
    public static void driver()
    {
        String equation;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a valid quadratic equation:");
        equation = scanner.nextLine();
        if (checkInput(equation)) {
            int a = retAVal(equation);
            int b = retBVal(equation);
            int c = retCVal(equation);
            printSolutions(a, b, c);
        }
    }

    public static boolean checkInput(String equation) {
        int f1 = equation.indexOf("x^2");
        int f2 = equation.indexOf("x");
        char tempChar;
        if ((f1 == f2) && (f1 >= 0)) {
            String equation1 = equation.substring(f1 + 3);
            f2 = equation1.indexOf("x");
            tempChar = equation1.charAt(0);
            if ((equation1.indexOf("x^2") < 0) && f2 > 0 && ((tempChar == '+') || (tempChar == '-'))) {
                equation1 = equation1.substring(f2 + 1);
                if (equation1.indexOf("x") < 0 && equation1.indexOf("=0") >= 0)
                    return true;
            }
        }

        System.out.println("Invalid input.");
        return false;
    }

    public static int retAVal(String equation) {
        char aParameter;
        int f1 = equation.indexOf("x^2");
        int aDigital = 1;
        int factor = 1;
        if (f1 != 0) {
            for (int i = f1 - 1; i >= 0; i--) {
                aParameter = equation.charAt(i);
                if (aParameter == '-')
                    aDigital = aDigital * (-1);
                else {
                    if (i == f1 - 1)
                        aDigital = 0;
                    aDigital = aDigital + factor * (aParameter - '0');
                    factor = factor * 10;
                }
            }
        }
        return aDigital;
    }

    public static int retBVal(String equation) {
        int f1 = 3 + equation.indexOf("x^2");
        String equationB = equation.substring(f1);

        char bParameter;
        f1 = equationB.indexOf("x");
        int bDigital = 1;
        int factor = 1;
        if (f1 != 0) {
            for (int i = f1 - 1; i >= 0; i--) {
                bParameter = equationB.charAt(i);
                if (bParameter == '-')
                    bDigital = bDigital * (-1);
                else if (bParameter == '+')
                    break;
                else {
                    if (i == f1 - 1)
                        bDigital = 0;
                    bDigital = bDigital + factor * (bParameter - '0');
                    factor = factor * 10;
                }
            }
        }
        return bDigital;
    }

    public static int retCVal(String equation) {
        int f1 = 3 + equation.indexOf("x^2");
        String equationC = equation.substring(f1);
        f1 = 1 + equationC.indexOf("x");
        equationC = equationC.substring(f1);
        char cParameter;
        f1 = equationC.indexOf("=");
        int cDigital = 0;
        int factor = 1;
        if (f1 != 0) {
            for (int i = f1 - 1; i >= 0; i--) {
                cParameter = equationC.charAt(i);
                if (cParameter == '-')
                    cDigital = cDigital * (-1);
                else if (cParameter == '+')
                    break;
                else {
                    if (i == f1 - 1)
                        cDigital = 0;
                    cDigital = cDigital + factor * (cParameter - '0');
                    factor = factor * 10;
                }
            }
        }
        return cDigital;

    }

    public static void printSolutions(int aParam, int bParam, int cParam) {
        double delta = bParam * bParam - 4 * aParam * cParam;
        if (delta > 0) {
            delta = Math.sqrt(delta);
            double x1 = (-bParam + delta) / (2 * aParam);
            double x2 = (-bParam - delta) / (2 * aParam);
            System.out.println("The solutions are: " + x1 + " , " + x2);
        } else if (delta == 0)
            System.out.println("The solution is:\t" + (-bParam) / (2 * aParam));
        else
            System.out.println("There is no solutions for this equation.");
    }
}//End of Task6 class.