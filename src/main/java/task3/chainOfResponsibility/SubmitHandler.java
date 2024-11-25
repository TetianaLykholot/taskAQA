package task3.chainOfResponsibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubmitHandler extends Handler{
    @Override
    protected boolean process(WebDriver driver, String username, String password) {
        try {
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
            System.out.println("Clicked login button.");

            // Check for login success
            if (driver.getCurrentUrl().contains("inventory.html")) {
                System.out.println("Login successful!");
                return true;
            } else {
                WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));
                System.out.println("Login error message: " + errorMessage.getText());
                return false;
            }
        } catch (Exception e) {
            System.out.println("Failed to submit login: " + e.getMessage());
            return false;
        }
    }
}