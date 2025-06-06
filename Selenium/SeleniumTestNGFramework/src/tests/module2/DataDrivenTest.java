package tests.module2;
import org.testng.annotations.Test;
import base.BaseTest;
import actions.RegistrationActions;
import utils.TestDataProvider;

public class DataDrivenTest extends BaseTest {
    @Test(dataProvider="userData", dataProviderClass=TestDataProvider.class)
    public void registerMultipleUsers(String uname, String pwd) {
        RegistrationActions ra = new RegistrationActions(driver);
        ra.registerUser(uname, pwd);
    }
}