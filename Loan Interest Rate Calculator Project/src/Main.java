import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Principle: ");
        int principle = scanner.nextInt();
        System.out.println("Annual Interest Rate: ");
        float annualintrest = scanner.nextFloat();
        float monthlyintrest = annualintrest / PERCENT / MONTH_IN_YEAR;

        System.out.println("Period Year: ");
        byte years = scanner.nextByte();
        int numberOfPeyments = years * MONTH_IN_YEAR;

        double montgage = principle * (monthlyintrest * Math.pow(1 + monthlyintrest, numberOfPeyments)) /
                (Math.pow(1 + monthlyintrest, numberOfPeyments) - 1);

        String montgageFormatted = NumberFormat.getCurrencyInstance().format(montgage);
        System.out.println("Montgage: " + montgageFormatted);

    }
}