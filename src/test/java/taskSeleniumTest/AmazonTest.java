package taskSeleniumTest;

import com.beust.jcommander.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Script;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.AbstractParallelWorker;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class AmazonTest {
    private WebDriver driver;
    private List<String> expectedBooks = Arrays.asList("Thinking in Java",
            "Think Java: How to Think Like a Computer Scientist",
            "Thinking in Java (2nd Edition)");
    private List<String> expectedBooksAfterFilter = Arrays.asList("Thinking in Java: The Definitive Introduction to " +
                    "Object-Oriented Programming in the Language of the World-Wide Web, 3rd Edition",
            "Think Java: How to Think Like a Computer Scientist",
            "Java: Learn Java in One Day and Learn It Well. Java for " +
                    "Beginners with Hands-on Project. (Learn Coding Fast with Hands-On Project)");

    @BeforeTest
    public void setupDriver() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
    }

    @AfterTest
    void teardown() {
        driver.quit();
    }

    @Test
    public void amazonTest() throws InterruptedException {
        //1. Open the page
        driver.get("https://www.bookdepository.com/ ");
        //Actions implementations: Mouse Hover Action and Right click:
        //Add Explicit Wait
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement language = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icp-nav-link-inner']")));
        action.moveToElement(language).build().perform();
        action.contextClick(language).perform();
        // Action for keyboard:
        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        //Search for the “Thinking in Java” book
        action.sendKeys(search, "Thinking in Java").perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('nav-search-submit-button').click();");

        //Verify that search results contain different books (up to 3-5 expected books)
        WebElement resultInscription = driver.findElement(By.xpath("//h2[@class='a-size-medium-plus " +
                "a-spacing-none a-color-base a-text-bold']"));
        js.executeScript("arguments[0].style.background='yellow'", resultInscription);
        Thread.sleep(3000);
        boolean allBooksFound = true;
        for (String expectedBook : expectedBooks) {
            if (driver.findElements(By.xpath("//*[contains(text(),'" + expectedBook + "')]")).size() == 0) {
                System.out.println(expectedBook);
                allBooksFound = false;
                System.out.println("Book not found: " + expectedBook);
            }
        }
        Assert.assertTrue(allBooksFound, "Not all books were found in search results");

        //Apply search filters
        driver.findElement(By.xpath("//span[text()='Beginners & Seniors']")).click();
        // Add implicitWait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Verify the updated books
        boolean allBooksFoundAfterFilter = true;
        for (String expectedBooksAfterFilter : expectedBooksAfterFilter) {
            if (driver.findElements(By.xpath("//*[contains(text(),'" + expectedBooksAfterFilter + "')]")).size() == 0) {
                System.out.println(expectedBooksAfterFilter);
                allBooksFoundAfterFilter = false;
                System.out.println("Book not found: " + expectedBooksAfterFilter);
            }
        }
        Assert.assertTrue(allBooksFoundAfterFilter, "Not all books were found in search results after filter");

        //Add one of the books into the basket
        driver.findElement(By.xpath("//span[text()='Think Java: How to Think Like a Computer Scientist']")).click();
        driver.findElement(By.xpath("//span[@id='submit.add-to-cart-ubb']")).click();

        //Go to Basket/Checkout page
        driver.findElement(By.xpath("//span[@id='sw-gtc']")).click();
        String subTotal = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']")).getText();

        //Verify the order summary
        Assert.assertEquals(" $19.63", subTotal);
    }
}


