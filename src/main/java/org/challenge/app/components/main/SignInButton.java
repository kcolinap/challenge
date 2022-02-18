package org.challenge.app.components.main;

import org.challenge.app.components.AbstractComponent;
import org.challenge.core.utils.Wrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInButton extends AbstractComponent {

    protected static SignInButton sSoleInstance;

   @FindBy(xpath = "//a[@data-test='nav-login-head']")
   private WebElement btnSignIn;


    public SignInButton(){
        super();
    }

    public synchronized static SignInButton getInstance() throws Exception {

        if (sSoleInstance == null)
            sSoleInstance = new SignInButton();
        else
            Wrapper.init_elements(sSoleInstance);

        return sSoleInstance;
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(webDriver -> btnSignIn.isDisplayed());
    }

    public WebElement getBtnSignIn() {
        return btnSignIn;
    }
}
