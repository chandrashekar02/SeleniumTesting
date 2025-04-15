package com.cskalyani.ex09_selenium_Action;

import com.cskalyani.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Action_Class_Practice02 extends TestCaseBoilerPlate {

    @Test
    public void mouse_Action(){
        driver.get("https://www.spicejet.com/");

        WebElement from = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']//input[@autocapitalize='sentences']"));
        WebElement to = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']//input[@autocapitalize='sentences']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(from).click().sendKeys("del").build().perform();
        actions.moveToElement(to).click().sendKeys("Blr").build().perform();

    }


}
