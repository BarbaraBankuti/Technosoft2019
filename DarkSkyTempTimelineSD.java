package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyMainPage;
import org.testng.Assert;

public class DarkSkyTempTimelineSD {

    private DarkSkyMainPage darkSkyMainPage = new DarkSkyMainPage();

    @Given("^I am on main page$")
    public void iAmOnMainPage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - ", "Invalid Home Page");
    }

    @When("^I scroll down$")
    public void scrollDownToTimeLine(){
        darkSkyMainPage.scrollDown();
    }

    @Then("^I click on extend Timeline$")
    public void clickOmnTimeLineExpander() throws InterruptedException {
        darkSkyMainPage.checkTempsTimeLine();
    }
}
