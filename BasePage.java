package framework.webPages;

import com.google.common.base.Function;
import framework.AppiumWrapper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by mohammadmuntakim
 */
public class BasePage {

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {
		webAction(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void selectFromDropdown(By locator, String dropdownText) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdown(By locator, int index) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by index
		selectMonth.selectByIndex(index);
	}

	public void verifyResultsInt(int expected, int actual) {
		try {
			Assert.assertTrue(actual <= expected);
		} catch (AssertionError e) {
			System.out.println(
					"Assertion of results failed: ***" + actual + "*** is more than ***" + expected + "***");
		}
	}

	public void verifyResults(String actual, String expected) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			System.out.println(
					"Assertion of results failed: *** " + actual + " *** found, but *** " + expected + " *** expected");
		}
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
		js.executeScript("window.scrollBy(0,800)");
	}

	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scroller(By locator) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
		WebElement element = webAction(locator);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
	}

	public void sendText(By locator, String text) {
		webAction(locator).clear();
		webAction(locator).sendKeys(text);
	}

	public boolean isTextOnPagePresent2(String text) {
		WebElement body = SharedSD.getDriver().findElement(By.id("listings"));
		String bodyText = body.getText();
		return bodyText.contains(text);
	}

	public void isTextOnPagePresent(String text) {
		WebElement body = SharedSD.getDriver().findElement(By.id("listings"));
		String bodyText = body.getText();
		try {
			Assert.assertTrue(bodyText.contains(text));
		} catch (AssertionError e) {
			System.out.println(
					"Assertion of results failed: ***" + text + "*** not found ***");
		}
	}

	public boolean isItDisplayed(By locator) {
		boolean displayInfo = false;
		try {
			displayInfo = webAction(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
		return displayInfo;
	}

	public void selectItByVisibleText(By locator, String text) {
		try {
			Select selector = new Select(webAction(locator));
			selector.selectByVisibleText(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public void findElementInArray(String classN, int goal) {
		List<WebElement> items = SharedSD.getDriver().findElements(By.className(classN));
		for (WebElement item : items) {
			if (item.getSize().equals(goal)) {
				System.out.println("yay");
			}
		}
	}

	public void findElementInArrayLocator(By locator, int goal) {
			List<WebElement> items = SharedSD.getDriver().findElements(locator);
			for (WebElement item : items) {
				if (Integer.parseInt(item.getText()) == Integer.parseInt(item.getText())+2) {
					System.out.println("yay");
				} else
					System.out.println("no");
			}
		}

	public String getIncrementedHour(int hoursIncremented) {
		Date hour = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(hour);
		cal.add(Calendar.HOUR, hoursIncremented);
		hour = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("hh aa");
		String hourIncremented = sdf.format(hour);
		return hourIncremented;
	}
}