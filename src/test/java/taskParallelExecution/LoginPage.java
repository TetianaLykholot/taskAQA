package taskParallelExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends BaseTest {

    @FindBy(id = "user-name") // Check the exact ID in the application
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    // Constructor to initialize the PageFactory elements
    public LoginPage() {
        WebDriver driver =  getDriver();
        if(driver == null){
            throw new IllegalStateException("WebDriver is not initialized.");
        }
        // Initialize the web elements
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        if (usernameInput == null) throw new NullPointerException("Username input element is null!");
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String username, String password) throws IOException {
        getDriver().get("https://www.saucedemo.com/");
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        writeUserEmailToFile(username);
    }
}