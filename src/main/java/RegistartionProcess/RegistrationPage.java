package RegistartionProcess;

import Base_Pages.LoadProp;
import Base_Pages.Utils;
import org.openqa.selenium.By;

public class RegistrationPage extends Utils {

    By _radioMaleRegister = By.id("gender-male");
    By _firstNameField = By.xpath("//input[@name='FirstName']");
    By _lastnameField = By.id("LastName");
    By _birthdate = By.name("DateOfBirthDay");
    By _birthMonth = By.name("DateOfBirthMonth");
    By _birthYear = By.name("DateOfBirthYear");
    By _emailAddress = By.id("Email");
    By _passwordField = By.id("Password");
    By _confPassword = By.id("ConfirmPassword");
    By _clickOnRegister = By.id("register-button");
    LoadProp loadProp = new LoadProp();


    //Verify the URL
    public void verifyRegistrationPageURL() {
        driverWaitUrl("https://demo.nopcommerce.com/register?returnUrl=%2F", 5);
    }

    //Radio button
    public void radioBtn() {
        driverClickOnElement(_radioMaleRegister, 5);

    }

    //First Name
    public void firstName(String firstname) {
        driverSendKeys((_firstNameField), firstname);
    }

    //Last Name
    public void lastName(String lastname) {
        driverSendKeys(_lastnameField, lastname);
    }

    //Email Address
    public void set_emailAddress(String firstpart) {
        //Printout Time
        driverSendKeys(_emailAddress, firstpart + rendomdate() + "@gmail.com");
        System.out.println(rendomdate());
    }

    //Password
    public void set_passwordField(String password) {
        driverSendKeys(_passwordField, password);
    }

    //Confirm Password
    public void set_confPassword(String confPassword) {
        driverSendKeys(_confPassword, confPassword);
    }

    //Register Btn
    public void clickOnRegisterBtn() {
        driverWaitsUntilClick(_clickOnRegister, 5);
    }

}
