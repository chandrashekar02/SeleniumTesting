package com.cskalyani.ex09_selenium_Action;

import com.cskalyani.TestCaseBoilerPlate;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Action_class_Scroll extends TestCaseBoilerPlate {

    @Test
    public void test_scrollbar(){
        driver.get("https://www.tutorialspoint.com/how-to-scroll-down-a-webpage-in-selenium-using-java");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
    }

}
