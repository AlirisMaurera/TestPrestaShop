package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ModelPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private String subtotalValue = "Subtotal";
    private String shippingValue = "Shipping";
    private String totalValue = "Total (tax incl.)";
    private String taxesValue = "Taxes";

    @FindBy(css = "#blockcart-modal h6")
    private WebElement productName;
    private String located = "#blockcart-modal h6";

    @FindBy(css = "#blockcart-modal .product-price")
    private WebElement price;

    @FindBy(css = ".cart-content p")
    private List<WebElement> subTotal;

    @FindBy(id = "myModalLabel")
    private WebElement message;

    @FindBy(css = ".modal-header button .material-icons")
    private WebElement buttonClose;
    private String located2 = ".modal-header button .material-icons";

    @FindBy(css = ".cart-content-btn .btn-secondary")
    private WebElement buttonBack;
    private String located3 = ".cart-content-btn .btn-secondary";

    @FindBy(css = ".cart-content-btn a")
    private WebElement checkout;
    private String checkoutValue = ".cart-content-btn a";

    public ModelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(located)));
        return productName.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getSubTotal() {
        return getValue(subtotalValue);
    }

    public String getShipping() {
        return getValue(shippingValue);
    }

    public String getTotalWihtTaxes() {
        return getValue(totalValue);
    }

    public String getTaxes() {
        return getValue(taxesValue);
    }

    public String getMessage() {
        return message.getText();
    }

    private String getValue(String value) {
        String[] arrayValue = new String[5];
        String newValue = "";
        for (int i = 0; i < subTotal.size(); i++) {
            if (subTotal.get(i).getText().contains(value)) {
                arrayValue = subTotal.get(i).getText().split(" ");
                if (arrayValue.length > 2) {
                    newValue = arrayValue[3];
                } else newValue = arrayValue[1];
            }
        }
        return newValue;
    }

    public ProductDescription closeWindowModel() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(located2)));
        buttonClose.click();
        return new ProductDescription(driver);
    }

    public void continueShopping() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(located3)));
        buttonBack.click();
    }

    public CartPage proceedToCheckout() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(checkoutValue)));
        checkout.click();
        return new CartPage(driver);
    }
}
