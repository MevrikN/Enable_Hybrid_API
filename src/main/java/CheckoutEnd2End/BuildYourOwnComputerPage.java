package CheckoutEnd2End;

import Base_Pages.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class BuildYourOwnComputerPage extends Utils {

    //Locators
    By _processor = By.id("product_attribute_1");
    By _ram = By.id("product_attribute_2");
    By _hdd = By.xpath("//label[contains(text(),\"320 GB\")]");
    By _os = By.id("product_attribute_4_9");
    By _software1 = By.id("product_attribute_5_11");
    By _software2= By.id("product_attribute_5_12");
    By _addToCartBtn = By.xpath("//div[@class=\"add-to-cart\"]//child::button");
    By _clickShoppingCart = By.xpath("//a[.=\"shopping cart\"]");


    //Verify page url
    public void verifyURLOfBuildYourOwnDesktopProduct(){
        driverWaitUrl("https://demo.nopcommerce.com/build-your-own-computer",5);
    }

    //Select all options
    public void selectAllOptionsBuildYourOwnComp(){

        //Select Processor
        Select select1 = new Select(driver.findElement(_processor));
        select1.selectByIndex(1);

        //Select RAM
        Select select2 = new Select(driver.findElement(_ram));
        select2.selectByIndex(1);

        //Click on HDD (320 gb)
        driverClickOnElement(_hdd);

        //Click on OS (Vista Premium [+$60.00])
        driverClickOnElement(_os);

        //Select Software
        driverClickOnElement(_software1);
        driverClickOnElement(_software2);
    }

    //Click on Add to cart button
    public void addToCartBtn(){
        driverWaitsUntilClick(_addToCartBtn,3);
    }

    //Click on Shopping Cart
    public void shoppingCartButton(){
        driverWaitsUntilClick(_clickShoppingCart,6);
    }
}
