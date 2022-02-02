package steps;

import base.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class LoginTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private String page;

    @Given("a user is in the page prestashop")
    public void a_user_is_in_the_page_prestashop() {
        homePage = new HomePage(Hook.getDriver());
    }

    @When("click in sign in")
    public void click_in_sign_in() {
        loginPage = homePage.clickSignin();
        page = loginPage.getUrl();
    }

    @When("fill email {string} password {string} {string}")
    public void fill_email_password(String email, String password, String nameScreen) throws InterruptedException {
        myAccountPage = loginPage.fillData(email, password);
        Thread.sleep(1000);
        Hook.screenShot(nameScreen);
    }

    @Then("should to do login and show the name {string} in the page")
    public void should_to_do_login(String name) {
        Assert.assertEquals(name, myAccountPage.getName());
    }

    @Then("it should stay on the same page")
    public void it_should_stay_on_the_same_page() {
        Assert.assertEquals(page, myAccountPage.getUrl());
    }


    @Then("show a message {string} of  failed login")
    public void show_a_message_of_falied_login(String message) {
        Assert.assertEquals(message, loginPage.getMessageFailed());
    }


}
