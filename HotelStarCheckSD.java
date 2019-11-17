package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HotelsMainPage;
import org.testng.Assert;

public class HotelStarCheckSD {

    private HotelsMainPage hotelsMainPage = new HotelsMainPage();

    @Given("^I am on hotel main page2$")
    public void iAmOnHotelMainPage2() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations", "Invalid Home Page");
    }

    @When("^I set destination2$")
    public void setDestination2() throws InterruptedException {
        hotelsMainPage.setDestination();
    }

    @And("^I click on search2$")
    public void clickOnSearchButton2(){
        hotelsMainPage.clickSearch();
    }

    @Then("^I set starts$")
    public void setStars() throws InterruptedException {
        hotelsMainPage.setStars();
    }

    @And("^I check the stars of hotels displayed$")
    public void checkStars() throws InterruptedException {
        hotelsMainPage.starCheck();
    }
}
