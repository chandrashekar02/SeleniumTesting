package com.cskalyani.ex03_selenium_Basics;


import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MiniProject {

    @Owner("Chandru")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Description("TC - Verify that invalid email error message")
    public void test_invalid_email() {

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.linkText("Start a free trial")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));

        WebElement bus_email = driver.findElement(By.id("page-v1-step1-email"));
        bus_email.sendKeys("abc");

        driver.findElement(By.name("gdpr_consent_checkbox")).click();

        List<WebElement> listOfButton = driver.findElements(By.tagName("button"));
        listOfButton.get(0).click();

        WebElement message = driver.findElement(By.className("invalid-reason"));
        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals(message.getText(), "The email address you entered is incorrect.");

        driver.quit();
    }


}
