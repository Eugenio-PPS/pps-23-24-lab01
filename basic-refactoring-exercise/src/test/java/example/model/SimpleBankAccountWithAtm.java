package example.model;

public class SimpleBankAccountWithAtm implements BankAccount {
    private final AccountHolder accountHolder;

    public SimpleBankAccountWithAtm(final AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }
    @Override
    public AccountHolder getHolder() {
        return this.accountHolder;
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void deposit(int userID, double amount) {

    }

    @Override
    public void withdraw(int userID, double amount) {

    }
}
