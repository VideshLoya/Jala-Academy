import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SeleniumAdvancedOperations {
    public static void main(String[] args) {
        // Set path to ChromeDriver (update with your ChromeDriver path)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // 9. Cookies operations - Profile creation for browsers
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/path/to/profile"); // Custom profile path
        WebDriver driver = new ChromeDriver(options);

        try {
            // 1. Write a test case to capture the screenshots with WebDriver
            driver.get("https://the-internet.herokuapp.com/");
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("screenshot.png");
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved as screenshot.png");

            // 2. Click on an element which is in iFrame
            driver.get("https://the-internet.herokuapp.com/iframe");
            driver.switchTo().frame("mce_0_ifr"); // Switch to iframe by ID
            WebElement editor = driver.findElement(By.id("tinymce"));
            editor.clear();
            editor.sendKeys("Text in iFrame");
            driver.switchTo().defaultContent(); // Switch back to main content
            System.out.println("Clicked and typed in iFrame element");

            // 3. Find out the broken links on a web page
            driver.get("https://the-internet.herokuapp.com/");
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println("Total links: " + links.size());
            for (WebElement link : links) {
                String url = link.getAttribute("href");
                if (url != null && !url.isEmpty()) {
                    try {
                        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                        conn.setRequestMethod("HEAD");
                        conn.connect();
                        int responseCode = conn.getResponseCode();
                        if (responseCode >= 400) {
                            System.out.println("Broken link: " + url + " (Status: " + responseCode + ")");
                        }
                    } catch (IOException e) {
                        System.out.println("Error checking link: " + url + " (" + e.getMessage() + ")");
                    }
                }
            }

            // 4. Implicit and Explicit wait commands
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
            WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
            driver.findElement(By.xpath("//button[text()='Start']")).click();
            WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
            System.out.println("Explicit wait: Element text - " + element.getText());

            // 5. Action class operations
            Actions actions = new Actions(driver);
            driver.get("https://the-internet.herokuapp.com/drag_and_drop");

            // Keyboard key press event
            WebElement inputField = driver.findElement(By.tagName("input")); // Adjust if needed
            actions.sendKeys(inputField, "Test").perform();
            System.out.println("Performed keyboard key press");

            // Pressing enter button on the keyboard
            actions SENDKeys(Keys.ENTER).perform();
            System.out.println("Pressed Enter key");

            // ClickAndHold event, Drag and Drop
            WebElement source = driver.findElement(By.id("column-a"));
            WebElement target = driver.findElement(By.id("column-b"));
            actions.clickAndHold(source).moveToElement(target).release().perform();
            System.out.println("Performed drag and drop");

            // MoveToElement, Mouse Hover Event
            driver.get("https://the-internet.herokuapp.com/hovers");
            WebElement hoverElement = driver.findElement(By.className("figure"));
            actions.moveToElement(hoverElement).perform();
            System.out.println("Performed mouse hover");

            // Double Click event
            actions.doubleClick(hoverElement).perform();
            System.out.println("Performed double click");

            // 6. Web Table operations
            driver.get("https://the-internet.herokuapp.com/tables");
            WebElement table = driver.findElement(By.id("table1"));

            // Get row count
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            System.out.println("Row count: " + rows.size());

            // Get data from a specific cell (e.g., row 2, column 3)
            WebElement cell = table.findElement(By.xpath("//tr[2]/td[3]"));
            System.out.println("Cell (2,3) data: " + cell.getText());

            // Dynamic web table handling (loop through rows)
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.(By.tagName("td"));
                for (WebElement cellData : cells) {
                    System.out.print(cellData.getText() + " | ");
                }
                System.out.println();
            }

            // 7. Handling Ajax Auto suggestion
            driver.get("https://www.google.com");
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium");
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("suggestions-inner-container")));
            List<WebElement> suggestions = driver.findElements(By.className("suggestions-inner-container"));
            for (WebElement suggestion : suggestions) {
                if (suggestion.getText().contains("Selenium WebDriver")) {
                    suggestion.click();
                    break;
                }
            }
            System.out.println("Selected AJAX auto-suggestion");

            // 8. Select a specific date from a calendar
            driver.get("https://www.redbus.in");
            WebElement datePicker = driver.findElement(By.id("onward_cal"));
            datePicker.click();
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='15']")));
            driver.findElement(By.xpath("//td[text()='15']")).click();
            System.out.println("Selected date 15 from calendar");

            // 9. Cookies operations - Adding and Deleting cookies
            driver.get("https://example.com");
            // Add a cookie
            Cookie newCookie = new Cookie("testCookie", "testValue");
            driver.manage().addCookie(newCookie);
            System.out.println("Added cookie: " + newCookie.getName());

            // Get all cookies
            Set<Cookie> cookies = driver.manage().getCookies();
            System.out.println("Total cookies: " + cookies.size());
            for (Cookie cookie : cookies) {
                System.out.println("Cookie: " + cookie.getName() + " = " + cookie.getValue());
            }

            // Delete a cookie
            driver.manage().deleteCookieNamed("testCookie");
            System.out.println("Deleted cookie: testCookie");

            // Delete all cookies
            driver.manage().deleteAllCookies();
            System.out.println("Deleted all cookies");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}