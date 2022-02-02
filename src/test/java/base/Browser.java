package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Browser implements Constants {

    public WebDriver setDriver(String webdriver) {
        if (webdriver.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ChromePath);
            return new ChromeDriver();
        } else if (webdriver.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", FirefoxPath);
            return new FirefoxDriver();
        }
        return new HtmlUnitDriver();
    }
}