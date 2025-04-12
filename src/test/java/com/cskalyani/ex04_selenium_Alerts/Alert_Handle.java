package com.cskalyani.ex04_selenium_Alerts;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alert_Handle {

    @Test
    @Description("Handling alert")
    public void test_Alerts() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        driver.manage().window().maximize();


        WebElement showalertBox = driver.findElement(By.id("alertexamples"));
        showalertBox.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement confirmBox = driver.findElement(By.id("confirmexample"));
        confirmBox.click();
        alert.accept();
        WebElement verify_ConfirmBox = driver.findElement(By.id("confirmreturn"));
        String re = verify_ConfirmBox.getText();
        if (re.equals("true")) {
            Assert.assertEquals(re, "true");
        } else {
            Assert.assertEquals(re, "false");
        }

        WebElement showPromtBox = driver.findElement(By.id("promptexample"));
        showPromtBox.click();
        alert.sendKeys("Hello");
        alert.accept();
        WebElement verify_PromptBox = driver.findElement(By.id("promptreturn"));
        String re1 = verify_PromptBox.getText();
        Assert.assertEquals(re1, "Hello");

        driver.quit();
    }
}
