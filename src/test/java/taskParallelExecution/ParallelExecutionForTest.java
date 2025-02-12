package taskParallelExecution;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import taskSeleniumTest.BaseTest;

public class ParallelExecutionForTest extends BaseTest {

    @Test
       public void loginToTheTestPageWithStandartUser() {
           driver.get("https://www.saucedemo.com/");
           driver.findElement(By.id("user-name")).sendKeys("standard_user");
           driver.findElement(By.id("password")).sendKeys("secret_sauce");
           driver.findElement(By.id("login-button")).click();
       }

       @Test
       public void loginToTheTestPageWithIncorrectUser() {
           driver.get("https://www.saucedemo.com/");
           driver.findElement(By.id("user-name")).sendKeys("error_user");
           driver.findElement(By.id("password")).sendKeys("secret_sauce");
           driver.findElement(By.id("login-button")).click();
       }

    @Test
    public void loginToTheTestPageWithLockedOutUser() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}
