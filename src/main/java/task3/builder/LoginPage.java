package task3.builder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.className("error-message-container");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with page elements
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        WebElement errorElement = driver.findElement(errorMessage);
        return errorElement.getText();
    }

    // Method to perform login using User object
    public void loginAsUser(User user) {
        enterUsername(user.getUsername());
        enterPassword(user.getPassword());
        clickLogin();
    }
}
