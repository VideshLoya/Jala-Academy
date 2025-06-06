package utils;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name="userData")
    public Object[][] getUserData() {
        return new Object[][] {
            {"user1", "pass1"},
            {"user2", "pass2"},
            {"user3", "pass3"}
        };
    }
}