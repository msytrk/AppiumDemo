package com.cybertek.pages;

import com.cybertek.Utils.ConfigurationReader;
import com.cybertek.Utils.Log;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

    @AndroidFindBy(id="com.etsy.android:id/edit_username")
    public AndroidElement emailElement;

    @AndroidFindBy(id="com.etsy.android:id/edit_password")
    public AndroidElement passwordElement;

    @AndroidFindBy(id="com.etsy.android:id/button_signin")
    public AndroidElement signInButtonElement;

    public void login(){


        String email= ConfigurationReader.get("email");
        String password= ConfigurationReader.get("password");
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        signInButtonElement.click();
        Log.info("Logging with username" + email);


    }


}
