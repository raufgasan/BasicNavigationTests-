package com.automation.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StringUtility {

    public static void verifyEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected :" + expected);
            System.out.println("Actual : " + actual);
        }
    }


}
