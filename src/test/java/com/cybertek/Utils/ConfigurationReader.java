package com.cybertek.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    static {

        try {
            FileInputStream input = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

    public static void main(String[] args) {
        System.out.println("ConfigurationReader.get(\"paltform\") = " + ConfigurationReader.get("android.app"));

    }

}
