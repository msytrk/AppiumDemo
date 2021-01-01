package com.cybertek.Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
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

        System.out.println("Test is passed");

    }
}
