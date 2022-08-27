package CheckoutEnd2End;

import Base_Pages.Utils;
import org.openqa.selenium.By;

public class ShippingPage extends Utils {

    //Locators
    By _shippingIdNextDay = By.id("shippingoption_1");
    By _shippingIdSecondDay = By.id("shippingoption_2");
    By _continueBtn = By.xpath("//button[@onclick='ShippingMethod.save()']");

    //Verify url
    public void verifyUrl() {
        driverWaitUrl("https://demo.nopcommerce.com/onepagecheckout#opc-shipping_method", 3);
    }

    //Shipping type
    public void selectRadioOneDay() {
        driverClickOnElement(_shippingIdNextDay);
    }

    //Radio Btn second Day
    public void selectRadioSecond() {
        driverClickOnElement(_shippingIdSecondDay);
    }

    //Click on Continue
    public void continueBtn() {
        driverClickOnElement(_continueBtn);
    }

}
