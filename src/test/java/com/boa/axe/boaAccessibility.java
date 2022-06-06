package com.boa.axe;
//Developed by Sujit Palukuru (tarun.sujit@gmail.com)

import com.deque.axe.AXE;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.net.URL;
import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public  class boaAccessibility {

    private WebDriver driver;
    private static final URL scriptUrl = boaAccessibility.class.getResource("/axe.min.js");
    public Boolean runAXE= true;

    /**
     * Instantiate the WebDriver and navigate to the test site
     */
    @BeforeMethod
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // ChromeDriver needed to test for Shadow DOM testing support
       // driver = new ChromeDriver();
    }

    /**
     * Ensure we close the WebDriver after finishing
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    /**
     * Basic test
     */
    @Test
    public void testAccessibility() throws Exception {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://bankofamerica.com/online-banking/sign-in");
        Thread.sleep(5000);
        if(runAXE)
            runAxetool("Main Page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border='4px solid green'", driver.findElement(By.id("header-enroll-in-online-banking-button")));
        driver.findElement(By.id("header-enroll-in-online-banking-button")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(),"Enroll in Online & Mobile Banking");
        if(runAXE)
            runAxetool("Enroll Online Page");
        //driver.findElement(By.id("bacLogo")).click();
        driver.get("https://bankofamerica.com/online-banking/sign-in");
        Thread.sleep(4000);
        jsExecutor.executeScript("arguments[0].style.border='4px solid green'", driver.findElement(By.className("spa-circle-btn")));
        driver.findElement(By.className("spa-circle-btn")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//a[@searchquery='routing number ']")).click();
        Thread.sleep(8000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pa-icon circle-icon-search spa-circle-btn-icon"))).click();
        //driver.findElement(By.className("pa-icon circle-icon-search spa-circle-btn-icon")).click();
        jsExecutor.executeScript("arguments[0].style.border='4px solid green'",driver.findElement(By.id("viewAllSearchresults")));
        driver.findElement(By.id("viewAllSearchresults")).click();
        Thread.sleep(3000);
        if(runAXE)
            runAxetool("routing number page");
    }

    public void runAxetool(String page){
        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();
        JSONArray violations = responseJSON.getJSONArray("violations");
        if (violations.length() == 0) {
            assertTrue("No violations found", true);
        } else {
            AXE.writeResults("Accessibility Test", responseJSON);
            System.out.println("Page Name:  "+page);
            System.out.println(AXE.report(violations));
        }
    }

}
