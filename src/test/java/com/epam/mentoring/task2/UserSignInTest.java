package com.epam.mentoring.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserSignInTest extends AbstractTest{
    private final String sortingButtonName = "Name (A to Z)";
    private final String email = "standard_user";
    private final String password = "secret_sauce";

    @Test
    public void uiVerification() {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='active_option']")));
        String sortingActualButtonName = driver.findElement(By.xpath("//span[@class='active_option']")).getText();
        Assert.assertEquals(sortingActualButtonName, sortingButtonName);
    }

    @Test
    public void uiNegativeVerification() {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("wrong_password");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message-container error']")));
        String actualErrorName = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
        Assert.assertEquals(actualErrorName, "Epic sadface: Username and password do not match any user in this service");
        System.out.println(actualErrorName);

    }
}
