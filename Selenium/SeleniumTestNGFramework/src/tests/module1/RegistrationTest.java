package tests.module1;
import org.testng.annotations.*;
import base.BaseTest;
import actions.RegistrationActions;

public class RegistrationTest extends BaseTest {
    RegistrationActions reg;

    @BeforeClass
    public void init() {
        reg = new RegistrationActions(driver);
    }

    @Test(priority=1, groups={"sanity"})
    public void testValidRegistration() {
        reg.registerUser("validUser", "validPass");
    }

    @Test(priority=2, groups={"regression"})
    public void testInvalidPassword() {
        reg.registerUser("user", "123");
    }
}