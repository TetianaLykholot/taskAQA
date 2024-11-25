package task3.singelton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = WebdriverInstance.getInstance().getDriver();
    }

    @Test
    public void logIn(){
       driver.get("https://www.saucedemo.com/");
       driver.findElement(By.id("user-name")).sendKeys("standard_user");
       driver.findElement(By.id("password")).sendKeys("secret_sauce");
       driver.findElement(By.id("login-button")).click();
       String expectedUrl = "https://www.saucedemo.com/inventory.html";
       assert driver.getCurrentUrl().equals(expectedUrl) : "Login failed";
    }

    @AfterClass
    public void closeDriver(){
        WebdriverInstance.getInstance().quitDriver();
    }
}
