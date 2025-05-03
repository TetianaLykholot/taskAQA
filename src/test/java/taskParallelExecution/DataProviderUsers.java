package taskParallelExecution;

import org.testng.annotations.DataProvider;

public class DataProviderUsers {
    @DataProvider(name = "loginDataProvider", parallel = true)
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"}
        };
    }
}
