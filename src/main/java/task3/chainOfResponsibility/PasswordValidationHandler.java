package task3.chainOfResponsibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordValidationHandler extends Handler{
    @Override
    protected boolean process(WebDriver driver, String username, String password) {
        try {
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.clear();
            passwordField.sendKeys(password);
            System.out.println("Entered password.");
            return true;
        } catch (Exception e) {
            System.out.println("Failed to enter password: " + e.getMessage());
            return false;
        }
    }
}
