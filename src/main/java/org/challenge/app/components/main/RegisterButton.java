package org.challenge.app.components.main;

import org.challenge.app.components.AbstractComponent;
import org.challenge.core.utils.Wrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class RegisterButton extends AbstractComponent {

    protected static RegisterButton sSoleInstance;

   @FindBy(xpath = "//span[contains(text(), 'Registration')]")
   private WebElement btnRegister;


    public RegisterButton(){
        super();
    }

    public synchronized static RegisterButton getInstance() throws Exception {

        if (sSoleInstance == null)
            sSoleInstance = new RegisterButton();
        else
            Wrapper.init_elements(sSoleInstance);

        return sSoleInstance;
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(webDriver -> btnRegister.isDisplayed());
    }

    public WebElement getBtnRegister() {
        return btnRegister;
    }
}
