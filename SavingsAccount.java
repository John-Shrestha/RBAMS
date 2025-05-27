public class SavingsAccount extends Bank_Account {
    private static final double INTEREST_RATE = 0.05; // 5% annual interest

    public SavingsAccount(String accountHolderName, String accountNumber, double balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal successful. New balance: " + getBalance());
        } else {
            throw new InsufficientBalanceException("Withdrawal failed: Insufficient balance!");
        }
    }

    public void addInterest() {
        double interest = getBalance() * INTEREST_RATE / 12; // Monthly interest
        setBalance(getBalance() + interest);
        System.out.println("Interest added. New balance: " + getBalance());
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("=== Savings Account ===");
        super.displayAccountDetails();
    }
}