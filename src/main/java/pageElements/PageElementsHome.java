package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageElementsHome {

        @FindBy(xpath =  "//*[@aria-label='Close']")
        public
        WebElement closeCookies;

        @FindBy(xpath =  "//li[@class='main_nav_research']/a")
        public
        WebElement searchEducation;

        @FindBy(xpath = "//a[@href='https://www.xm.com/research/economicCalendar']")
        public
        WebElement economicCalendar;

        public PageElementsHome(WebDriver driver){
            PageFactory.initElements(driver, this);
        }

}
