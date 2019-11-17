package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HotelsMainPage;
import org.testng.Assert;

public class HotelDealOfDaySD {

    private HotelsMainPage hotelsMainPage = new HotelsMainPage();

    @Given("^I am on hotel main page$")
    public void iAmOnHotelMainPage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations", "Invalid Home Page");
    }

    @When("^I set destination$")
    public void setDestination() throws InterruptedException {
        hotelsMainPage.setDestination();
    }

    @And("^I click on search$")
    public void clickOnSearchButton(){
        hotelsMainPage.clickSearch();
    }

    @Then("^I check if Deal Of The Day is less than 200$")
    public void checkDeal(){
        hotelsMainPage.checkDealPrice();
    }
}


