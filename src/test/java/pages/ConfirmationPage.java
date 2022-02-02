package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConfirmationPage {

    private WebDriver driver;

    @FindBy(css = "#order-items .details span")
    private WebElement details;

    @FindBy(css = "#order-items .qty div div")
    private List<WebElement> values;

    @FindBy(css = ".order-confirmation-table table tr")
    private List<WebElement> table;

    @FindBy(css = "#content-hook_order_confirmation h3")
    private WebElement message;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getText() {
        return details.getText();
    }

    public String getPrice() {
        return values.get(0).getText();
    }

    public String getTotal() {
        return values.get(2).getText();
    }

    public String getTotalWithTax() {
        String value = "TOTAL (TAX INCL.) ";
        String tax = "";
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).getText().contains(value)) {
                tax = table.get(i).getText().replace(value, "");
            }
        }
        return tax;
    }

    public String getMessage() {
        return message.getText();
    }
}
