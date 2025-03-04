import java.util.Scanner;
import java.text.NumberFormat;

// Class to calculate mortgage payments
class MortgageCalculator {
    private final double principal; // Loan amount
    private final double annualInterestRate; // Annual interest rate
    private final int years; // Loan term in years

    // Constructor to initialize mortgage details
    public MortgageCalculator(double principal, double annualInterestRate, int years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    // Method to calculate monthly mortgage payment
    public double calculateMonthlyPayment() {
        double monthlyInterestRate = (annualInterestRate / 100) / 12; // Convert annual interest rate to monthly
        int numberOfPayments = years * 12; // Total number of monthly payments

        return (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) /
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }

    // Method to display remaining balance after each month
    public void displayRemainingBalance() {
        double monthlyPayment = calculateMonthlyPayment();
        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        double remainingBalance = principal;
        int numberOfPayments = years * 12;

        System.out.println("\nPayment Schedule:");
        for (int month = 1; month <= numberOfPayments; month++) {
            double interest = remainingBalance * monthlyInterestRate; // Interest portion of payment
            double principalPayment = monthlyPayment - interest; // Principal portion of payment
            remainingBalance -= principalPayment; // Reduce remaining balance

            if (remainingBalance < 0) remainingBalance = 0; // Ensure balance does not go negative

            System.out.println("Month " + month + ": " + NumberFormat.getCurrencyInstance().format(remainingBalance));
        }
    }
}

// Main application to interact with user
public class MortgageApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Default values
        double defaultPrincipal = 100000;
        double defaultAnnualInterestRate = 5.0;
        int defaultYears = 30;

        // Get loan details from user (or use default values)
        System.out.print("Enter loan amount (default: " + defaultPrincipal + "): ");
        String principalInput = scanner.nextLine();
        double principal = principalInput.isEmpty() ? defaultPrincipal : Double.parseDouble(principalInput);

        System.out.print("Enter annual interest rate (default: " + defaultAnnualInterestRate + "): ");
        String interestInput = scanner.nextLine();
        double annualInterestRate = interestInput.isEmpty() ? defaultAnnualInterestRate : Double.parseDouble(interestInput);

        System.out.print("Enter loan term in years (default: " + defaultYears + "): ");
        String yearsInput = scanner.nextLine();
        int years = yearsInput.isEmpty() ? defaultYears : Integer.parseInt(yearsInput);

        // Create MortgageCalculator instance and calculate payment
        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterestRate, years);
        double monthlyPayment = calculator.calculateMonthlyPayment();

        // Format and display monthly payment
        String formattedPayment = NumberFormat.getCurrencyInstance().format(monthlyPayment);
        System.out.println("Monthly Payment: " + formattedPayment);

        // Display payment schedule
        calculator.displayRemainingBalance();

        scanner.close();
    }
}
