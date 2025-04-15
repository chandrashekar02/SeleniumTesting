package com.cskalyani;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseBoilerPlate {

    public EdgeDriver driver;

    @BeforeTest
    @Description
    public void start_Browser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
    }

    @AfterTest
    @Description
    public void close_Browser() throws InterruptedException {
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.getClass();
        }
        driver.quit();
    }
}
