package task3.chainOfResponsibility;

import org.openqa.selenium.WebDriver;

public class OpenSiteHandler extends Handler{
    @Override
    protected boolean process(WebDriver driver, String username, String password) {
        try {
            driver.get("https://www.saucedemo.com/");
            System.out.println("Opened SauceDemo site.");
            return true;
        } catch (Exception e) {
            System.out.println("Failed to open site: " + e.getMessage());
            return false;
        }
    }
}
