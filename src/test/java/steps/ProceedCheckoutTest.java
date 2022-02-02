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

public class ProceedCheckoutTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private ProductDescription productDescription;
    private ModelPage modelPage;
    private CartPage cartPage;
    private OrderPage orderPage;
    private ConfirmationPage confirmationPage;

    @Given("a user with a email and password valid:")
    public void a_user_with_a_email_and_password_valid(DataTable dataTable) {
        homePage = new HomePage(Hook.getDriver());
        List<Map<String,String>> login = dataTable.asMaps();
        for (Map<String, String> value:login) {
            loginPage = homePage.clickSignin();
            myAccountPage = loginPage.fillData(value.get("email"), value.get("password"));

        }

    }
    @Given("a product in the cart {string} {string} {string} {int} {string}")
    public void a_product_in_the_cart(String index, String size, String color, int quantity, String dimension) {
            homePage = myAccountPage.goToHomePage();
            productDescription = homePage.selectProduct(index);
            productDescription.addCharacteristics(size,color, quantity, dimension);
            modelPage = productDescription.addToCart();
    }
    @When("proceed to checkout")
    public void proceed_to_checkout() {
        cartPage = modelPage.proceedToCheckout();
        orderPage = cartPage.checkout();

    }
    @When("add addrese, a shipping method")
    public void add_addrese_a_shipping_method() {
        orderPage.continueAddress();
        orderPage.continueShipping();

    }
    @When("select payment method {int} {string}")
    public void select_payment_method(int option, String nameTest) {
        orderPage.selectPayment(option-1);
        orderPage.agreeTerms();
        confirmationPage = orderPage.pay();
        Hook.screenShot(nameTest);
    }
    @Then("show a summary of the order {string} {string} {string} {string}")
    public void show_a_summary_of_the_order(String productName, String price, String Total, String TotalwithTax) {
        Assert.assertTrue(confirmationPage.getText().contains(productName));
        Assert.assertEquals(price, confirmationPage.getPrice());
        Assert.assertEquals(Total, confirmationPage.getTotal());
        Assert.assertEquals(TotalwithTax, confirmationPage.getTotalWithTax());

    }
    @Then("a message of confirmation {string}")
    public void a_messade_of_confirmation(String message) {
        Assert.assertTrue(confirmationPage.getMessage().contains(message));

    }

}
