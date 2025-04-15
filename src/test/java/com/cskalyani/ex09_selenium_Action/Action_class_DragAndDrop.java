package com.cskalyani.ex09_selenium_Action;

import com.cskalyani.TestCaseBoilerPlate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Action_class_DragAndDrop extends TestCaseBoilerPlate {

    @Test
    public void test_DragAndDrop(){
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement a = driver.findElement(By.id("column-a"));
        WebElement b = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(a,b).build().perform();
    }
}
