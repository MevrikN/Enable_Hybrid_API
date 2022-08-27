package RegistartionProcess;

import Base_Pages.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyRegisterSuccess extends Utils {

    //Locators
    By _getResult = By.className("result");
    By _clickContinueBtn = By.xpath("//a[contains(text(),\"Continue\")]");

    //Result verification for Registration
    public void verifyRegistrationSuccess() {
        String actual = gettext(_getResult);
        String expected = "Your registration completed";
        Assert.assertEquals(actual, expected, "Registration is not success full");
    }

    //Continue Btn
    public void clickOnContinue() {
        driverWaitsUntilClick(_clickContinueBtn, 5);
    }
}
