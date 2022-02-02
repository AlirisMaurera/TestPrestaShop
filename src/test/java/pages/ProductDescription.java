package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductDescription {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".product-variants .product-variants-item")
    private List<WebElement> description;

    @FindBy(id = "group_1")
    private WebElement options;

    @FindBy(css = "#group_2 li")
    private List<WebElement> optionColor;

    @FindBy(id = "quantity_wanted")
    private WebElement optionQuantity;

    @FindBy(id = "group_3")
    private WebElement optionsDimension;

    @FindBy(css = ".add button")
    private WebElement buttonAdd;





    @FindBy(css = "#_desktop_logo a")
    private WebElement goHomePage;

    public ProductDescription(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addCharacteristics(String size, String color, int quantity, String dimension) {
        if (description.size() == 2) {
            selectValue(size, options);
            selectColor(color);

        }
        if (description.size() == 1) {
            if (description.get(0).getText().contains("Size")) {
                selectValue(size, options);

            } else if (description.get(0).getText().contains("Dimension")) {
                selectValue(dimension, optionsDimension);

            }
        }
        selectQuantity(quantity);

    }

    private void selectQuantity(int quantity) {
        optionQuantity.clear();
        optionQuantity.sendKeys(String.valueOf(quantity));
    }

    private void selectValue(String value, WebElement option) {
        Select select = new Select(option);
        select.selectByVisibleText(value);
    }

    private void selectColor(String color) {
        for (int i = 0; i < optionColor.size(); i++) {
            if (optionColor.get(i).getText().equalsIgnoreCase(color)) {
                optionColor.get(i).click();
            }
        }
    }

    public ModelPage addToCart() {
        buttonAdd.click();
        return new ModelPage(driver);
    }





    public HomePage goHomePage() {
        goHomePage.click();
        return new HomePage(driver);
    }
}
