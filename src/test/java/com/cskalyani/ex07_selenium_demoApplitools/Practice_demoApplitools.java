package com.cskalyani.ex07_selenium_demoApplitools;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Practice_demoApplitools {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    @Description("Start login")
    public void start_Browser(){
        this.driver = new EdgeDriver();
        driver.get("https://demo.applitools.com/");
        driver.manage().window().maximize();
    }

    public void wait_ElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @Test(priority = 1)
    @Description("TC - Verify that able to login demo applitools with valid inputs")
    public void login(){
        String userName = "Admin";
        driver.findElement(By.id("username")).sendKeys(userName);
        String password = "Password@123";
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("log-in")).click();
    }

    @Test(priority = 2)
    @Description("TC - Verify that the sum of recent transaction")
    public void test_demoAppliTools_sum(){
        List<WebElement> amountList = driver.findElements(By.xpath("//td[@class='text-right bolder nowrap']"));

        for(WebElement amountElement: amountList){
            String amount = amountElement.getText();

            int a = Integer.parseInt(amount);
            System.out.println(a);
        }
    }

    @AfterTest
    @Description("Close Browser")
    public void close_Browser(){
        driver.quit();
    }
}
