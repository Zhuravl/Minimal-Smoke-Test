import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SmokeTest {

    public static void main(String[] args) {
        final int MAX_WAIT_TIME_IN_SEC = 30;
        WebDriver driver = null;
        String result = "The user is NOT able to log in to the website!";
        try {
            // Download and setup ChromeDriver
            WebDriverManager.chromedriver().setup();

            // Initialize the Chrome Driver
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-gpu"); // Disable GPU (for less resource consumption)
            options.addArguments("--window-size=1920,1080"); // Set browser window size just for usability
            options.addArguments("--ignore-certificate-errors"); // Ignores the certificate errors
            options.addArguments("--headless=new"); // Run in the headless mode (without graphic monitor usage)

            driver = new ChromeDriver(options);

            // Navigate to website
            driver.get(args[0]);

            // Wait for the Landing page to load
            WebDriverWait waitLanding = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT_TIME_IN_SEC));
            waitLanding.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("email")));

            // Input email
            WebElement emailInput = driver.findElement(By.id("email"));
            emailInput.sendKeys(args[1]);

            // Input password
            WebElement passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys(args[2]);

            // Click the Login button
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

            // Wait for the Home page to load
            WebDriverWait waitDetails = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT_TIME_IN_SEC));
            waitDetails.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("topNavHomeLink")));

            result = "The user is able to successfully log in to the website!";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }

            // Print the result
            System.out.println(result);
        }
    }
}