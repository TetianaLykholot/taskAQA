package task3.chainOfResponsibility;

import org.openqa.selenium.WebDriver;

public abstract class Handler {
    private Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }
    public void handle(WebDriver driver, String username, String password) {
        if (process(driver, username, password)) {
            if (next != null) {
                next.handle(driver, username, password);
            } else {
                System.out.println("Login successful!");
            }
        } else {
            System.out.println("Login failed at " + this.getClass().getSimpleName());
        }
    }

    protected abstract boolean process(WebDriver driver, String username, String password);
}
