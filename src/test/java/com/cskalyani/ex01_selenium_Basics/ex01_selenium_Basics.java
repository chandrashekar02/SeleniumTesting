package com.cskalyani.ex01_selenium_Basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ex01_selenium_Basics {

    @Test
    public void verify_VWOLogin() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        String title = driver.getTitle();
        System.out.println(title);

        Assert.assertEquals(title,"Login - VWO");

        driver.quit();
    }
}
