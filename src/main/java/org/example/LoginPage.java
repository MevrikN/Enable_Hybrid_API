package org.example;

import Base_Pages.LoadProp;
import Base_Pages.Utils;
import org.openqa.selenium.By;

public class LoginPage extends Utils {

    LoadProp loadProp = new LoadProp();

    //Email
    public void enterEmail(){
        driverSendKeys(By.id("Email"),loadProp.getProperty("email"));
    }

    //Password
    public void enterPassword(){
        driverSendKeys(By.id("Password"), loadProp.getProperty("password"));
    }

    //Login Btn
    public void clickLoginBtn(){
        driverClickOnElement(By.xpath("//button[@class='button-1 login-button']"));
    }
}
