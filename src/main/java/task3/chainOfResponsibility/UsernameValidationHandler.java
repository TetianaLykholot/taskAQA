package task3.chainOfResponsibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsernameValidationHandler extends Handler{

    @Override
    protected boolean process(WebDriver driver, String username, String password) {
        try {
            WebElement usernameField = driver.findElement(By.id("user-name"));
            usernameField.clear();
            usernameField.sendKeys(username);
            System.out.println("Entered username.");
            return true;
        } catch (Exception e) {
            System.out.println("Failed to enter username: " + e.getMessage());
            return false;
        }
    }
}
