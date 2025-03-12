package taskParallelExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class BaseTest {

    String chromeDriverPath = System.getenv("CHROME_DRIVER_PATH");
    protected WebDriver driver;

    @Parameters("browser")

    @BeforeClass
    public void initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        }
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }


    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
}

