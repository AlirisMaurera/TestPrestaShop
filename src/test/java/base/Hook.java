package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Hook implements Constants{

    private static WebDriver driver;
    private String setUpBrowser = "chrome";

    @Before
    public void setUp(){
        String webdriver = System.getProperty("browser",setUpBrowser);
        driver = new Browser().setDriver(webdriver);
        driver.get(UrlDefault);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void screenShot(String nameTest){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File evidences = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(evidences, new File("target/evidences/Test_"+nameTest+".png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @After
    public void closeBrowser(){
        driver.close();
    }
}
