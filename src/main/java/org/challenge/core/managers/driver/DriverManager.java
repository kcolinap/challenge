package org.challenge.core.managers.driver;

import io.cucumber.messages.internal.com.google.common.util.concurrent.Uninterruptibles;
import org.challenge.core.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver driver;
    private static WebDriverWait wait;


    public static void init() throws IOException {


        driver = DriverFactory.getDriver(Utils.getProperty("browser", "settings").toUpperCase());
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public static void finish() throws IOException {


        if(driver!=null){
            driver.close();
            driver.quit();
            driver = null;
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        }

    }

    public static void close() throws IOException {

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);

        if(driver!=null){
            driver.close();
        }

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}
