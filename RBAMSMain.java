import java.util.Scanner;

public class RBAMSMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Rural Bank of Nepal");
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        Customer customer = new Customer(customerName);

        // Create sample accounts for the customer
        SavingsAccount savingsAccount = new SavingsAccount(customerName, "SA001", 5000);
        CurrentAccount currentAccount = new CurrentAccount(customerName, "CA001", 10000);
        customer.addAccount(savingsAccount);
        customer.addAccount(currentAccount);

        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Add Interest");
            System.out.println("4. View Accounts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1: // Deposit
                        handleDeposit(customer, scanner);
                        break;
                    case 2: // Withdraw
                        handleWithdrawal(customer, scanner);
                        break;
                    case 3: // Add Interest
                        addInterestToSavings(customer);
                        break;
                    case 4: // View Accounts
                        customer.displayAllAccounts();
                        break;
                    case 5: // Exit
                        exit = true;
                        System.out.println("Thank you for using Rural Bank of Nepal!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private static void handleDeposit(Customer customer, Scanner scanner) {
        System.out.println("Select account (1: Savings, 2: Current): ");
        int accountType = scanner.nextInt();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        Bank_Account account = getSelectedAccount(customer, accountType);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Invalid account selection.");
        }
    }

    private static void handleWithdrawal(Customer customer, Scanner scanner) throws InsufficientBalanceException {
        System.out.println("Select account (1: Savings, 2: Current): ");
        int accountType = scanner.nextInt();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        Bank_Account account = getSelectedAccount(customer, accountType);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Invalid account selection.");
        }
    }

    private static void addInterestToSavings(Customer customer) {
        for (Bank_Account account : customer.getAccounts()) {
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).addInterest();
                return;
            }
        }
        System.out.println("No savings account found for this customer.");
    }

    private static Bank_Account getSelectedAccount(Customer customer, int accountType) {
        if (customer.getAccounts().size() < accountType || accountType < 1) {
            return null;
        }
        return customer.getAccounts().get(accountType - 1);
    }
}