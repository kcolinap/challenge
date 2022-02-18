package org.challenge.core.utils;

import io.cucumber.messages.internal.com.google.common.util.concurrent.Uninterruptibles;
import org.challenge.core.managers.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Wrapper {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    public static void init_elements(Object pageClass){

        setLocalDriver();
        PageFactory.initElements(driver, pageClass);
    }

    private static void setLocalDriver(){

        driver = DriverManager.getDriver();
        wait = DriverManager.getWait();
    }

    private static void setAction(){
        if(action!=null)
            action = null;

        action = new Actions(driver);
    }


    /**
     * Got to the given URl
     * @param url
     */
    public static void goToUrl(String url){
        setLocalDriver();
        driver.get(url);

    }

    public static boolean elementIsDisplayed(WebElement element){
        try{
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }

    }

    /**
     * Perform mouseOver an click on the given element
     * @param elem: Elemnt to be clicked
     */
    public static void clickOnElement(WebElement elem){
        setLocalDriver();
        setAction();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        action.moveToElement(elem).click().build().perform();
    }

    /**
     * Perform mouseOver on the given element
     * @param elem: Elemnt to be focus
     */
    public static void hoverOnElement(WebElement elem){
        setLocalDriver();
        setAction();

       // WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        action.moveToElement(elem).build().perform();
    }

    /**
     * Set text via SendKeys
     * @param  text: Text to be setted
     * @param element:Element to set
     */
    public static void setText(WebElement element, String text){
        element.clear();

        for(char character : text.toCharArray() ){
            element.sendKeys(String.valueOf(character));
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.MILLISECONDS);
        }

    }

    /**
     * Select an item from select element
     * @param  type: kind of attribute to select
     * @param select: Element to select(list of values)
     * @param text: Value to select on the list
     */
    public static void selectBy(Select select, String type, String text){
       if(type.toUpperCase().equals("VALUE"))
           select.selectByValue(text);
       else if(type.toUpperCase().equals("VISIBLE_TEXT"))
           select.selectByVisibleText(text);
    }

    /**
     * GET TEXT FROM A ELEMENT
     * @param elem: Element to obtain the text attribute
     * return: A string
     */
    public static String getElementText(WebElement elem){
        String text;
        do{
            text = elem.getText();
        }while (text.equals(""));

        return elem.getText();
    }

    /**
     * GET ATRIBUTE FROM A ELEMENT
     * @param elem: Element to obtain the attribute
     * return: Attribute requested as string
     */
    public static String getElementAttribute(WebElement elem, String attribute){

        return elem.getAttribute(attribute);
    }

    public static void waitForElementBeDisplayed(WebElement element){
        setLocalDriver();
        wait.until(webDriver -> element.isDisplayed());
    }
}
