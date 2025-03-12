package taskParallelExecution;

import org.testng.annotations.Test;


public class ParallelExecutionForClass extends LoginPage {

    @Test (dataProvider = "loginDataProvider", dataProviderClass = DataProviderUsers.class)
    public void loginToTheTestPage(String email, String password) {
         login(email, password);
    }
    }


