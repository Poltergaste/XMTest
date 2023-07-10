import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ChromeSettings;
import utils.Dates;
import pageElements.PageElementsCalendar;
import pageElements.PageElementsHome;
import org.openqa.selenium.*;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class CalendarTest extends ChromeSettings {
    private Dates dates = new Dates();

    private PageElementsHome pageHome = new PageElementsHome(driver);
    private PageElementsCalendar pageCalendar = new PageElementsCalendar(driver);

    private Calendar cal = Calendar.getInstance();
    private int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);


    @Test
    public void CalerndarTest() {

        pageHome.closeCookies.click();
        driver.navigate().refresh();
        pageHome.searchEducation.click();
        pageHome.economicCalendar.click();

        //****************SELECTED TODAY****************//
        switchToIframe();
        pageCalendar.today.click();
        pageCalendar.dateInSelectedDay.isDisplayed();
        pageCalendar.today.click();
        assertEquals("Dates do not correspond", dayOfMonth, dates.getDateInEconomicCalendar(pageCalendar.dateInSelectedDay.getText()));

        //****************SELECTED TOMORROW****************//
        driver.navigate().refresh();
        switchToIframe();
        dates.dayInCalendar(dayOfMonth + 1).click();
        pageCalendar.dateInSelectedDay.isDisplayed();
        dates.dayInCalendar(dayOfMonth + 1).click();
        assertEquals("Dates do not correspond", dayOfMonth + 1, dates.getDateInEconomicCalendar(pageCalendar.dateInSelectedDay.getText()));

        //****************SELECTED NEXT WEEK****************//
        driver.navigate().refresh();
        switchToIframe();
        dates.dayInCalendar(dayOfMonth + 7).click();
        pageCalendar.dateInSelectedDay.isDisplayed();
        dates.dayInCalendar(dayOfMonth + 7).click();
        assertEquals("Dates do not correspond", dayOfMonth + 7, dates.getDateInEconomicCalendar(pageCalendar.dateInSelectedDay.getText()));

        //****************SELECTED NEXT MONTH****************//
        driver.navigate().refresh();
        switchToIframe();
        pageCalendar.nextMonth.click();
        dates.dayInCalendar(1).click();
        pageCalendar.dateInSelectedDay.isDisplayed();
        dates.dayInCalendar(1).click();
        assertEquals("Dates do not correspond", 1, dates.getDateInEconomicCalendar(pageCalendar.dateInSelectedDay.getText()));

        //****************SELECTED HERE DISCLAIMER****************//
        driver.navigate().refresh();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        pageCalendar.disclaimerHereLink.click();
        assertEquals("Notification on Non-Independent Investment Research and Risk Warning", pageCalendar.riskWarningTitle.getText());

        //****************SELECTED PDF OPENED****************//
        pageCalendar.riskDisclosureLink.click();
        assertEquals("Real-Time Economic Calendar - provided by XM", driver.getTitle());

        teardown();
    }

    private void switchToIframe() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((By.xpath("//iframe[@title='iframe']"))));
    }
}
