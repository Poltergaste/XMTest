package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Dates extends ChromeSettings {

    public WebElement dayInCalendar(int day) {
        return driver.findElement(By.xpath("//div[contains(@class,'mat-calendar-body-cell-content mat-focus-indicator') and contains(text(), '" + day + "')]"));
    }

    public int getDateInEconomicCalendar(String selectedDateInCalendar) {
        selectedDateInCalendar = selectedDateInCalendar.substring(selectedDateInCalendar.length() - 2);
        return Integer.parseInt(selectedDateInCalendar);
    }

}