package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "div.user-info a")
    private WebElement signin;

    @FindBy(css = "div.products .js-product-miniature")
    private List<WebElement> product;

    @FindBy()
    private WebElement messagePopup;

    @FindBy(css = "#_desktop_cart span:nth-child(3)")
    private WebElement valueCart;

    @FindBy(css = "#_desktop_cart a")
    private WebElement clickCart;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickSignin() {
        signin.click();
        return new LoginPage(driver);
    }


    public String getMessage() {
        System.out.println(driver.getPageSource());
        return driver.getPageSource();
    }


    public ProductDescription selectProduct(String number) {
       product.get(Integer.parseInt(number)).click();
       return new ProductDescription(driver);
    }

    public int totalCart() {
        String value = valueCart.getText().replace("(","");
        value = value.replace(")", "");
        return Integer.parseInt(value);
    }

    public CartPage clickCart() {
        clickCart.click();
        return new CartPage(driver);
    }
}
