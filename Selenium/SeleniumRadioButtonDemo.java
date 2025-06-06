```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class SeleniumRadioButtonDemo {
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

            // Locate the radio button group (all radio buttons with name="gender")
            List<WebElement> radioButtons = driver.findElements(By.name("gender"));

            // 1. Select a radio button by label text
            String labelToSelect = "Female";
            for (WebElement radio : radioButtons) {
                String labelText = radio.findElement(By.xpath("following-sibling::text()[1]")).getText().trim();
                if (labelText.equals(labelToSelect)) {
                    radio.click();
                    System.out.println("Selected radio button with label: " + labelToSelect);
                    break;
                }
            }

            // Select by value (alternative approach)
            String valueToSelect = "Male";
            WebElement radioByValue = driver.findElement(By.cssSelector("input[name='gender'][value='" + valueToSelect + "']"));
            radioByValue.click();
            System.out.println("Selected radio button with value: " + valueToSelect);

            // 2. Find out number of elements in the radio group
            int radioCount = radioButtons.size();
            System.out.println("Number of radio buttons in the group: " + radioCount);

            // 3. Get all radio button values
            System.out.println("Radio button values:");
            for (WebElement radio : radioButtons) {
                String value = radio.getAttribute("value");
                System.out.println("- " + value);
            }

            // 4. Get the selected radio button's label text
            String selectedLabel = "";
            for (WebElement radio : radioButtons) {
                if (radio.isSelected()) {
                    selectedLabel = radio.findElement(By.xpath("following-sibling::text()[1]")).getText().trim();
                    break;
                }
            }
            System.out.println("Selected radio button label: " + selectedLabel);

            // 5. Check if a specific radio button is selected
            WebElement maleRadio = driver.findElement(By.cssSelector("input[name='gender'][value='Male']"));
            boolean isMaleSelected = maleRadio.isSelected();
            System.out.println("Is 'Male' radio button selected? " + isMaleSelected);

            // 6. Check if a radio button is enabled or disabled
            boolean isMaleEnabled = maleRadio.isEnabled();
            System.out.println("Is 'Male' radio button enabled? " + isMaleEnabled);

            // Simulate disabling the form to test disabled state
            // Note: In the AngularJS app, the radio buttons are not directly tied to ng-disabled
            // For demo, we'll assume they could be disabled via a similar mechanism
            // Since the app doesn't disable radio buttons, we expect isEnabled=true
            // To test disabled state, we could manipulate the DOM (not implemented here for simplicity)
            System.out.println("Note: Radio buttons are not disabled in this form by default.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
```