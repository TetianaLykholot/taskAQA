package taskParallelExecution;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import taskSeleniumTest.BaseTest;

public class ParallelExecutionForClassOne extends LoginPage {
    @Test
    public void loginToTheTestPageWithStandartUserForClassOne() {
        driver.get("https://www.saucedemo.com/");
        login("standard_user", "secret_sauce" );
    }

    @Test
    public void loginToTheTestPageWithIncorrectUserForClassOne() {
        driver.get("https://www.saucedemo.com/");
        login("error_user", "secret_sauce" );
    }

    @Test
    public void loginToTheTestPageWithLockedOutUserForClassOne() {
        driver.get("https://www.saucedemo.com/");
        login("locked_out_user", "secret_sauce" );
    }
    
}
