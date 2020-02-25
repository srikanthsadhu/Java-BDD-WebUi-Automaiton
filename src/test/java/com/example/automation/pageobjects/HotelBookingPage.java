package com.example.automation.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HotelBookingPage extends BasePage{

    public HotelBookingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how=How.CSS, using="h1")
    public static WebElement heading;

    @FindBy(how=How.CSS, using="input#firstname")
    public static WebElement firstnameEntry;

    @FindBy(how=How.CSS, using="input#lastname")
    public static WebElement surnameEntry;

    @FindBy(how=How.CSS, using="input#totalprice")
    public static WebElement totalPriceEntry;

    @FindBy(how=How.CSS, using="select#depositpaid")
    public static WebElement depositPaidDrpDwn;

    @FindBy(how=How.CSS, using="#checkin")
    public static WebElement checkInDateEntry;

    @FindBy(how=How.CSS, using="input#checkout")
    public static WebElement checkOutDateEntry;

    @FindBy(how=How.CSS, using="input[value=' Save ']")
    public static WebElement saveBtn;

    @FindBy(how=How.XPATH, using="///div[@id='bookings']/div[*]/div[*]/*")
    public static List<WebElement> tableElements;

    @FindBy(how=How.XPATH, using="//div[@id='bookings']/div[*]/div[1]/*")
    public static List<WebElement> firstColElements;

    @FindBy(how=How.XPATH, using="//input[@value='Delete']")
    public static List<WebElement> tableDeleteElements;

    //div[@id='ui-datepicker-div']/table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[3]/a[@href='#']


}
