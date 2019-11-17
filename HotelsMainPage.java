package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import stepdefinition.SharedSD;

public class HotelsMainPage extends BasePage{

    private By roomDropDown = By.id("qf-0q-compact-occupancy");
    private By x = By.xpath("//*[@id='managed-overlay']/button");
    private By newRoomDropDown = By.id("qf-0q-rooms");
    private By adultDropDown = By.id("qf-0q-room-0-adults");
    private By childrenDropDown = By.id("qf-0q-room-0-children");
    private By adultDropDown2 = By.id("qf-0q-room-1-adults");
    private By childrenDropDown2 = By.id("qf-0q-room-1-children");
    private By searchButton = By.xpath("//button[@class='cta cta-strong']");
    private By destinationSearchBar = By.id("qf-0q-destination");
    private By destinationClick = By.id("citysqm-asi0-s0");
    private By fiveStar = By.id("f-star-rating-5");
    private By dealOfTheDayPrice = By.xpath("/html[1]/body[1]/div[3]/main[1]/div[2]/div[2]/div[1]/section[2]/div[1]/ol[1]/li[1]/article[1]/section[1]/aside[1]/div[1]/a[1]/ins[1]");
    private By bottomText = By.id("listings-loading");
    private By roomWidget = By.xpath("/html/body/div[2]/div/div/div[1]/div/div/div[2]/div[1]/div/form/div[3]");
    private String roomDropDownWidgetClass = "widget-query-people";


    public void clickSearch(){
        clickOn(searchButton);
    }

    public void selectMoreOptions(){
        selectItByVisibleText(roomDropDown,"More options…");
    }

    public void setDestination() throws InterruptedException {
        sendText(destinationSearchBar,"New York,NY");
        Thread.sleep(3000);
        clickOn(destinationClick);
    }

    public void setStars() throws InterruptedException {
        scrollDown();
        clickOn(fiveStar);
        Thread.sleep(2000);
    }

    public void checkDealPrice(){
        Integer price = Integer.parseInt(getTextFromElement(dealOfTheDayPrice).substring(1));
        verifyResultsInt(200,price);
    }
    public void starCheck() throws InterruptedException {
        Thread.sleep(2000);
        scrollToBottom();
        //isTextOnPagePresent("4-star");
    }

    public void setRoomDropDown(String roomNum){
        selectItByVisibleText(newRoomDropDown,roomNum);
    }

    public void roomDisplayCheck(int dropDownNum){
        findElementInArray(roomDropDownWidgetClass,dropDownNum);

    }
}
