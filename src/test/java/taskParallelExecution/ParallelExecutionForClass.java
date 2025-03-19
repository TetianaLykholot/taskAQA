package taskParallelExecution;

import org.testng.annotations.Test;

import java.io.IOException;


public class ParallelExecutionForClass extends LoginPage {

    @Test (dataProvider = "loginDataProvider", dataProviderClass = DataProviderUsers.class)
    public void loginToTheTestPage(String email, String password) throws IOException {
         login(email, password);
    }
    }


