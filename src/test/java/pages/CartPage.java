package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".cart-line-product-actions a")
    private List<WebElement> remove;

    private String text = "There are no more items in your cart";
    private String located = ".js-cart span";

    @FindBy(css = ".card-block a")
    private WebElement checkout;

    @FindBy(css = ".no-items")
    private WebElement message;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void removeProduct() throws InterruptedException {
        remove.get(0).click();
        if (remove.size() == 1) {
            wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.textToBe(By.cssSelector(located), text));
        }
        Thread.sleep(10000);
    }

    public OrderPage checkout() {
        checkout.click();
        return new OrderPage(driver);
    }

    public String getMessage() {
        return message.getText();
    }
}
