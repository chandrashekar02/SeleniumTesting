package com.cskalyani.ex09_selenium_Action;

import com.cskalyani.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;

public class Action_Class_Practice extends TestCaseBoilerPlate {


    @Test
    public void test(){
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);

        //Keys - Action classes
        WebElement username = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT)
                .sendKeys(username,"selenium automation")
                .keyUp(Keys.SHIFT)
                .build().perform();
    }
}
