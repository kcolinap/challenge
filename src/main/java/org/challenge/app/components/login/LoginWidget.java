package org.challenge.app.components.login;

import org.challenge.app.components.AbstractComponent;
import org.challenge.core.utils.Wrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginWidget extends AbstractComponent {

    protected static LoginWidget sSoleInstance;

   @FindBy(css = "input#UserLogin_username")
   private WebElement txtEmail;

    @FindBy(css = "input#UserLogin_password")
    private WebElement txtPassword;

    @FindBy(css = "input#UserLogin_verifyCode")
    private WebElement txtCaptcha;

    @FindBy(xpath = "//*[@data-test='error-username']")
    private WebElement lblUsernameError;

    @FindBy(xpath = "//*[@data-test='error-password']")
    private WebElement lblPasswordError;

    public LoginWidget(){
        super();
    }

    public synchronized static LoginWidget getInstance() throws Exception {

        if (sSoleInstance == null)
            sSoleInstance = new LoginWidget();
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

    public WebElement getTxtCaptcha() {
        return txtCaptcha;
    }

    public WebElement getLblUsernameError() {
        return lblUsernameError;
    }

    public WebElement getLblPasswordError() {
        return lblPasswordError;
    }
}
