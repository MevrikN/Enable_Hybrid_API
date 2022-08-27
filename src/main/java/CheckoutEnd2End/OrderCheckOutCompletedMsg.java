package CheckoutEnd2End;

import Base_Pages.Utils;
import org.openqa.selenium.By;

public class OrderCheckOutCompletedMsg extends Utils {

    //Locators
    By _continueBtn = By.xpath("//button[@onclick='setLocation(\"/\")']");

    //Verify title
    public void verifyTitle() {
        titleOfPage().contains("successfully processed!");
    }

    //Continue Btn
    public void clickContinue() {
        driverClickOnElement(_continueBtn);
    }
}
