package taskSeleniumTest;

import org.testng.annotations.DataProvider;

public class DataProviderBooks {
    @DataProvider(name = "books")
    public Object[][] dataOfBooks() {
        return new Object[][]{
                {"Thinking in Java: The Definitive Introduction to Object-Oriented Programming in the Language of the World-Wide Web, 3rd Edition"},
                {"Thinking in Java"},
                {"Thinking in Java (2nd Edition)"}
        };
    }
}
