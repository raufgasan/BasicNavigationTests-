package com.automation.utilities;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TitleVerification {

    /*
    1.Create a new class TitleVerification under utilitiespackageand create a main method.
    2.Add this ArrayList declaration to the main method: List<String> urls = Arrays.asList("http://practice.cybertekschool.com/", "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");
    3.Open chrome browser
    4.Visit all the websitesfrom step 3and verify that they all have the same title.
    5.Verify that all URLsof all pages start with http://practice.cybertekschool.com.
    6.Close the browser at the end of the test.
    */
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/", "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");
        TitleVerificationMethod(urls);

    }

    static void TitleVerificationMethod(List<String> list) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        HashSet<String> title = new HashSet<>();
        HashSet<String> urls = new HashSet<>(Arrays.asList("http://practice.cybertekschool.com"));


        for (String eachUrls : list) {
            driver.get(eachUrls);
            title.add(driver.getTitle());
            if (!eachUrls.startsWith("http://practice.cybertekschool.com")) {
                urls.add(eachUrls);
            }
        }

        if (title.size() == 1) {
            System.out.println("PASS");
            System.out.println("They All Have The Same Title");
        } else {
            System.out.println("Titles Are Different");
            System.out.println(title);
        }

        if (urls.size() == 1) {
            System.out.println("PASS");
            System.out.println("They All Start With the Same URL");
        } else {
            System.out.println("URLs Are Different");
            System.out.println(urls);
        }

        driver.quit();
    }
}
