package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageElementsCalendar {

        @FindBy(xpath = "//*[contains(@class,'mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today')]")
        public
        WebElement today;

        @FindBy(xpath = "//*[@aria-label='Next month']")
        public
        WebElement nextMonth;

        @FindBy(xpath = "//*[@class='tc-economic-calendar-item-header-left-title tc-normal-text']")
        public
        WebElement dateInSelectedDay;

        @FindBy(xpath = "//a[@href='/research/risk_warning']")
        public
        WebElement disclaimerHereLink;

        @FindBy(xpath = "//div[@class='container mt-350']/h2")
        public
        WebElement riskWarningTitle;

        @FindBy(xpath = "//span/a[contains(text(), 'Risk Disclosure')]")
        public
        WebElement riskDisclosureLink;

        public PageElementsCalendar(WebDriver driver){
            PageFactory.initElements(driver, this);
        }

}
