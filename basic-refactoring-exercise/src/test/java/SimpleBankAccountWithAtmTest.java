import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest {
    private static AccountHolder ACCOUNT_HOLDER = new AccountHolder("John", "Doe", 1);
    private static double ACCOUNT_BALANCE = 0.0;
    private SimpleBankAccountWithAtm bankAccount;
    @BeforeEach
    void initialise() {
        this.bankAccount = new SimpleBankAccountWithAtm(ACCOUNT_HOLDER, ACCOUNT_BALANCE);
    }

    @Test
    void hasHolder() {
        assertEquals(ACCOUNT_HOLDER, this.bankAccount.getHolder());
    }

    @Test
    void balanceIsCorrectlyInitialised() {
        assertEquals(ACCOUNT_BALANCE, this.bankAccount.getBalance());
    }
    @Test
    void testDeposit() {
        bankAccount.deposit(ACCOUNT_HOLDER.getId(), 100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(ACCOUNT_HOLDER.getId(), 100);
        bankAccount.deposit(2, 50);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(ACCOUNT_HOLDER.getId(), 100);
        bankAccount.withdraw(ACCOUNT_HOLDER.getId(), 70);
        assertEquals(30, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(ACCOUNT_HOLDER.getId(), 100);
        bankAccount.withdraw(2, 70);
        assertEquals(100, bankAccount.getBalance());
    }

}
