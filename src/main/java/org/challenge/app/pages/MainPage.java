package org.challenge.app.pages;

import org.challenge.app.components.main.RegisterButton;
import org.challenge.app.components.main.SignInButton;
import org.challenge.core.utils.Wrapper;


public class MainPage extends BasePage {

    private static MainPage sSoleInstance;

    //Import the components of main page
    private static RegisterButton registerButton;
    private static SignInButton signInButton;

    /**this method is for implement singleton pattern
     * to avoid multple class instances of Register page
      * @return
     * @throws Exception
     */
    public synchronized static MainPage getInstance() throws Exception {
        if (sSoleInstance == null)
            sSoleInstance = new MainPage();


        //This method inicialized the components
        setComponents();

        //Wait until the given element is displayed
        wait.until(webDriver -> registerButton.isDisplayed());

        return sSoleInstance;
    }

    private static void setComponents() throws Exception {
        registerButton = RegisterButton.getInstance();
        signInButton = SignInButton.getInstance();
    }

    public void clickRegisterButton(){
        Wrapper.clickOnElement(registerButton.getBtnRegister());
    }

    public void clickSignButton(){
        Wrapper.clickOnElement(signInButton.getBtnSignIn());
    }


}
