package com.automation.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TitleVerification2 {

    /*
    1.Create a new class TitleVerification2under utilities packageand create a main method.
    2.Add this ArrayList declaration to the main method:
    List<String> urls = Arrays.asList("https://lulugandgeorgia.com", "https://wayfair.com/", "https://walmart.com, "https://westelm.com/");
    3.Visit all websites one by one.
    4.Verify that URLof the website contains the title of the website.Ignore spacesand casein comparison.
    For example,title of in the first websitetitle is Lulu and Giorgiaand the URLis https://lulugandgeorgia.com. So,this test case must pass.
    5.Close the browser at theendof the test.
    */
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com", "https://wayfair.com", "https://walmart.com", "https://westelm.com");

        titleVerificationMethod(urls);       //checking if the URL contains title: One true
        titleVerificationMethod2(urls);     //checking if the title contains URL: All true
    }

    static void titleVerificationMethod(List<String> list) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        for (String eachUrls : list) {
            driver.get(eachUrls);
            String title = driver.getTitle();
            if (eachUrls.contains(title.replaceAll(" ", "").toLowerCase())) {
                System.out.println("PASS");
                System.out.println(title);
                System.out.println(eachUrls);
            } else {
                System.out.println("FALLS");
                System.out.println(title);
                System.out.println(eachUrls);
            }
        }
        driver.quit();
    }


    static void titleVerificationMethod2(List<String> list) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        for (String eachUrls : list) {
            driver.get(eachUrls);
            eachUrls = eachUrls.substring(eachUrls.indexOf("//") + 2, eachUrls.indexOf(".com"));
            String title = driver.getTitle();
            if (title.replaceAll(" ", "").toLowerCase().contains(eachUrls)) {
                System.out.println("PASS");
                System.out.println(title);
                System.out.println(eachUrls);
            } else {
                System.out.println("FALLS");
                System.out.println(title);
                System.out.println(eachUrls);
            }
        }
        driver.quit();
    }
}
