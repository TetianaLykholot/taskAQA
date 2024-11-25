package task3.chainOfResponsibility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChainLoginTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            Handler openSiteHandler = new OpenSiteHandler();
            Handler usernameHandler = new UsernameValidationHandler();
            Handler passwordHandler = new PasswordValidationHandler();
            Handler submitHandler = new SubmitHandler();

            openSiteHandler.setNext(usernameHandler).setNext(passwordHandler).setNext(submitHandler);

            System.out.println("Test 1: Valid Credentials");
            openSiteHandler.handle(driver, "standard_user", "secret_sauce");

            System.out.println("\nTest 2: Invalid Username");
            openSiteHandler.handle(driver, "invalid_user", "secret_sauce");

            System.out.println("\nTest 3: Invalid Password");
            openSiteHandler.handle(driver, "standard_user", "wrong_password");
        } finally {
            driver.quit();
        }
    }
}
