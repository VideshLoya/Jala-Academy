package base;
import java.time.Duration;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    public WebDriver driver;
    public Properties config;

    @BeforeSuite
    public void setUp() throws IOException {
        config = new Properties();
        FileInputStream fis = new FileInputStream("src/config/config.properties");
        config.load(fis);
        System.setProperty("webdriver.chrome.driver", config.getProperty("chromeDriverPath"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(config.getProperty("baseURL"));
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}