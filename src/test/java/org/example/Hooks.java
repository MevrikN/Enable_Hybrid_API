package org.example;

import Base_Pages.DriverManager;
import Base_Pages.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends Utils {

    DriverManager driverManager = new DriverManager();


    @Before
    public void setUp() {
        //Open Browser
        driverManager.openBrowser();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            //giving the name to screenshot
            //it will replace space with _
            String screenshotName = scenario.getName().replaceAll(" ", "_");

            //it will stick Screenshot with report if scenario fails
            scenario.attach(screenshot, "image/png", screenshotName); //stick it in the report
        }

        driverManager.closeBrowser();
    }
}
