import java.util.Scanner;
import java.text.NumberFormat;

class MortgageCalculator {
    private final double principal; // Loan amount
    private final double annualInterestRate; // Annual interest rate
    private final int years; // Loan term in years

    // Constructor
    public MortgageCalculator(double principal, double annualInterestRate, int years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    // Calculate monthly mortgage payment
    public double calculateMonthlyPayment() {
        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        int numberOfPayments = years * 12;

        return (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) /
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }
}

public class MortgageApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter loan amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter annual interest rate: ");
        double annualInterestRate = scanner.nextDouble();

        System.out.print("Enter loan term (years): ");
        int years = scanner.nextInt();

        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterestRate, years);
        double monthlyPayment = calculator.calculateMonthlyPayment();

        // Format the output as currency
        String formattedPayment = NumberFormat.getCurrencyInstance().format(monthlyPayment);
        System.out.println("Monthly Payment: " + formattedPayment);

        scanner.close();
    }
}
