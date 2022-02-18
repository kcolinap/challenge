package org.challenge.app.components;

import org.challenge.core.managers.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public AbstractComponent(){

        driver = DriverManager.getDriver();
        wait = DriverManager.getWait();
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isDisplayed();
}
