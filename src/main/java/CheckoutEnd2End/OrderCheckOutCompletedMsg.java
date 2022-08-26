package CheckoutEnd2End;

import Base_Pages.Utils;
import org.openqa.selenium.By;

public class OrderCheckOutCompletedMsg extends Utils {

    //Verify title
    public void verifyTitle() {
        titleOfPage().contains("successfully processed!");
    }

    //Continue Btn
    public void clickContinue() {
        driverClickOnElement(By.xpath("//button[@onclick='setLocation(\"/\")']"));
    }
}
