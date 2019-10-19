public class Application {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();
        int i;
        saver1.SetsavingsBalance(2000.00);
        saver2.SetsavingsBalance(3000.00);
        SavingsAccount.modifyInterestRate(4);
        for (i = 1; i < 13; i++) {
            System.out.printf("Saver 1's balance for month %d is: %.2f, Saver 2's balance: %.2f\n", i, saver1.calculateMonthlyInterest(), saver2.calculateMonthlyInterest());
        }
        System.out.println();
        SavingsAccount.modifyInterestRate(5);
        System.out.printf("Saver 1's balance for the next month after changing the interest rate to 5 is: %.2f, Saver 2's balance is: %.2f", saver1.calculateMonthlyInterest(), saver2.calculateMonthlyInterest());
    }
}
