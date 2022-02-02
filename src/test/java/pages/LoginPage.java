package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(name = "email")
    private WebElement fillEmail;

    @FindBy(name = "password")
    private WebElement fillPassword;

    @FindBy(id = "submit-login")
    private WebElement signIn;

    @FindBy(css = ".help-block li")
    private WebElement messageFaild;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MyAccountPage fillData(String email, String password) {
        fillEmail.sendKeys(email);
        fillPassword.sendKeys(password);
        signIn.click();
        return new MyAccountPage(driver);
    }

    public String getMessageFailed() {
        return messageFaild.getText();
    }


    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
