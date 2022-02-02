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

public class RemoveProductTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private ProductDescription productDescription;
    private ModelPage modelPage;
    private CartPage cartPage;

    @Given("a user loged with valid email password:")
    public void a_user_loged_with_valid_email_password(DataTable dataTable) {
        List<Map<String, String>> login = dataTable.asMaps();
        homePage = new HomePage(Hook.getDriver());
        for (Map<String, String> value : login) {
            String email = value.get("email");
            String password = value.get("password");
            loginPage = homePage.clickSignin();
            myAccountPage = loginPage.fillData(email, password);
        }

    }

    @Given("a product in the cart:")
    public void a_product_in_the_cart(DataTable dataTable) {
        homePage = myAccountPage.goToHomePage();
        int cont = 0;
        List<Map<String, String>> product = dataTable.asMaps();
        for (Map<String, String> value : product) {
            String productValue = value.get("product");
            productDescription = homePage.selectProduct(productValue);
            productDescription.addCharacteristics(value.get("size"), value.get("color"), Integer.parseInt(value.get("quantity")), value.get("dimension"));
            modelPage = productDescription.addToCart();
            cont++;
            if (product.size() == cont){
                modelPage.closeWindowModel();
                homePage = productDescription.goHomePage();
            }else {
                modelPage.continueShopping();
                productDescription.goHomePage();
            }
        }
        cartPage = homePage.clickCart();
    }

    @When("deleted a product from the cart {string}")
    public void deleted_a_product_from_the_cart(String nameTest) throws InterruptedException {
        cartPage.removeProduct();
        Hook.screenShot(nameTest);
    }

    @Then("the cart is {int}")
    public void the_cart_is(int value) {
        Assert.assertEquals(value, homePage.totalCart());
    }

    @Then("show a message {string}")
    public void show_a_message(String message) {
        Assert.assertEquals(message, cartPage.getMessage());
    }


    @When("deleted the first product of the list {string}")
    public void deleted_the_first_product_of_the_list(String nameTest) throws InterruptedException {
        Hook.screenShot("Before_"+nameTest);
        cartPage.removeProduct();
        Hook.screenShot("After_"+nameTest);
    }


}
