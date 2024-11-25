package task3.singelton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverInstance {
    private static WebdriverInstance instance = null;
    private static WebDriver driver;

    public WebdriverInstance() {
        driver = new ChromeDriver();
    }

    public static WebdriverInstance getInstance() {
        if (instance == null) {
            synchronized (WebdriverInstance.class) {
                if (instance == null) {
                    instance = new WebdriverInstance();
                }
            }
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        driver.quit();
        instance = null;
    }
}
