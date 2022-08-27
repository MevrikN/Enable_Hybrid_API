package org.example;

import Base_Pages.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Utils {

    //Locators
    By _registerBtn = By.className("ico-register");
    By _clickOnProductName = By.xpath("//a[contains(text(),\"own computer\")]");
    By _searchSpace = By.id("small-searchterms");
    By _clickOnSearchBtn = By.xpath("//button[@type=\"submit\"]");
    By _clickOnVoteBtn = By.id("vote-poll-1");
    By _radioBtnPoll = By.xpath("//ul[@class='poll-options']//label[contains(text(),\"Poor\")]");
    By _errorMessageVote = By.id("block-poll-vote-error-1");
    By _successMessageOfVote = By.xpath("//ul[@class='poll-results']/following-sibling::span");


    //Click on Register button
    public void clickOnRegister() {
        driverClickOnElement(_registerBtn, 0);
    }

    //Categories Parameterized X-path
    public void clickOnCategory(String string) {
        driverClickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'" + string + "')]"), 5);
    }

    //Build yor own comp product
    public void clickOnProductName() {
        driverClickOnElement(_clickOnProductName);
    }

    //Home page url
    public void verifyHomepageURL() {
        driverWaitUrlToBe("https://demo.nopcommerce.com/", 3);
    }

    //Searchbar
    public void typeInSearch(String value) {
        driverSendKeys((_searchSpace), value);
    }

    //search button
    public void clickOnSearchBtn() {
        driverClickOnElement(_clickOnSearchBtn);
    }

    //Radio button poll
    public void clickOnPollRadioButton() {
        driverClickOnElement(_radioBtnPoll);
    }

    //Vote button
    public void clickOnVote() {
        driverWaitsUntilClick(_clickOnVoteBtn, 5);
    }

    //Accept PopUp window
    public void switchToPopUpAlertAccept() {
        driver.switchTo().alert().accept();
    }

    //Login tab
    public void logintab() {
        driverClickOnElement(By.className("ico-login"));
    }

    //Get text from popup
    public void getPopUpText() {
        String actual = driver.switchTo().alert().getText();
        String expected = "Please select an answer";
        Assert.assertEquals(actual, expected, "popup window text is not matching");
    }

    //Error message vote
    public void verifyErrorMessageOfPole() {
        driverTextToBe(_errorMessageVote, "Only registered users can vote.", 10);
        String actual = driver.findElement(_errorMessageVote).getText();
        String expected = "Only registered users can vote.";
        Assert.assertEquals(actual, expected, "Error message dose not matched");
    }

    //success vote message
    public void verifyVoteSuccess() {
        String actual = driver.findElement(_successMessageOfVote).getText().substring(3);
        String expected = "vote(s)...";
        Assert.assertEquals(actual, expected, "Text does not matched");
    }
}
