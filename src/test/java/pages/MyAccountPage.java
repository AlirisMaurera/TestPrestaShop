package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private WebDriver driver;

    @FindBy(css = "#_desktop_user_info span")
    private WebElement namePage;

    @FindBy(css = "#_desktop_logo a")
    private WebElement goHomePage;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getName() {
        return namePage.getText();
    }

    public HomePage goToHomePage() {
        goHomePage.click();
        return new HomePage(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}