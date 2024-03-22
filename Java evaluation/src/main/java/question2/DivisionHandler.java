package question2;

import java.util.Scanner;

class DivisionException extends Exception {
    public DivisionException(String message) {
        super(message);
    }
}

public class DivisionHandler {
    public static double divide(double dividend, double divisor) throws DivisionException {
        try {
            if (divisor == 0) {
                throw new ArithmeticException("Division by zero");
            }
            double result = dividend / divisor;
            System.out.println("Division completed successfully with divisor " + divisor + " and dividend " + dividend);
            return result;
        } catch (ArithmeticException e) {
            System.err.println("An error occurred" + e.getMessage());
            throw new DivisionException("Please pass a valid divisor");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the dividend ");
        double dividend = scanner.nextDouble();
        System.out.print("Enter the divisor");
        double divisor = scanner.nextDouble();

        scanner.close();

        try {
            double result = divide(dividend, divisor);
            System.out.println("Result " + result);
        } catch (DivisionException e) {
            System.err.println(e.getMessage());
        }
    }
}
