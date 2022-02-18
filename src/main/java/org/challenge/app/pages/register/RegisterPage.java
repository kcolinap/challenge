package org.challenge.app.pages.register;

import org.challenge.app.components.SubmitButton;
import org.challenge.app.components.main.RegisterButton;
import org.challenge.app.components.register.RegistrationWidget;
import org.challenge.app.pages.BasePage;
import org.challenge.core.utils.Wrapper;


public class RegisterPage extends BasePage {

    private static RegisterPage sSoleInstance;

    //Import the components of register page
    private static RegistrationWidget registrationWidget;
    private static SubmitButton submitButton;

    /**this method is for implement singleton pattern
     * to avoid multple class instances of Register page
      * @return
     * @throws Exception
     */
    public synchronized static RegisterPage getInstance() throws Exception {
        if (sSoleInstance == null)
            sSoleInstance = new RegisterPage();


        //This method inicialized the components
        setComponents();

        //Wait until the given element is displayed
        wait.until(webDriver -> registrationWidget.isDisplayed());

        return sSoleInstance;
    }

    private static void setComponents() throws Exception {
        registrationWidget = RegistrationWidget.getInstance();
        submitButton = SubmitButton.getInstance();
    }


    public void setEmail(String email){
        Wrapper.setText(registrationWidget.getTxtEmail(),
                email);
    }

    public void setPassword(String pass){
        Wrapper.setText(registrationWidget.getTxtPassword(),
                pass);
    }

    public void setConfirmPassword(String pass){
        Wrapper.setText(registrationWidget.getTxtConfirmPassword(),
                pass);
    }

    public void setTermsAndConditions(){
        Wrapper.clickOnElement(registrationWidget.getChkTermsConditions());
    }

    public void submit(){
        Wrapper.clickOnElement(submitButton.getBtnSubmit());
    }



}
