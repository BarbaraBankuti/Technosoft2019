package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HotelsMainPage;
import org.testng.Assert;
import framework.webPages.HotelsMainPage;

public class HotelRoomCheckSD {

    private HotelsMainPage hotelsMainPage = new HotelsMainPage();

    @Given("^I am on main page3$")
    public void onMainPage() throws InterruptedException {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations", "Invalid Home Page");
    }

    @When("^I click on room dropdown and select (1|2|3|4|5|6||8|9+)$")
    public void clickOnRoomDropDown(String room) {

        switch (room) {
            case "1" :
                hotelsMainPage.setRoomDropDown(room);
                break;
            case "2":
                hotelsMainPage.setRoomDropDown(room);
                break;
            case "3":
                hotelsMainPage.setRoomDropDown(room);
                break;
            case "4":
                hotelsMainPage.setRoomDropDown(room);
                break;
            case "5":
                hotelsMainPage.setRoomDropDown(room);
                break;
            case "6":
                hotelsMainPage.setRoomDropDown(room);
                break;
            case "7":
                hotelsMainPage.setRoomDropDown(room);
                break;
            case "8":
                hotelsMainPage.setRoomDropDown(room);
                break;
            case "9+":
                hotelsMainPage.setRoomDropDown(room);
                break;
        }
    }

//    @Then("^I check room drop downs (3|5|7|9|11|13|15|17|0)$")
//    public void checkRoomDropDowns(String roomDropDownChoice){
//
//        switch (roomDropDownChoice) {
//            case "3":
//                hotelsMainPage.roomDisplayCheck(Integer.parseInt(roomDropDownChoice));
//                break;
//            case "5":
//                hotelsMainPage.roomDisplayCheck(Integer.parseInt(roomDropDownChoice));
//                break;
//            case "7":
//                hotelsMainPage.roomDisplayCheck(Integer.parseInt(roomDropDownChoice));
//                break;
//            case "9":
//                hotelsMainPage.roomDisplayCheck(Integer.parseInt(roomDropDownChoice));
//                break;
//            case "11":
//                hotelsMainPage.roomDisplayCheck(Integer.parseInt(roomDropDownChoice));
//                break;
//            case "13":
//                hotelsMainPage.roomDisplayCheck(Integer.parseInt(roomDropDownChoice));
//                break;
//            case "15":
//                hotelsMainPage.roomDisplayCheck(Integer.parseInt(roomDropDownChoice));
//                break;
//            case "17":
//                hotelsMainPage.roomDisplayCheck(Integer.parseInt(roomDropDownChoice));
//                break;
//            case "0":
//                hotelsMainPage.roomDisplayCheck(Integer.parseInt(roomDropDownChoice));
//                break;
//        }
//    }

    @Then("^I check room drop downs <roomDropDownChoice>$")
    public void iCheckRoomDropDownsRoomDropDownChoice(int roomDropDownChoice) {
        hotelsMainPage.roomDisplayCheck( roomDropDownChoice);
    }
}
