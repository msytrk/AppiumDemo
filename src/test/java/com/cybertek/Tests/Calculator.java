package com.cybertek.Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Calculator {

    AndroidDriver<WebElement> driver;
    @Before
    public  void setup(){
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        // CapabilityType.PLATFORM_NAME=="platformName"
        // MobileCapabilityType.AUTOMATION_NAME=="automationName";
        // appiumServer Address -- new URL("http://0.0.0.0:4723/wd/hub")
        desiredCapabilities.setCapability("deviceName", "Pixel_2");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("platformVersion", "7.0");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("newCommandTimeout", "7200");
        try {
            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        } catch (Exception e) { e.printStackTrace();
        }
    }


    @Test
    public void test1(){

    AndroidElement btn2= (AndroidElement) driver.findElementById("com.android.calculator2:id/digit_2");
    AndroidElement equals= (AndroidElement) driver.findElementByAccessibilityId("equals");
    AndroidElement plus= (AndroidElement) driver.findElementByAccessibilityId("plus");
    AndroidElement result= (AndroidElement) driver.findElementById("com.android.calculator2:id/result");

        btn2.click();
        plus.click();
        btn2.click();
        equals.click();

        String actualResult = result.getText();
        // To verify it
        System.out.println(actualResult);
        Assert.assertEquals("4",actualResult);

   }

   @After
    public void tearDown(){

        driver.closeApp();
   }
}
