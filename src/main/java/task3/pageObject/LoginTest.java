package task3.pageObject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    protected WebDriver driver;
    SignInPage signInPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get("https://www.saucedemo.com/");
        signInPage = new SignInPage(driver);

    }
       @Test
       public void testValidLogin() {
        signInPage.enterUsername("standard_user");
        signInPage.enterPassword("secret_sauce");
        signInPage.clickLogin();

       assert driver.getCurrentUrl().contains("inventory"): "Login failed";

    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }



}
