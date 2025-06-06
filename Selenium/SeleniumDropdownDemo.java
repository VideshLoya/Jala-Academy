```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumDropdownDemo {
    public static void main(String[] args) {
        // Set path to ChromeDriver executable (update with your path)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // Handle CORS issues
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to the AngularJS form page
            driver.get("http://localhost:8080/index.html#!/form");

            // Wait for AngularJS to load (simple sleep for demo; use WebDriverWait in production)
            Thread.sleep(2000);

            // Locate the role dropdown
            WebElement dropdownElement = driver.findElement(By.id("role"));
            Select dropdown = new Select(dropdownElement);

            // 1. Print all options available in the dropdown
            List<WebElement> allOptions = dropdown.getOptions();
            System.out.println("All options in the dropdown:");
            for (WebElement option : allOptions) {
                System.out.println("- " + option.getText() + " (value: " + option.getAttribute("value") + ")");
            }

            // 2. Print the first selected option
            WebElement firstSelectedOption = dropdown.getFirstSelectedOption();
            System.out.println("First selected option: " + firstSelectedOption.getText() + 
                               " (value: " + firstSelectedOption.getAttribute("value") + ")");

            // 3. Select an option by value
            String valueToSelect = "Developer";
            dropdown.selectByValue(valueToSelect);
            System.out.println("Selected option by value: " + valueToSelect);
            System.out.println("Current selected option: " + dropdown.getFirstSelectedOption().getText());

            // 4. Select an option by visible text
            String textToSelect = "Designer";
            dropdown.selectByVisibleText(textToSelect);
            System.out.println("Selected option by visible text: " + textToSelect);
            System.out.println("Current selected option: " + dropdown.getFirstSelectedOption().getText());

            // 5. Select an option by index
            int indexToSelect = 3; // Index 3 corresponds to "Manager" (0-based index)
            dropdown.selectByIndex(indexToSelect);
            System.out.println("Selected option by index: " + indexToSelect + 
                               " (" + dropdown.getFirstSelectedOption().getText() + ")");
            System.out.println("Current selected option: " + dropdown.getFirstSelectedOption().getText());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
```