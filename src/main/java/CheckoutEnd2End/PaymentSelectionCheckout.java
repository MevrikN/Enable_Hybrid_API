package CheckoutEnd2End;

import Base_Pages.Utils;
import org.openqa.selenium.By;

public class PaymentSelectionCheckout extends Utils {

    By _creditOption = By.id("paymentmethod_1");
    By _paymentpageContinuBtn = By.xpath("//button[@onclick='PaymentMethod.save()']");

    //Verify Url
    public void verifyUrl() {
        driverWaitUrl("https://demo.nopcommerce.com/onepagecheckout#opc-payment_method", 3);
    }

    //credit card
    public void clickOnCrediCard() {
        driverClickOnElement(_creditOption);
    }

    //Continue Btn
    public void clickContinueBtn() {
        driverClickOnElement(_paymentpageContinuBtn);
    }
}
