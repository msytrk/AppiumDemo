package com.cybertek.pages;

import com.cybertek.Utils.ConfigurationReader;
import com.cybertek.Utils.Driver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    private final static Logger logger = Logger.getLogger(ConfigurationReader.class);

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(id="com.etsy.android:id/btn_link")
    public AndroidElement getStartedElement;
}
