package org.challenge.core.managers.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.challenge.core.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.function.Supplier;

/**
 * This class return a driver instance of the type
 * given at:
 * {@link DriverManager#init()}
 */
public class DriverFactory {

    private static final HashMap<String, Supplier<WebDriver>> mapDriver = new HashMap<>();

    /**
     * CHROMEDRIVER
     */
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chrOptions = new ChromeOptions();

        chrOptions.addArguments("--no-sandbox");
        chrOptions.addArguments("window-size=1920x1080");
        chrOptions.addArguments("--disable-dev-shm-usage");
        chrOptions.addArguments("start-maximized");

        try {
            if(Utils.getProperty("headless_mode","settings").equals("1"))
                chrOptions.addArguments("--headless");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ChromeDriver(chrOptions);
    };

    static {
        mapDriver.put("CHROME", chromeDriverSupplier);
    }

    //Return a webDriver instance
    public static WebDriver getDriver(String browser){
        return mapDriver.get(browser).get();
    }

}
