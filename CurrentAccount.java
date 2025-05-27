public class CurrentAccount extends Bank_Account {
    private static final double OVERDRAFT_LIMIT = 10000.0; // 10,000 NPR overdraft limit

    public CurrentAccount(String accountHolderName, String accountNumber, double balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= getBalance() + OVERDRAFT_LIMIT) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal successful. New balance: " + getBalance());
        } else {
            throw new InsufficientBalanceException("Withdrawal failed: Exceeds overdraft limit!");
        }
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("=== Current Account ===");
        super.displayAccountDetails();
        System.out.println("Overdraft Limit: " + OVERDRAFT_LIMIT);
    }
}