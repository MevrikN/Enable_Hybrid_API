package org.example;

import Base_Pages.LoadProp;
import Base_Pages.Utils;
import org.openqa.selenium.By;

public class LoginPage extends Utils {

    LoadProp loadProp = new LoadProp();

    //Locators
    By _loginEmail =By.id("Email");
    By _loginPassword = By.id("Password");
    By _loginBtn = By.xpath("//button[@class='button-1 login-button']");

    //Email
    public void enterEmail(){
        driverSendKeys(_loginEmail,loadProp.getProperty("email"));
    }

    //Password
    public void enterPassword(){
        driverSendKeys(_loginPassword, loadProp.getProperty("password"));
    }

    //Login Btn
    public void clickLoginBtn(){
        driverClickOnElement(_loginBtn);
    }
}
