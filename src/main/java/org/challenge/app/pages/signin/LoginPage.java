package org.challenge.app.pages.signin;

import org.challenge.app.components.SubmitButton;
import org.challenge.app.components.login.LoginWidget;
import org.challenge.app.components.register.RegistrationWidget;
import org.challenge.app.pages.BasePage;
import org.challenge.core.utils.Wrapper;


public class LoginPage extends BasePage {

    private static LoginPage sSoleInstance;

    public static String BLANK_USERNAME_ERROR = "Login cannot be blank.";
    public static String BLANK_PASSWORD_ERROR = "Password cannot be blank";

    //Import the components of login page
    private static LoginWidget loginWidget;
    private static SubmitButton submitButton;

    /**this method is for implement singleton pattern
     * to avoid multple class instances of Login page
      * @return
     * @throws Exception
     */
    public synchronized static LoginPage getInstance() throws Exception {
        if (sSoleInstance == null)
            sSoleInstance = new LoginPage();


        //This method inicialized the components
        setComponents();

        //Wait until the given element is displayed
        wait.until(webDriver -> loginWidget.isDisplayed());

        return sSoleInstance;
    }

    private static void setComponents() throws Exception {
        loginWidget = LoginWidget.getInstance();
        submitButton = SubmitButton.getInstance();
    }

    public void setUsername(String uName){
        Wrapper.setText(loginWidget.getTxtEmail(),
                uName);
    }

    public void setPassword(String pass){
        Wrapper.setText(loginWidget.getTxtPassword(),
                pass);
    }


    public void submit(){
        Wrapper.clickOnElement(submitButton.getBtnSubmit());
    }

    public LoginWidget getLoginWidget() {
        return loginWidget;
    }
}
