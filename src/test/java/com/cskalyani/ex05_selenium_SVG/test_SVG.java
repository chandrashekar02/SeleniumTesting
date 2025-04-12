package com.cskalyani.ex05_selenium_SVG;

import com.cskalyani.waitHelper.WaitHelpers;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class test_SVG {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
    }

    @Test
    @Description("TC - Verify that the on search with svg icon results are visible")
    public void test_Flipkart_Search_SVG_Icon(){
        driver.findElement(By.name("q")).sendKeys("Mac Mini");
       // driver.findElement(By.xpath("//button[@title='Search for Products, Brands and More']")).click();

        //using svg,   xpath -> //*[name(),'svg']
        List<WebElement> svg_element = driver.findElements(By.xpath("//*[name()='svg']"));
        svg_element.get(0).click();

        //to get the title of the all mac-mini
        List<WebElement> macmini_Title = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]//a[2]"));
        for(WebElement title : macmini_Title) {
            System.out.println(title.getText());
        }
    }


    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
