package org.challenge.app.pages;

import org.challenge.core.managers.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected static WebDriverWait wait = DriverManager.getWait();
    protected static WebDriver driver = DriverManager.getDriver();

    public abstract String validatePageTitle();
    protected static void setComponents(Object page){
        PageFactory.initElements(driver, page);
    }
}
