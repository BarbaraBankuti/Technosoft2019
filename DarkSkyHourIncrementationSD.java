package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyMainPage;
import org.testng.Assert;

public class DarkSkyHourIncrementationSD {

    private DarkSkyMainPage darkSkyMainPage = new DarkSkyMainPage();

    @Given("^I am on main page1$")
    public void iAmOnMainPage1() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - ", "Invalid Home Page");
    }

    @Then("^I check if hours incremented by two$")
    public void hourCheck() {
        darkSkyMainPage.checkHours(2);
    }
}
