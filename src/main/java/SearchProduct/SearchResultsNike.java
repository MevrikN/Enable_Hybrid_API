package SearchProduct;

import Base_Pages.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsNike extends Utils {

    By _itemnames = By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2");

    //Verify Url
    public void verifyUrl() {
        driverWaitUrl("https://demo.nopcommerce.com/search?q=nike&cid=0&mid=0&advs=false&isc=false&sid=false", 3);
    }

    //product titles
    public void findWordInProductTitle(String searchText) {
        //Store string name of product titles
        ArrayList<String> products = new ArrayList<>();
        ArrayList<String> numberOfProduct = new ArrayList<>();

        //List of web elements to get test titles
        /**
         To add products name, first locators of all web elements are stored into product locators list.
         And then by using for loop ,it will get all web elements title in string format and store them in products arraylist
         */

        List<WebElement> productLocators = driver.findElements(_itemnames);
        for (WebElement e : productLocators) {
            products.add(e.getText());
        }
        //print all titles
        System.out.println(products);
        //convert search input into lowercase
        String filterInput = searchText.substring(1, 4).toLowerCase();
        //print filter input
        System.out.println("Value filtered :" + filterInput);

        //Load
        for (String a : products) {
            if (a.contains(filterInput)) {
                numberOfProduct.add(a);
                System.out.println("Load all Titles : " + a);
            }
        }

        Assert.assertEquals(products, numberOfProduct, "it does not contains equal product");

//        Assert.assertTrue(products.equals(numberOfProduct),"Titles are not matching");

    }
}
