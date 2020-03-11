package com.automation.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TitleVerification3 {
    public static void main(String[] args) {


        List<String> urls = Arrays.asList("https://luluandgeorgia.com", "https://wayfair.com", "https://walmart.com", "https://westelm.com");

        titleVerificationMethod(urls);
        titleVerificationMethod2(urls);
    }

    static void titleVerificationMethod(List<String> list) {

        List<String> listOfBrowsers = Arrays.asList("chrome", "firefox", "edge");

        for (String eachBrowsers : listOfBrowsers) {

            WebDriver driver = BrowserFactory.getDriver(eachBrowsers);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(listOfBrowsers);

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
    }


    static void titleVerificationMethod2(List<String> list) {

        List<String> listOfBrowsers = Arrays.asList("chrome", "firefox", "edge");

        for (String eachBrowsers : listOfBrowsers) {

            WebDriver driver = BrowserFactory.getDriver(eachBrowsers);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(listOfBrowsers);

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
}
