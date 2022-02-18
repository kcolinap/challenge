package org.challenge.app.components;

import org.challenge.core.utils.Wrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubmitButton extends AbstractComponent {

    protected static SubmitButton sSoleInstance;

    @FindBy(xpath = "//*[@data-test='control-submit']")
    private WebElement btnSubmit;



    public SubmitButton(){
        super();
    }

    public synchronized static SubmitButton getInstance() throws Exception {

        if (sSoleInstance == null)
            sSoleInstance = new SubmitButton();
        else
            Wrapper.init_elements(sSoleInstance);

        return sSoleInstance;
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(webDriver -> btnSubmit.isDisplayed());
    }


    public WebElement getBtnSubmit() {
        return btnSubmit;
    }
}
