package org.challenge.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.challenge.app.BaseConfig;
import org.challenge.app.pages.MainPage;
import org.challenge.app.pages.register.RegisterPage;
import org.challenge.core.managers.driver.DriverManager;
import org.challenge.core.utils.Utils;
import org.challenge.core.utils.Wrapper;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class MyStepdefs extends ConfigSteps {

    static WebDriver driver;

    @Given("Restart driver {string}")
    public void restartDriver(String opt) throws IOException {
        try{
            if(BaseConfig.INICIATED == 0) {
                BaseConfig.INICIATED = 1;
                Wrapper.goToUrl(BaseConfig.getURl());
            }else {
                if (opt.equalsIgnoreCase("YES")) {
                    DriverManager.finish();
                    DriverManager.init();

                    Wrapper.goToUrl(BaseConfig.getURl());
                }
            }
        }catch (Exception | Error e){
            throw e;
        }

    }



    @When("User clicks on {string} button")
    public void userClicksOnButton(String button) throws Exception {
        try {
            //Get the instance of register page
            mainPage = MainPage.getInstance();

            //Click on the given button
            if(button.toUpperCase().equals("REGISTER"))
                mainPage.clickRegisterButton();

        }catch (Exception | Error e){
            throw e;
        }
    }

    @And("Set email {string}")
    public void setEmail(String email) throws Exception {
        try {

            if(email.toUpperCase().equals("RANDOM"))
                email = Utils.getRandomEmail();

            registerPage = RegisterPage.getInstance();

            //Set email
            registerPage.setEmail(email);
        }catch (Exception | Error e){
            throw e;
        }
    }

    @And("Set password {string}")
    public void setPassword(String password) throws Exception {

        try {

            registerPage = RegisterPage.getInstance();

            //Set password
            registerPage.setPassword(password);
        }catch (Exception | Error e){
            throw e;
        }
    }

    @And("Confirm password {string}")
    public void confirmPassword(String password) throws Exception {
        try {

            registerPage = RegisterPage.getInstance();

            //Set confirm password
            registerPage.setConfirmPassword(password);
        }catch (Exception | Error e){
            throw e;
        }
    }

    @And("Clicks to accept terms & conditions")
    public void clicksToAcceptTermsConditions() throws Exception {

        try {

            registerPage = RegisterPage.getInstance();

            //Set term and conditions
            registerPage.setTermsAndConditions();


        }catch (Exception | Error e){
            throw e;
        }
    }

    @And("Submit the user info")
    public void submitTheUserInfo() throws Exception {

        try {

            registerPage = RegisterPage.getInstance();

            //Click register button
            registerPage.submit();


        }catch (Exception | Error e){
            throw e;
        }
    }
}
