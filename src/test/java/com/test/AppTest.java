package com.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class AppTest {

    @Test
    public void test_login_with_incorrect_credentials() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("http://103.139.122.250:4000/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("email")).sendKeys("qasim@malik.com");
        driver.findElement(By.id("password")).sendKeys("abcdefg");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String errorText = driver.findElement(By.tagName("body")).getText();
        assert(errorText.contains("Invalid") || errorText.contains("incorrect") || errorText.contains("wrong") || errorText.contains("error"));

        driver.quit();
    }
}
