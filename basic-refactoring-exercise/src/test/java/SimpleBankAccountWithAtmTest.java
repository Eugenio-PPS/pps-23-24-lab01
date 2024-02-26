import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest {
    private static AccountHolder ACCOUNT_HOLDER = new AccountHolder("John", "Doe", 1);
    private SimpleBankAccountWithAtm bankAccount;
    @BeforeEach
    void initialise() {
        this.bankAccount = new SimpleBankAccountWithAtm(ACCOUNT_HOLDER);
    }

    @Test
    void hasHolder() {
        assertEquals(ACCOUNT_HOLDER, this.bankAccount.getHolder());
    }

    void
}
