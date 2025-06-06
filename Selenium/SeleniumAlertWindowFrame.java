import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class SeleniumAlertWindowFrame {
    public static void main(String[] args) {
        // Set path to ChromeDriver (update with your ChromeDriver path)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Use a test website with alerts (e.g., the-internet.herokuapp.com)
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

            // 1. Capturing the alert message using getText()
            driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Alert')]")).click();
            Alert simpleAlert = driver.switchTo().alert();
            String alertText = simpleAlert.getText();
            System.out.println("Alert message: " + alertText);
            simpleAlert.accept();

            // 2. Prompt Alert with Text Box to enter the text
            driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Prompt')]")).click();
            Alert promptAlert = driver.switchTo().alert();
            promptAlert.sendKeys("Test Input");
            promptAlert.accept();
            System.out.println("Entered text in prompt alert");

            // 3. Confirmation Alert with Ok and Cancel buttons
            driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]")).click();
            Alert confirmAlert = driver.switchTo().alert();
            System.out.println("Confirmation alert message: " + confirmAlert.getText());

            // 4. Clicking OK button of the alert using accept()
            confirmAlert.accept();
            System.out.println("Clicked OK on confirmation alert");

            // 5. Clicking Cancel button of the alert using dismiss()
            driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]")).click();
            confirmAlert = driver.switchTo().alert();
            confirmAlert.dismiss();
            System.out.println("Clicked Cancel on confirmation alert");

            // Navigate to a site for window handling (e.g., example.com or a site with multiple windows)
            driver.get("https://example.com");

            // 6. Handle single window using driver.getWindowHandle()
            String mainWindow = driver.getWindowHandle();
            System.out.println("Main window handle: " + mainWindow);

            // 7. Handle multiple windows using driver.getWindowHandles()
            // Simulate opening a new window (adjust selector based on your site)
            driver.findElement(By.linkText("More Information")).click(); // Assumes this opens a new window
            Set<String> allWindows = driver.getWindowHandles();
            System.out.println("Total windows: " + allWindows.size());
            for (String window : allWindows) {
                System.out.println("Window handle: " + window);
            }

            // 8. Switch to window using driver.switchTo().window()
            for (String window : allWindows) {
                if (!window.equals(mainWindow)) {
                    driver.switchTo().window(window);
                    System.out.println("Switched to new window: " + driver.getTitle());
                    driver.close(); // Close the new window
                    break;
                }
            }
            driver.switchTo().window(mainWindow); // Switch back to main window
            System.out.println("Switched back to main window: " + driver.getTitle());

            // 9. Switch to frame using driver.switchTo().frame()
            // Navigate to a site with frames (e.g., w3schools frames page)
            driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_frame_mix");
            driver.switchTo().frame("frameName"); // Replace with actual frame name, id, or index
            System.out.println("Switched to frame");
            driver.switchTo().defaultContent(); // Switch back to main content

            // 10. Switch to popup using driver.switchTo.alert()
            // Already demonstrated in tasks 1-5, but re-demonstrating for clarity
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Alert')]")).click();
            Alert popupAlert = driver.switchTo().alert();
            System.out.println("Switched to popup alert: " + popupAlert.getText());
            popupAlert.accept();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}