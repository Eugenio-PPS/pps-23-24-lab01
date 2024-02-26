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
}
