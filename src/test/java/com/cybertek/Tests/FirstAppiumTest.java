package com.cybertek.Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class FirstAppiumTest {
    public AppiumDriver driver;

    @Test
    public void test(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Pixel 2_API_24");
        desiredCapabilities.setCapability("platform", "Android");
        desiredCapabilities.setCapability("platformVersion", "7.0");
        desiredCapabilities.setCapability("app", "/Users/soyturk/IdeaProjects/Job/AppiumDemo/etsy.apk");
        desiredCapabilities.setCapability("adbExecTimeout", "20000");
        try {
            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        } catch (Exception e) { e.printStackTrace();
        }
    }
}
