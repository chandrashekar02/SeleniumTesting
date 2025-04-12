package com.cskalyani.ex02_selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;


public class ex02_selenium_Basics {

    @Test
    public void selenium01(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        String title = driver.getTitle();

        assertThat(title).isNotNull().isEqualTo("Login - VWO");

        driver.quit();
    }

}
