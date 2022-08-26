package Base_Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Utils extends BasePage {

//All Re-usable Methods

    //Get text
    public static void getText(By by, String expected) {
        String actual = gettext(by);
        Assert.assertTrue(actual.equalsIgnoreCase(expected), "Product name is not matching");
    }

    //Wait for Element
    public static void waitForElement(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Element to be clickable
    public static void elementToBeClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Select by Value Text
    public static void selectByValue(By by, String text) {
        Select selectYear = new Select(driver.findElement(by));
        selectYear.selectByValue(text);
    }

    //Select by Visible Text
    public static void selectByVisibleText(By by, String text) {
        Select selectYear = new Select(driver.findElement(by));
        selectYear.selectByVisibleText(text);
    }

    //Over Loading
    public static void driverClickOnElement(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    //Click on Element
    public static void driverClickOnElement(By by) {
        driver.findElement(by).click();
    }

    //Screenshot
    public static void takeScreenshot(String filename) {
        //Convert Web Driver Object to Screenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        //Calling getScreenshotAs method to create image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Copy file at Destination folder
        try {
            FileUtils.copyFile(srcFile, new File("Screenshots\\" + rendomdate() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Time stamp
    public static String rendomdate() {
        Date dat = new Date();
        SimpleDateFormat formate = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formate.format(dat);
    }

    //Array List
    public static void getArrayList(By by) {
        List<WebElement> listname = driver.findElements(by);
        for (WebElement e : listname) {
            System.out.println(e.getText());
        }
    }

    //Wait for element to be click-able
    public static void driverWaitsUntilClick(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    //wait for url
    public static void driverWaitUrl(String url, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    //Send Text Values
    public static void driverSendKeys(By by, String value) {
        driver.findElement(by).sendKeys(value);
    }

    //Get text
    public static String gettext(By by) {
        return driver.findElement(by).getText();
    }

    public static void verifyCurrentURL() {
        driver.getCurrentUrl();
    }

    public static String titleOfPage() {
        return driver.getTitle();
    }

    //URL to be
    public static void driverWaitUrlToBe(String exUrl, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(exUrl));
    }

    //Wait until Attribute ToBe
    public static void driverAttributeToBe(By by, String attribute, String value, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBe(by, attribute, value));
    }

    //Wait until TextToBe
    public static void driverTextToBe(By by, String value, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBe(by, value));
    }

    //DOM Attribute tobe
    public static void driverDomAttributesToBe(WebElement element, String attribute, String value, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.domAttributeToBe(element, attribute, value));
    }
}
