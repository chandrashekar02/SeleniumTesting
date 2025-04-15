package com.cskalyani.ex09_selenium_Action;

import com.cskalyani.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Action_class_FileUpload extends TestCaseBoilerPlate {

    @Test
    public void test_FileUpload(){
        //only 1 type of file upload is support. i.e, <input type="file"
        driver.get("https://awesomeqa.com/selenium/upload.html");

        String working_dir = System.getProperty("user.dir");    //file upload
        WebElement file_upload = driver.findElement(By.id("fileToUpload"));
        file_upload.sendKeys(working_dir+"/src/test/java/com/cskalyani/ex09_selenium_Action/test.xtx");
        driver.findElement(By.xpath("//*[@name='submit']")).click();
    }
}
