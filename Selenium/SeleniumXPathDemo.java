```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class SeleniumXPathDemo {
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

            // 1. Read label text and its color
            WebElement usernameLabel = driver.findElement(By.xpath("//label[@for='username']"));
            String labelText = usernameLabel.getText();
            String labelColor = usernameLabel.getCssValue("color");
            System.out.println("Username label text: " + labelText);
            System.out.println("Username label color: " + labelColor);

            // 2. Write XPath for id, name, className
            // id: username input
            WebElement byId = driver.findElement(By.xpath("//input[@id='username']"));
            System.out.println("Found element by id XPath, value: " + byId.getAttribute("value"));
            // name: email input
            WebElement byName = driver.findElement(By.xpath("//input[@name='email']"));
            System.out.println("Found element by name XPath, value: " + byName.getAttribute("value"));
            // className: error span
            WebElement byClassName = driver.findElement(By.xpath("//span[@class='error']"));
            System.out.println("Found element by className XPath, text: " + byClassName.getText());

            // 3. Find an element that contains specific text using contains()
            String partialText = "contain a number";
            WebElement containsElement = driver.findElement(By.xpath("//span[contains(text(), '" + partialText + "')]"));
            System.out.println("Element with contains(text()): " + containsElement.getText());

            // 4. Find an element using text()
            String exactText = "Email:";
            WebElement textElement = driver.findElement(By.xpath("//label[text()='" + exactText + "']"));
            System.out.println("Element with text(): " + textElement.getText());

            // 5. Find an element that starts-with()
            String startsWithText = "User";
            WebElement startsWithElement = driver.findElement(By.xpath("//label[starts-with(text(), '" + startsWithText + "')]"));
            System.out.println("Element with starts-with(): " + startsWithElement.getText());

            // 6. XPath to select following-sibling and preceding
            // following-sibling: Find the error span following the username input
            WebElement followingSibling = driver.findElement(By.xpath("//input[@id='username']/following-sibling::span[@class='error']"));
            System.out.println("Following-sibling error span: " + followingSibling.getText());
            // preceding: Find the label preceding the email input
            WebElement precedingElement = driver.findElement(By.xpath("//input[@id='email']/preceding::label[@for='email']"));
            System.out.println("Preceding label for email: " + precedingElement.getText());

            // 7. XPath to select using ancestor, child, parent, descendant
            // ancestor: Find the form ancestor of the username input
            WebElement ancestorElement = driver.findElement(By.xpath("//input[@id='username']/ancestor::form"));
            System.out.println("Ancestor form tag name: " + ancestorElement.getTagName());
            // child: Find the option child of the role select
            WebElement childElement = driver.findElement(By.xpath("//select[@id='role']/child::option[@value='Developer']"));
            System.out.println("Child option text: " + childElement.getText());
            // parent: Find the div parent of the email input
            WebElement parentElement = driver.findElement(By.xpath("//input[@id='email']/parent::div"));
            System.out.println("Parent div class: " + parentElement.getAttribute("class"));
            // descendant: Find all input descendants of the form
            List<WebElement> descendantElements = driver.findElements(By.xpath("//form/descendant::input"));
            System.out.println("Number of input descendants in form: " + descendantElements.size());

            // 8. XPath using OR and AND
            // OR: Find an element that is either a label for username or email
            List<WebElement> orElements = driver.findElements(By.xpath("//label[@for='username'] | //label[@for='email']"));
            System.out.println("Elements with OR condition:");
            for (WebElement elem : orElements) {
                System.out.println("- " + elem.getText());
            }
            // AND: Find an input that has both id='username' and name='username'
            WebElement andElement = driver.findElement(By.xpath("//input[@id='username' and @name='username']"));
            System.out.println("Element with AND condition, value: " + andElement.getAttribute("value"));

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
```