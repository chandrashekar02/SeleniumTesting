package com.cskalyani.ex08_selenium_Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Table_test {
    public static void main(String[] args) {


        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        int row = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
        int col = driver.findElements(By.xpath("//table[@id='customers']//tr[2]//td")).size();

        for(int i=2; i<=row; i++){
            for(int j=1; j<=col; j++){
                WebElement valueElement = (driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]//td["+j+"]")));
                String value = valueElement.getText();
                System.out.print(value +"\t"+"|"+"\t");
                if(value.contains("Helen Bennett")){
                    String country_path ="//table[@id='customers']//tr["+i+"]//td["+j+"]/following-sibling::td";
                    String country = driver.findElement(By.xpath(country_path)).getText();
                    System.out.print("Helen Bennett country is"+country+"\t");
                }
            }
            System.out.println();
        }
        driver.quit();
    }
}
