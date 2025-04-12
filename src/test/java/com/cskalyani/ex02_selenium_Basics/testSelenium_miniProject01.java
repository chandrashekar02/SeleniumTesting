package com.cskalyani.ex02_selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testSelenium_miniProject01 {

    @Description ("TC - Verify the login error message")
    @Test
    public void test_loginErrorMessage() throws InterruptedException {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--windowMaximized");

        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://app.vwo.com/#/login");

        //unique id -> name -> ClassName -> TagName -> Link Text/partial(a tag) -> CSS Selector -> Xpath

        WebElement userName = driver.findElement(By.id("login-username"));
        WebElement password = driver.findElement(By.id("login-password"));
        WebElement submit = driver.findElement(By.id("js-login-btn"));

        userName.sendKeys("admin@admin.com");
        password.sendKeys("admin");
        submit.click();

        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.id("js-notification-box-msg"));



        Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or location did not match");

        driver.quit();
    }
}
