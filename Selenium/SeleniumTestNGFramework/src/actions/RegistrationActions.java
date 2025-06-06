package actions;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;

public class RegistrationActions {
    WebDriver driver;
    RegistrationPage rp;

    public RegistrationActions(WebDriver driver) {
        this.driver = driver;
        rp = new RegistrationPage(driver);
    }

    public void registerUser(String uname, String pwd) {
        rp.username.sendKeys(uname);
        rp.password.sendKeys(pwd);
        rp.registerButton.click();
    }
}