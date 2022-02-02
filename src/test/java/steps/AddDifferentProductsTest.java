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

public class AddDifferentProductsTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private ProductDescription productDescription;
    private ModelPage modelPage;

    @Given("a user loged with email and password:")
    public void a_user_do_loged_with_email_and_password(DataTable dataTable) {
        homePage = new HomePage(Hook.getDriver());
        String email = "", password = "";
        List<Map<String, String>> data = dataTable.asMaps();
        for (Map<String, String> value : data) {
            email = value.get("email");
            password = value.get("password");
        }
        loginPage = homePage.clickSignin();
        myAccountPage = loginPage.fillData(email, password);
        homePage = myAccountPage.goToHomePage();
    }

    @When("add quantity of the product:")
    public void add_quantity_of_the_product(DataTable dataTable) {
        List<Map<String, String>> products = dataTable.asMaps();
        int cont = 0;

        for (Map<String, String> value : products) {
            productDescription = homePage.selectProduct(value.get("product"));
            productDescription.addCharacteristics(value.get("size"), value.get("color"), Integer.parseInt(value.get("quantity")), value.get("dimension"));
            modelPage = productDescription.addToCart();
            cont++;
            if (cont == products.size()){
                productDescription = modelPage.closeWindowModel();
                homePage = productDescription.goHomePage();
                homePage.clickCart();
                Hook.screenShot(value.get("productname"));
            }else {
                modelPage.continueShopping();
                homePage = productDescription.goHomePage();
            }
        }

    }

    @Then("check that the cart has the quantity added {int}")
    public void check_that_the_cart_has_the_quantity_added(int quantityCart) {
        Assert.assertEquals(quantityCart, homePage.totalCart());
    }


}
