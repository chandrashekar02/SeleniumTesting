package com.cskalyani.ex02_selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class testSelenium_AddExtension {

    public void addExtension(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("add downloaded extension path");
        //Download the extension and keep it in IntelliJ

        WebDriver driver = new EdgeDriver();


    }
}
