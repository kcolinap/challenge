package org.challenge.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.challenge.app.BaseConfig;
import org.challenge.app.pages.MainPage;
import org.challenge.app.pages.register.RegisterPage;
import org.challenge.app.pages.signin.LoginPage;
import org.challenge.core.managers.driver.DriverManager;
import org.challenge.core.utils.Utils;
import org.challenge.core.utils.Wrapper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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

            if(!button.equals("")){
                //Get the instance of register page
                mainPage = MainPage.getInstance();

                //Click on the given button
                if(button.toUpperCase().equals("REGISTER"))
                    mainPage.clickRegisterButton();
                else if(button.toUpperCase().equals("SIGNIN"))
                    mainPage.clickSignButton();
            }


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

    @And("Submit the user info at page {string}")
    public void submitTheUserInfo(String page) throws Exception {

        try {

            if(page.toUpperCase().equals("REGISTER")) {
                registerPage = RegisterPage.getInstance();

                //Click register button
                registerPage.submit();
            }else if(page.toUpperCase().equals("SIGNIN")){
                loginPage = LoginPage.getInstance();

                //Click signin
                loginPage.submit();
            }


        }catch (Exception | Error e){
            throw e;
        }
    }

    @When("User set username {string}")
    public void userSetUsername(String uName) throws Exception {
        try {

           //Set username
            loginPage = LoginPage.getInstance();

            loginPage.setUsername(uName);


        }catch (Exception | Error e){
            throw e;
        }
    }

    @And("User set password {string}")
    public void userSetPassword(String pass) throws Exception {
        try {

            //Set username
            loginPage = LoginPage.getInstance();

            loginPage.setPassword(pass);


        }catch (Exception | Error e){
            throw e;
        }
    }

    @Then("Validate result {string}")
    public void validateResult(String result) throws Exception {

        try {

            //Get login page instance
            loginPage = LoginPage.getInstance();

            //Validate expected result
            switch (result.toUpperCase()){
                case "BLANK_USERNAME":
                    Wrapper.waitForElementBeDisplayed(loginPage.getLoginWidget().getLblUsernameError());
                    Assert.assertEquals(Wrapper.getElementText(loginPage.getLoginWidget().getLblUsernameError()),
                            LoginPage.BLANK_USERNAME_ERROR);
                    break;
                case "BLANK_PASSWORD":
                    Wrapper.waitForElementBeDisplayed(loginPage.getLoginWidget().getLblPasswordError());
                    Assert.assertEquals(Wrapper.getElementText(loginPage.getLoginWidget().getLblPasswordError()),
                            LoginPage.BLANK_PASSWORD_ERROR);
                    break;
                case "BLANK_CREDENTIALS":
                    Wrapper.waitForElementBeDisplayed(loginPage.getLoginWidget().getLblPasswordError());

                    //Asserts
                    Assert.assertEquals(Wrapper.getElementText(loginPage.getLoginWidget().getLblPasswordError()),
                            LoginPage.BLANK_PASSWORD_ERROR);
                    Assert.assertEquals(Wrapper.getElementText(loginPage.getLoginWidget().getLblUsernameError()),
                            LoginPage.BLANK_USERNAME_ERROR);
                    break;
            }


        }catch (Exception | Error e){
            throw e;
        }
    }
}
