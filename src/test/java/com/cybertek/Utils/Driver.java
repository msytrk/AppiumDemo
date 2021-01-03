package com.cybertek.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static AppiumDriver<MobileElement> driver;
    private static DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
    private final static String ANDROID_APP_URL=ConfigurationReader.get("android.app");



    public Driver() {
    }

    public static  AppiumDriver<MobileElement> getDriver(){
        if(driver==null){
            String platfrom=ConfigurationReader.get("platform");
            System.out.println(platfrom);
            Log.info("Test is running on "+ platfrom );

            switch(platfrom)
            {
                case "android":

                    desiredCapabilities.setCapability("app", ANDROID_APP_URL);
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
                    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    try {
                        driver=new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    Log.error("Driver type is not implemented yet");
                    throw new RuntimeException("Driver type is not implemented yet");

            }

    }
    return driver;
}}
