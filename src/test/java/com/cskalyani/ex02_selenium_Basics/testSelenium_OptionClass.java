package com.cskalyani.ex02_selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class testSelenium_OptionClass {

    @Test
    public void test_OptionClass(){

        ChromeOptions chromeOptions = new ChromeOptions();
        //FirfoxOptions, EdgeOptions, SafariOptions

        //window size
      //  chromeOptions.addArguments("--window-size=1280,720");
       // chromeOptions.addArguments("--window-size=800,600");
       // chromeOptions.addArguments("--incognito");
       // chromeOptions.addArguments("--start-maximized");     //window maximaize
       // chromeOptions.addArguments("--headless");           //it will execute without opening the browser


        WebDriver driver = new ChromeDriver(chromeOptions);
    }
}
