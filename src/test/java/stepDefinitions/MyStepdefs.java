package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.TestPage;
import utils.ConfigReader;
import utils.Driver;

public class MyStepdefs extends TestPage {
    @Given("Navigate to the home page")
    public void navigateToTheHomePage() {
        Driver.getDriver().navigate().to("file:///C:/Users/Sony/Desktop/task/QE-index%20(3).html");
    }

    @And("Assert that both the email address and password inputs are present as well as the login button")
    public void assertThatBothTheEmailAddressAndPasswordInputsArePresentAsWellAsTheLoginButton() {


        Assert.assertTrue(email.isDisplayed());
        Assert.assertTrue(password.isDisplayed());
        enterKeys(email, ConfigReader.getProperty("Email"));
        enterKeys(password,ConfigReader.getProperty("Password"));
    }

    @And("Enter in an email address and password combination into the respective fields")
    public void enterInAnEmailAddressAndPasswordCombinationIntoTheRespectiveFields() {
    }
}
