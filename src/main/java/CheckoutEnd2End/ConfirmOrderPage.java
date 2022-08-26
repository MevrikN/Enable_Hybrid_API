package CheckoutEnd2End;

import Base_Pages.Utils;
import org.openqa.selenium.By;

public class ConfirmOrderPage extends Utils {


    By _emailID = By.xpath("//div[@class='billing-info']//li[@class='email']");
    By _continueBtn = By.xpath("//button[contains(text(),'Confirm')]");

    //Verify current URL
    public void verifyUrl() {
        driverWaitUrl("https://demo.nopcommerce.com/onepagecheckout#opc-confirm_order", 3);
    }

    //Get Email Address
    public void getEmailId() {
        String email = gettext(_emailID).substring(7);
        System.out.println(email);
    }

    //Continue Btn
    public void clickContinueBtn() {
        driverClickOnElement(_continueBtn);
    }
}
