package taskParallelExecution;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import taskSeleniumTest.BaseTest;

public class ParallelExecutionForTest extends LoginPage {

    @Test
       public void loginToTheTestPageWithStandartUser() {
           driver.get("https://www.saucedemo.com/");
          login("standard_user", "secret_sauce" );
       }

       @Test
       public void loginToTheTestPageWithIncorrectUser() {
           driver.get("https://www.saucedemo.com/");
           login("error_user", "secret_sauce" );

       }

    @Test
    public void loginToTheTestPageWithLockedOutUser() {
        driver.get("https://www.saucedemo.com/");
        login("locked_out_user", "secret_sauce" );

    }
}
