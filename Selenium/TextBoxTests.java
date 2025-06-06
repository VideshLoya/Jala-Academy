```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TextBoxTests {
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite: Setting up ChromeDriver path");
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest: Initializing test environment");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass: Setting up ChromeOptions");
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

    @Test(priority = 1, groups = {"textbox", "functional"})
    public void testTypeIntoTextBox() {
        System.out.println("Test: Typing into username text box");
        WebElement usernameField = driver.findElement(By.id("username"));
        String inputText = "JohnDoe123";
        usernameField.sendKeys(inputText);
        String actualValue = usernameField.getAttribute("value");
        Assert.assertEquals(actualValue, inputText, "Text box value does not match input");
    }

    @Test(priority = 2, groups = {"textbox", "functional"})
    public void testClearTextBox() {
        System.out.println("Test: Clearing username text box");
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("TestText");
        usernameField.clear();
        String actualValue = usernameField.getAttribute("value");
        Assert.assertTrue(actualValue.isEmpty(), "Text box is not cleared");
    }

    @Test(priority = 3, groups = {"textbox", "validation"}, enabled = false)
    public void testTextBoxDisabled() {
        System.out.println("Test: Checking if username text box is disabled");
        WebElement disableCheckbox = driver.findElement(By.cssSelector("input[type='checkbox'][ng-model='isDisabled']"));
        disableCheckbox.click();
        WebElement usernameField = driver.findElement(By.id("username"));
        Assert.assertFalse(usernameField.isEnabled(), "Text box should be disabled");
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

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest: Finalizing test environment");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite: Cleaning up suite resources");
    }
}
```