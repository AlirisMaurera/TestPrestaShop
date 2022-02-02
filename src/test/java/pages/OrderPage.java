package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage {

    private WebDriver driver;

    @FindBy(css = "#checkout-addresses-step .clearfix button")
    private WebElement continueAddress;

    @FindBy(css = "#checkout-delivery-step .clearfix button")
    private WebElement continueShiiping;

    @FindBy(css = ".payment-options .clearfix input")
    private List<WebElement> selectPay;

    @FindBy(css = "#conditions-to-approve input")
    private WebElement terms;

    @FindBy(css = "#payment-confirmation button")
    private WebElement confirmation;


    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void continueAddress() {
        continueAddress.click();
    }

    public void continueShipping() {
        continueShiiping.click();
    }

    public void selectPayment(int option) {
        selectPay.get(option).click();

    }

    public void agreeTerms() {
        terms.click();
    }

    public ConfirmationPage pay() {
        confirmation.click();
    return new ConfirmationPage(driver);
    }


}
