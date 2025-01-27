package taskSeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;

public class AmazonTest extends BaseTest {

    @Test(dataProvider = "books", dataProviderClass = DataProviderBooks.class)
    public void checkingSearchResult(String bookResult) {
        Actions action = new Actions(driver);
        driver.get("https://www.bookdepository.com/ ");
        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        action.sendKeys(search, "Thinking in Java").perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('nav-search-submit-button').click();");
        List<WebElement> books = driver.findElements(By.cssSelector("h2.a-size-medium.a-spacing-none.a-color-base.a-text-normal"));
        boolean found = false;
        for (WebElement book : books) {
            String name = book.getText();
            if (name.equals(bookResult)) {
                System.out.println("I found this book " + book.getText());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(" I don't fond this book");
        }
    }

    @Test
    @Parameters({"book"})
    public void checkingSearchResultAfterUsingTheFilter(String book) {
        driver.get("https://www.bookdepository.com/ ");
        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Actions action = new Actions(driver);
        action.sendKeys(search, "Thinking in Java").perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('nav-search-submit-button').click();");
        driver.findElement(By.xpath("//span[text()='Beginners & Seniors']")).click();
        //Actions implementations: Mouse Hover Action and Right click:
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement language = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icp-nav-link-inner']")));
        action.moveToElement(language).build().perform();
        action.contextClick(language).perform();
        //Verify that search results contain different books (up to 3-5 expected books)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        List<WebElement> books = driver.findElements(By.cssSelector("h2.a-size-medium.a-spacing-none.a-color-base.a-text-normal"));
        boolean found = false;
        for (WebElement bookName : books) {
            String name = bookName.getText();
            if (name.equals(book)) {
                System.out.println("I found this book " + bookName.getText());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(" I don't fond this book");
        }
    }
    @Test
    public void chekingAddingToCart() {
        driver.get("https://www.bookdepository.com/ ");
        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Actions action = new Actions(driver);
        action.sendKeys(search, "Thinking in Java").perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('nav-search-submit-button').click();");
        //  Add one of the books into the basket
        driver.findElement(By.xpath("//span[text()='Think Java: How to Think Like a Computer Scientist']")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        //Go to Basket/Checkout page
        driver.findElement(By.xpath("//span[@id='sw-gtc']")).click();
        String subTotal = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']")).getText();
        //Verify the order summary
        Assert.assertEquals(" $30.49", subTotal);
    }
}


