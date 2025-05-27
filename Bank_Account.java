public abstract class Bank_Account {
    //private instance variables to store account details.
    //These are private to encapsulate the data, meaning they can only be accessed directly within the class.
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    public Bank_Account(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Protected setter for balance to be used by child classes
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Other getters
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}