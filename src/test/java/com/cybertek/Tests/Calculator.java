package com.cybertek.Tests;

import com.cybertek.Utils.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.logging.Logger;

public class Calculator {

    AndroidDriver<AndroidElement> driver;



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

        Log.info("Test 1 from Appium");

    AndroidElement btn2= driver.findElementById("com.android.calculator2:id/digit_2");
    AndroidElement equals=  driver.findElementByAccessibilityId("equals");
    AndroidElement plus= driver.findElementByAccessibilityId("plus");
    AndroidElement result= driver.findElementById("com.android.calculator2:id/result");

        btn2.click(); // 2
        plus.click(); // +
        btn2.click(); // 2
        equals.click(); // =

        String actualResult = result.getText();
        // To verify it
        System.out.println(actualResult);
        Assert.assertEquals("4",actualResult);

   }

   @Test
   public void test2(){
       MobileElement btn7 =driver.findElement(MobileBy.id("com.android.calculator2:id/digit_7"));
       MobileElement btn8 =driver.findElement(MobileBy.id("com.android.calculator2:id/digit_8"));
       MobileElement plus =driver.findElement(MobileBy.AccessibilityId("plus"));
       MobileElement equals =driver.findElement(MobileBy.AccessibilityId("equals"));
       MobileElement result= driver.findElement(MobileBy.id("com.android.calculator2:id/result"));
       TouchAction touchActions=new TouchAction(driver);


       /*btn7.click(); // 7
       plus.click(); // +
       btn8.click(); // 8
       equals.click(); // =*/


       String actualResult = result.getText();
       // To verify it
       System.out.println(actualResult);
       Log.info(actualResult);
       Assert.assertEquals("15",actualResult);

   }

   @After
    public void tearDown(){

        driver.closeApp();
   }
}
