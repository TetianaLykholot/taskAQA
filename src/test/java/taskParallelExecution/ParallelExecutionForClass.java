package taskParallelExecution;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import taskSeleniumTest.BaseTest;

public class ParallelExecutionForClass extends LoginPage {
    @Test
    public void loginToTheTestPageWithStandartUserForClass() {
        driver.get("https://www.saucedemo.com/");
        login("standard_user", "secret_sauce" );
    }

    @Test
    public void loginToTheTestPageWithIncorrectUserForClass() {
        driver.get("https://www.saucedemo.com/");
        login("error_user", "secret_sauce" );
    }

    @Test
    public void loginToTheTestPageWithLockedOutUserForClass() {
        driver.get("https://www.saucedemo.com/");
        login("locked_out_user", "secret_sauce" );
    }
}
