package com.cskalyani.ex06_selenium_katalon;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;

public class test_Katalon {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    @Description("Web Browser start")
    public void startBrowser() {
        //  WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        //URL = "https://katalon-demo-cura.herokuapp.com/";
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
    }

    public void wait(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @Test(priority = 1)
    @Description("Verify that the katalon My appointment is opened")
    public void test_Katalon_appointment() {
        driver.findElement(By.id("btn-make-appointment")).click();
        WebElement demoAcc = driver.findElement(By.xpath("//input[@aria-describedby='demo_username_label']"));
        String acc = demoAcc.getAttribute("value");
        driver.findElement(By.id("txt-username")).sendKeys(acc);

        WebElement demoPas = driver.findElement(By.xpath("//input[@aria-describedby='demo_password_label']"));
        String pas = demoPas.getAttribute("value");
        driver.findElement(By.id("txt-password")).sendKeys(pas);

        driver.findElement(By.id("btn-login")).click();
        //verify
        WebElement appointment = driver.findElement(By.xpath("//*[@class='col-sm-12 text-center']"));
        wait(appointment);
        String makeApp = appointment.getText();
        wait.until(ExpectedConditions.textToBePresentInElement(appointment, makeApp));
        Assert.assertEquals(makeApp, "Make Appointment");
    }

    @Test(priority = 2)
    @Description("Verify that the katalon make appointment is booked")
    public void test_Katalon_appointment_Booked() {
        Select sc = new Select(driver.findElement(By.id("combo_facility")));
        sc.selectByValue("Hongkong CURA Healthcare Center");
        //check box
        driver.findElement(By.id("chk_hospotal_readmission")).click();
        //radio button
        driver.findElement(By.id("radio_program_medicaid")).click();
        //driver.findElement(By.xpath("//div[@class='input-group-addon']")).click();

        driver.findElement(By.id("txt_visit_date")).sendKeys("15/06/2025");
        driver.findElement(By.id("btn-book-appointment")).click();
        WebElement application_Confirmation = driver.findElement(By.xpath("//*[@class='col-xs-12 text-center']/h2"));
        wait(application_Confirmation);
        String appConfirm = application_Confirmation.getText();
        Assert.assertEquals(appConfirm, "Appointment Confirmation");
    }

    @Test(priority = 3)
    @Description("Verify the logout from the page")
    public void logout(){
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.linkText("Logout")).click();
    }


    @AfterTest
    @Description("closing Browser")
    public void closeBrowser() {
        driver.quit();
    }


}
