```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class DropdownTests {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass: Setting up ChromeDriver for DropdownTests");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod: Navigating to form page");
        driver.get("http://localhost:8080/index.html#!/form");
        try {
            Thread.sleep(2000); // Wait for AngularJS
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1, groups = {"dropdown", "functional"}, dependsOnMethods = {"testSelectByValue"})
    public void testSelectByText() {
        System.out.println("Test: Selecting role by visible text");
        WebElement dropdownElement = driver.findElement(By.id("role"));
        Select dropdown = new Select(dropdownElement);
        String textToSelect = "Designer";
        dropdown.selectByVisibleText(textToSelect);
        String actualText = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualText, textToSelect, "Selected option text does not match");
    }

    @Test(priority = 2, groups = {"dropdown", "functional"}, invocationCount = 2)
    public void testSelectByValue() {
        System.out.println("Test: Selecting role by value");
        WebElement dropdownElement = driver.findElement(By.id("role"));
        Select dropdown = new Select(dropdownElement);
        String valueToSelect = "Developer";
        dropdown.selectByValue(valueToSelect);
        String actualValue = dropdown.getFirstSelectedOption().getAttribute("value");
        Assert.assertEquals(actualValue, valueToSelect, "Selected option value does not match");
    }

    @Test(priority = 3, groups = {"dropdown", "functional"}, dataProvider = "roleData")
    public void testSelectByDataProvider(String roleValue, String expectedText) {
        System.out.println("Test: Selecting role with DataProvider (value: " + roleValue + ")");
        WebElement dropdownElement = driver.findElement(By.id("role"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(roleValue);
        String actualText = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualText, expectedText, "Selected option text does not match");
    }

    @DataProvider(name = "roleData")
    public Object[][] roleData() {
        return new Object[][] {
            {"Developer", "Developer"},
            {"Designer", "Designer"},
            {"Manager", "Manager"}
        };
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod: Cleaning up test state");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass: Closing browser");
        if (driver != null) {
            driver.quit();
        }
    }
}
```