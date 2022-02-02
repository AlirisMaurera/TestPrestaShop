package steps;

import base.Hook;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;

import java.util.List;
import java.util.Map;

public class AddProductToCartTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private ProductDescription productDescription;
    private ModelPage modelPage;
    private String productNameModel, priceModel, subTotalModel, shippingModel, totalModel, taxesModel, messageModel;

    @Given("a user do loged with valid email {string} and password {string}")
    public void a_user_do_loged_with_valid_email_and_password(String email, String password) {

        homePage = new HomePage(Hook.getDriver());
        loginPage = homePage.clickSignin();
        myAccountPage = loginPage.fillData(email, password);
        homePage = myAccountPage.goToHomePage();
    }



    @When("Select the product number {string}")
    public void select_the_product_number(String index) {
        productDescription = homePage.selectProduct(index);
    }

    @When("define the characteristics of the product {string} {string} {int} {string}")
    public void define_the_characteristics_of_the_product(String size, String color, int quantity, String dimension) {
        productDescription.addCharacteristics(size, color, quantity, dimension);
    }

    @When("Add to cart {string}")
    public void add_to_cart(String nameTest) {
        modelPage = productDescription.addToCart();
        productNameModel = modelPage.getProductName();
        priceModel = modelPage.getPrice();
        subTotalModel = modelPage.getSubTotal();
        shippingModel = modelPage.getShipping();
        totalModel = modelPage.getTotalWihtTaxes();
        taxesModel = modelPage.getTaxes();
        messageModel = modelPage.getMessage();
        Hook.screenShot(nameTest);
    }

    @Then("show a summary with product name {string} price {string} SubTotal {string} shipping {string} total with taxes included {string} {string}")
    public void show_a_summary_with_product_name_price_sub_total_shipping_total_with_taxes_included(String productname, String price, String subtotal, String shipping, String taxIncl, String taxes) {
        Assert.assertTrue(productNameModel.contains(productname));
        Assert.assertEquals(price, priceModel );
        Assert.assertEquals(subtotal, subTotalModel );
        Assert.assertEquals(shipping, shippingModel );
        Assert.assertEquals(taxIncl, totalModel );
        Assert.assertEquals(taxes, taxesModel );
    }

    @Then("a message {string}")
    public void a_message_of_product_add(String message) {
        Assert.assertTrue(messageModel.contains(message));
    }





}
