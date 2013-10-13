package com.perevillega.eia;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class IndexPageIT extends AbstractIT {

    @FindBy(css = "input[name='save']")
    private WebElement createUserButton;

    @FindBy(css = "input[id='name']")
    private WebElement nameInput;

    @Test
    public void weSeeHelloMessage() {
        getDrv().get(getSiteBase().toString());

        nameInput.sendKeys("test");
        createUserButton.click();

        assertTrue(getDrv().getPageSource().contains("test"));
    }


}

