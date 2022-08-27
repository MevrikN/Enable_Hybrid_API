package CheckoutEnd2End;

import Base_Pages.Utils;
import org.openqa.selenium.By;

public class CheckOutBillingAddress extends Utils {

    //Locators
    By _countrySelect = By.id("BillingNewAddress_CountryId");
    By _cityName = By.id("BillingNewAddress_City");
    By _address1 = By.id("BillingNewAddress_Address1");
    By _zipCode = By.id("BillingNewAddress_ZipPostalCode");
    By _phoneNumb = By.id("BillingNewAddress_PhoneNumber");
    By _continueBtn = By.xpath("//div[@id='billing-buttons-container']//button[contains(text(),\"Continue\")]");

    //Select country
    public void selectCountry(String country) {
        selectByVisibleText(_countrySelect, country);
    }

    //Verify URL
    public void verifyUrl() {
        driverWaitUrlToBe("https://demo.nopcommerce.com/onepagecheckout#opc-billing", 3);
    }

    //City name
    public void cityName(String city) {
        driverSendKeys(_cityName, city);
    }

    //Address1
    public void address1(String address) {
        driverSendKeys(_address1, address);
    }

    //Zipcode
    public void zipCode(String zipCode) {
        driverSendKeys(_zipCode, zipCode);
    }

    //Phone number
    public void phoneNum(String number) {
        driverSendKeys(_phoneNumb, number);
    }

    //Continue Btn
    public void continueBtn() {
        driverClickOnElement(_continueBtn);
    }
}
