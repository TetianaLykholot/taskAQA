package task3.dto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

   @Test
    public void testValidLogin() {
        // Use DTO for test data
        LoginDTO validUser = new LoginDTO("standard_user", "secret_sauce");

        // Perform login
        loginPage.login(validUser);

        // Verify login success (e.g., check for redirection or element presence)
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User was not redirected to the inventory page.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
