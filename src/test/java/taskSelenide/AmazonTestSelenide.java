package taskSelenide;

import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Visible;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import taskSeleniumTest.DataProviderBooks;
import com.codeborne.selenide.testng.ScreenShooter;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


@Listeners({ScreenShooter.class})


public class AmazonTestSelenide {

    @BeforeClass
    public static void setUp() {
        ScreenShooter.captureSuccessfulTests = true;
        Configuration.reportsFolder = "/Users/Tetiana_Lykholot/IdeaProjects/taskAQA/src/test/java/taskSelenide/screenshots";
    }

    @Test(dataProvider = "books", dataProviderClass = DataProviderBooks.class)
    public void checkingSearchResult(String bookResult) {
        open("https://www.bookdepository.com/ ");
        $(byXpath("//input[@id='twotabsearchtextbox']")).sendKeys("Thinking in Java");
        $(byId("nav-search-submit-button")).click();
        ElementsCollection books = $$(byCssSelector("h2.a-size-medium.a-spacing-none.a-color-base.a-text-normal"));
        boolean found = false;
        for (SelenideElement book : books) {
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
        open("https://www.bookdepository.com/ ");
        $(byXpath("//input[@id='twotabsearchtextbox']")).sendKeys("Thinking in Java");
        $(byId("nav-search-submit-button")).click();
        $(byXpath("//span[text()='Beginners & Seniors']")).click();
        $(byXpath("//span[@class='icp-nav-link-inner']")).shouldBe(visible).contextClick();
        //Verify that search results contain different books (up to 3-5 expected books)
        $(byXpath("//h2[@class='a-size-medium-plus a-spacing-none a-color-base a-text-bold']")).shouldHave(exactText("Results"));
        ElementsCollection books = $$(byCssSelector("h2.a-size-medium.a-spacing-none.a-color-base.a-text-normal"));
        boolean found = false;
        for (SelenideElement bookName : books) {
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
       open("https://www.bookdepository.com/ ");
        SelenideElement search =  $(byXpath("//input[@id='twotabsearchtextbox']"));
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.sendKeys(search, "Thinking in Java").perform();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("document.getElementById('nav-search-submit-button').click();");
        //  Add one of the books into the basket
        $(byXpath("//span[text()='Think Java: How to Think Like a Computer Scientist']")).click();
        $(By.id("add-to-cart-button")).click();
        //Go to Basket/Checkout page
        $(byXpath("//span[@id='sw-gtc']")).click();
        String subTotal = $(byXpath("//span[@id='sc-subtotal-amount-activecart']")).getText();
        //Verify the order summary
        Assert.assertEquals(" $30.49", subTotal);
    }
}
