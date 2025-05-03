package taskParallelExecution;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String FILE_PATH = "test-output/user-emails.txt";
    private static final Object fileLock = new Object();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        WebDriver webDriver = createWebDriver(browser); // Create driver based on browser
        driver.set(webDriver); // Assign driver to ThreadLocal
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    private WebDriver createWebDriver(String browser) {
        if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            return new ChromeDriver(options);
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            return new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    @AfterClass
    public void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove(); // Remove thread-local driver to avoid memory leaks
        }
    }


    protected void writeUserEmailToFile(String email) throws IOException {
        synchronized (fileLock) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                writer.write(email);
                writer.newLine();
            }
        }
    }
}