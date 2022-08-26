package CheckoutEnd2End;


import Base_Pages.Utils;
import org.openqa.selenium.By;

public class AddToCartPage extends Utils {

    By _getTextBuildOwnComp = By.xpath("//td[@class=\"product\"]//child::a[.=\"Build your own computer\"]");
    By _TandCBox = By.id("termsofservice");
    By _AddToCartBtn = By.xpath("//button[contains(text(),\" Checkout \")]");

    //Title of the page
    public void verifyTitleOfPage() {
        titleOfPage().equalsIgnoreCase("nopCommerce demo store. Shopping Cart");
    }

    //product Added to cart
    public void verifyProductAddedToCart() {
        getText(_getTextBuildOwnComp, "Build your own computer");
    }

    //Check box T&C
    public void checkBoxTandC() {
        driverClickOnElement(_TandCBox);
    }

    //Add to cart Btn
    public void addToCartBtn() {
        driverClickOnElement(_AddToCartBtn);
    }

}
