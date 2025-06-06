import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class SeleniumLinkActions {
    public static void main(String[] args) {
        // Set path to ChromeDriver (update with your ChromeDriver path)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the website
            driver.get("https://example.com");

            // 1. Clicking a link using partialLinkText
            WebElement partialLink = driver.findElement(By.partialLinkText("More"));
            partialLink.click();
            System.out.println("Clicked link using partialLinkText");
            driver.navigate().back(); // Return to the main page

            // 2. Clicking a link using linkText
            WebElement exactLink = driver.findElement(By.linkText("More Information"));
            exactLink.click();
            System.out.println("Clicked link using linkText");
            driver.navigate().back(); // Return to the main page

            // 3. Finding all links on the web page
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println("Total links found: " + links.size());
            for (WebElement link : links) {
                System.out.println("Link Text: " + link.getText() + ", URL: " + link.getAttribute("href"));
            }

            // 4. Clicking on an image link (example: <a> tag containing an <img> tag)
            // Adjust the XPath based on your website's structure
            WebElement imageLink = driver.findElement(By.xpath("//a[img]"));
            imageLink.click();
            System.out.println("Clicked image link");
            driver.navigate().back(); // Return to the main page

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}