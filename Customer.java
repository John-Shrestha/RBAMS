import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Bank_Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Bank_Account account) {
        accounts.add(account);
    }

    public List<Bank_Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

    public void displayAllAccounts() {
        System.out.println("Accounts for customer: " + name);
        for (Bank_Account account : accounts) {
            account.displayAccountDetails();
            System.out.println();
        }
    }
}