package com.cskalyani.ex09_selenium_Action;

import com.cskalyani.TestCaseBoilerPlate;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Action_class_Practice03 extends TestCaseBoilerPlate {

    @Test
    @Description("Verify that using keyboard able to select the value for From field")
    public void test_MakeMyTrip() throws InterruptedException {
        driver.get("https://www.makemytrip.com/?msockid=3f4fa965530d6a863229bcaa526f6b21");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //This will close the Modal
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='commonModal__close']")));
        modal.click();

        WebElement from = driver.findElement(By.id("fromCity"));

        Actions actions = new Actions(driver);
        actions.moveToElement(from).click().build().perform();
        Thread.sleep(2000);
        actions.sendKeys("ixg").build().perform();

        Thread.sleep(3000);
        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        try {
            for (WebElement listElement : list) {
                if (listElement.getText().contains("Belgaum")) {
                    wait.until(ExpectedConditions.elementToBeClickable(listElement)).click();
                }
            }
        }catch (Exception e){
            System.out.println(e.getClass());
        }

      //  actions.moveToElement(from).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).keyUp(Keys.ARROW_DOWN).build().perform();
    }
}
