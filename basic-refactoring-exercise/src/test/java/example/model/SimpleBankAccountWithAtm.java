package example.model;

public class SimpleBankAccountWithAtm implements BankAccount {
    private final AccountHolder accountHolder;
    private final double balance;

    public SimpleBankAccountWithAtm(final AccountHolder accountHolder, final double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    @Override
    public AccountHolder getHolder() {
        return this.accountHolder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {

    }

    @Override
    public void withdraw(int userID, double amount) {

    }
}
