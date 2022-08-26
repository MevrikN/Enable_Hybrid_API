package Base_Pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager extends Utils{


    String browserName = "chrome";

    public void openBrowser(){

            System.out.println("Running Locally...");

            if(browserName.equalsIgnoreCase("Chrome")) {
                System.out.println("Chrome");
                //Open Chrome
                System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
                driver = new ChromeDriver();  // import chrome web-Driver dependency (In 'POM' file)

            }else if(browserName.equalsIgnoreCase("Firefox")) {
                System.out.println("Firefox");
                //Firefox
                System.setProperty("webdriver.gecko.driver","src/test/java/Drivers/geckodriver.exe" );
                driver= new FirefoxDriver();

            }else if(browserName.equalsIgnoreCase("Edge")){
                System.out.println("Edge");
                //Edge
                System.setProperty("webdriver.edge.driver","src/test/java/Drivers/msedgedriver.exe");
                driver = new EdgeDriver();

            }else {
                System.out.println("You Entered un-valid Browser name :" + browserName);
            }

         //Duration to be wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Maximize the screen
        driver.manage().window().maximize();

        //Open Web page
        driver.get("https://demo.nopcommerce.com/");

    }

    public void closeBrowser(){
        driver.quit();

    }


}
