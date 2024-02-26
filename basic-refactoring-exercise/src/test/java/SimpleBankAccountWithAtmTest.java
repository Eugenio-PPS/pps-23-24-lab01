import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;

public class SimpleBankAccountWithAtmTest {
    private SimpleBankAccountWithAtm bankAccount;
    @BeforeEach
    void initialiseBankAccount() {
        this.bankAccount = new SimpleBankAccountWithAtm();
    }
}
