package com.cskalyani.ex02_selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testSelenium01 {

    @Test
    public void test_selenium() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.in/");

        //Navigation functions

        driver.navigate().to("https://www.binge.com");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        Thread.sleep(5000);


        driver.quit();

    }
}
