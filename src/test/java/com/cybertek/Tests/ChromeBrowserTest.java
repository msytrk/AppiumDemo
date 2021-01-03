package com.cybertek.Tests;

import com.cybertek.Utils.Log;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class ChromeBrowserTest {

    @Test
    public void test() throws Exception{
        //WebDriverManager.chromedriver().browserVersion("2.23").setup();

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //desiredCapabilities.setCapability("chromeDriverExecutable", WebDriverManager.chromedriver().getDownloadedVersion());

        WebDriver driver=new RemoteWebDriver((new URL("http://localhost:4723/wd/hub")),desiredCapabilities);
        driver.get("http://google.com");
        Log.info(driver.getTitle());
        Thread.sleep(3999);
        driver.quit();
    }
}
