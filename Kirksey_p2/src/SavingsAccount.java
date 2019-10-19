
public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public void SetsavingsBalance(double input) {
        savingsBalance = input;
    }

    public static void modifyInterestRate(double input) {
        annualInterestRate = input;
    }
    public double calculateMonthlyInterest() {
        savingsBalance += savingsBalance * annualInterestRate / 12;
        return savingsBalance;
    }
}

