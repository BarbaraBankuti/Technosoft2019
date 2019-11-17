package framework.webPages;

import org.openqa.selenium.By;

public class DarkSkyMainPage extends BasePage {

    private By currentTemp = By.xpath("//*[@id=\"title\"]/span[1]/span[2]/span[1]");
    private By listOfTodayTemp = By.xpath("//div[@id='timeline']//div[@class='temps']");
    private String minTemp = getTextFromElement(By.xpath("/html/body/div[6]/a[1]/span[2]/span[1]"));
    private String maxTemp = getTextFromElement(By.xpath("/html/body/div[6]/a[1]/span[2]/span[3]"));
    private String minTempTimeline = getTextFromElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[2]/div[1]/span[1]/span[1]"));
    private String maxTempTimeline = getTextFromElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[2]/div[1]/span[3]/span[1]"));
    private By expandTimelineButton = By.xpath("/html/body/div[6]/a[1]");
    private By hours = By.xpath("/html/body/div[4]/div/div/div[3]");

//    public void checkTemp(){
//        checkElementValueInArray(listOfTodayTemp,currentTemp);
//    }

    public void checkTempsTimeLine() throws InterruptedException {
        scrollDown();
        Thread.sleep(3000);
        clickOn(expandTimelineButton);
        Thread.sleep(3000);
        verifyResults(minTemp, minTempTimeline);
        verifyResults(maxTemp, maxTempTimeline);
    }

    public void checkHours(int goal) {
            findElementInArrayLocator(hours, goal);
            //getIncrementedHour(2);
    }

}
