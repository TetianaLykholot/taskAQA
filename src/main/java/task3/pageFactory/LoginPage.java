package task3.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Locators using @FindBy annotations
    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")

    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement logInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with the page
    public void enterUsername(String username) {
        userName.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        logInButton.click();
    }
}
