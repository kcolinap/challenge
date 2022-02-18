package org.challenge.app.components.register;

import org.challenge.app.components.AbstractComponent;
import org.challenge.core.utils.Wrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationWidget extends AbstractComponent {

    protected static RegistrationWidget sSoleInstance;

   @FindBy(xpath = "//*[@data-test='input-email']")
   private WebElement txtEmail;

    @FindBy(xpath = "//*[@data-test='input-password']")
    private WebElement txtPassword;

    @FindBy(xpath = "//*[@data-test='input-password_confirmation']")
    private WebElement txtConfirmPassword;

    @FindBy(xpath = "//*[@data-test='input-terms_and_conditions']/../label")
    private WebElement chkTermsConditions;

    @FindBy(xpath = "//*[@data-test='input-captcha']")
    private WebElement txtCaptcha;



    public RegistrationWidget(){
        super();
    }

    public synchronized static RegistrationWidget getInstance() throws Exception {

        if (sSoleInstance == null)
            sSoleInstance = new RegistrationWidget();
        else
            Wrapper.init_elements(sSoleInstance);

        return sSoleInstance;
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(webDriver -> txtEmail.isDisplayed());
    }

    public WebElement getTxtEmail() {
        return txtEmail;
    }

    public WebElement getTxtPassword() {
        return txtPassword;
    }

    public WebElement getTxtConfirmPassword() {
        return txtConfirmPassword;
    }

    public WebElement getChkTermsConditions() {
        return chkTermsConditions;
    }

    public WebElement getTxtCaptcha() {
        return txtCaptcha;
    }

}
