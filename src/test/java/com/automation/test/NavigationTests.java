package com.automation.test;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.StringUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class NavigationTests {
    public static void main(String[] args) {


        Chrom();
        FireFox();
        EdgeBrowser();


    }

    static void Chrom(){
        WebDriver driverChrom = BrowserFactory.getDriver("chrome");
        driverChrom.get("https://google.com");
        driverChrom.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String titleGoogle = driverChrom.getTitle();
        driverChrom.navigate().to("https://etsy.com");
        String titleEtsy = driverChrom.getTitle();
        driverChrom.navigate().back();
        StringUtility.verifyEquals(titleGoogle, driverChrom.getTitle());
        driverChrom.navigate().forward();
        StringUtility.verifyEquals(titleEtsy, driverChrom.getTitle());
        driverChrom.quit();
    }
    static void FireFox(){
        WebDriver driverFireFox= BrowserFactory.getDriver("firefox");
        driverFireFox.get("https://google.com");
        driverFireFox.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String titleGoogle = driverFireFox.getTitle();
        driverFireFox.navigate().to("https://etsy.com");
        String titleEtsy = driverFireFox.getTitle();
        driverFireFox.navigate().back();
        StringUtility.verifyEquals(titleGoogle, driverFireFox.getTitle());
        driverFireFox.navigate().forward();
        StringUtility.verifyEquals(titleEtsy, driverFireFox.getTitle());
        driverFireFox.quit();
    }

    static void EdgeBrowser(){
        WebDriver driverEdge = BrowserFactory.getDriver("edge");
        driverEdge.get("https://google.com");
        driverEdge.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String titleGoogle = driverEdge.getTitle();
        driverEdge.navigate().to("https://etsy.com");
        String titleEtsy = driverEdge.getTitle();
        driverEdge.navigate().back();
        StringUtility.verifyEquals(titleGoogle, driverEdge.getTitle());
        driverEdge.navigate().forward();
        StringUtility.verifyEquals(titleEtsy, driverEdge.getTitle());
        driverEdge.quit();

    }

}
