package CheckoutEnd2End;

import Base_Pages.Utils;
import org.openqa.selenium.By;

public class CreditCardDetails extends Utils {

    By _cardType = By.id("CreditCardType");
    By _cardHolderName = By.id("CardholderName");
    By _cardNumb = By.id("CardNumber");
    By _expMonth = By.id("ExpireMonth");
    By _expYear = By.id("ExpireYear");
    By _cvcNumb = By.name("CardCode");
    By _continue = By.xpath("//button[@onclick='PaymentInfo.save()']");

    //Verify URL
    public void verifyUrl() {
        driverWaitUrl("https://demo.nopcommerce.com/onepagecheckout#opc-payment_info", 3);
    }

    //Card Type
    public void selectCardType(String gatWayType) {
        selectByVisibleText(_cardType, gatWayType);
    }

    //Cardholder Name
    public void carHolderName(String name) {
        driverSendKeys(_cardHolderName, name);
    }

    //Card Number
    public void cardNumber(String cardNumb) {
        driverSendKeys(_cardNumb, cardNumb);
    }

    //expiry Date and year
    public void expDateYear(String month, String year) {
        selectByVisibleText(_expMonth, month);
        selectByVisibleText(_expYear, year);
    }

    //cvc number
    public void cvcNumber(String cvcNum) {
        driverSendKeys(_cvcNumb, cvcNum);
    }

    //Continue Btn
    public void continueBtn() {
        driverClickOnElement(_continue);
    }
}