package example.model;

public class SimpleBankAccountWithAtm implements BankAccount {
    private final BankAccount account;

    public SimpleBankAccountWithAtm(final AccountHolder accountHolder, final double balance) {
        this.account = new SimpleBankAccount(accountHolder, balance);
    }
    @Override
    public AccountHolder getHolder() {
        return this.account.getHolder();
    }

    @Override
    public double getBalance() {
        return this.account.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        this.account.deposit(userID, amount);
    }

    @Override
    public void withdraw(int userID, double amount) {

    }
}
