package com.example.automation.stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.example.automation.pageobjects.HotelBookingPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonStepDefs {
    public WebDriver driver;
    public static String generatedFirstname;
    public static int intialDeleteBtnsBefore;
    public static int deleteBtnsAfterDelete;

    public CommonStepDefs() {
        driver = Hooks.driver;
        generatedFirstname = "" + System.currentTimeMillis();
    }

    @Given("^As a user of the hotel bookings portal, loads the booking form$")
    public void a_new_user_to_website() throws Throwable {
        String url = "http://hotel-test.equalexperts.io/";
        System.out.println("url:" + url);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("^\"presses Save button\"$")
    public void user_saves() throws Throwable {

    }

    @When("^the user enters the form information with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void theUserEntersTheFormInformationWithFirst_nameSurnamePriceDeposit_optionCheckInCheckOut(String firstName, String surName, String price, String depositOption, String check_in, String check_out) throws Throwable {
        //        initalise with PageFactory
        PageFactory.initElements(driver, HotelBookingPage.class);
        Assert.assertTrue(HotelBookingPage.heading.getText().contains("Hotel booking form"));

        generatedFirstname = generatedFirstname + firstName;
        System.out.print("----------********----Dynamic FirstName generated :" + generatedFirstname);
        HotelBookingPage.firstnameEntry.sendKeys(generatedFirstname);
        HotelBookingPage.surnameEntry.sendKeys(surName);
        HotelBookingPage.totalPriceEntry.sendKeys(price);

        Select dropdown = new Select(HotelBookingPage.depositPaidDrpDwn);
        if (depositOption.equalsIgnoreCase("false")) {
            dropdown.selectByIndex(1);
        }

//        Date checkIn = new SimpleDateFormat("yyyy-mm-dd").parse(check_in);
//        System.out.println("Checki-n Date to enter: " + "\t" + checkIn);
        HotelBookingPage.checkInDateEntry.sendKeys(check_in);

//        Date checkOut = new SimpleDateFormat("yyyy-mm-dd").parse(check_out);
//        System.out.println("Check-out Date to enter: " + "\t" + checkOut);
        HotelBookingPage.checkOutDateEntry.sendKeys(check_out);
    }

    @And("^presses Save button$")
    public void pressesSaveButton() throws Throwable {
        HotelBookingPage.saveBtn.click();
    }

    @Then("^the information is saved$")
    public void theInformationIsSaved() throws Throwable {
        Assert.assertTrue(HotelBookingPage.tableDeleteElements.size() > 0);
    }

    @And("^reflects the form with new booking details entered in a list, above the form entry fields$")
    public void reflectsTheFormWithNewBookingDetailsEnteredInAListAboveTheFormEntryFields() throws Throwable {
        System.out.println("Traverse the list and find the details entered, but can not VALIDATE exactly as form " + "doesnt have Uniqueness of each row.");
//      TODO: change this to Implicit wait times by extracting list of texts and verify with implicit wait times if the Expected text is present?
        Thread.sleep(5000);
        boolean foundCreatedBooking = false;
        for (WebElement item : HotelBookingPage.firstColElements) {
            System.out.println("*******Col first Name: " + item.getText());
            if (item.getText().equalsIgnoreCase(this.generatedFirstname)) foundCreatedBooking = true;
        }
        Assert.assertTrue("Dynamically created booking with first name :[" + generatedFirstname + "] Not found", foundCreatedBooking);
    }

    @And("^Delete option present next to the details in the list$")
    public void deleteOptionPresentNextToTheDetailsInTheList() throws Throwable {
        Assert.assertTrue(HotelBookingPage.tableDeleteElements.size() > 0);

    }

    @When("^the user clicks 'Delete' button next to any saved entry$")
    public void theUserClicksDeleteButtonNextToAnySavedEntry() throws Throwable {
//        boolean foundCreatedBooking =false;
//        for (WebElement item : HotelBookingPage.firstColElements) {
//            System.out.println("*******Col first Name: " + item.getText());
//            if (item.getText().equalsIgnoreCase(this.generatedFirstname)) foundCreatedBooking = true;
//              int index_of_newly_created = HotelBookingPage.firstColElements.indexOf(item);
//              HotelBookingPage.tableDeleteElements.get(index_of_newly_created).click();
//        }
        PageFactory.initElements(driver, HotelBookingPage.class);
        intialDeleteBtnsBefore = HotelBookingPage.tableDeleteElements.size();
        System.out.println("^^^^^^^^^Before Delete Button Pressed Size:"+intialDeleteBtnsBefore);
        Assert.assertTrue(intialDeleteBtnsBefore > 0);
        HotelBookingPage.tableDeleteElements.get(0).click();
        Thread.sleep(1000);


    }

    @Then("^the information row gets deleted$")
    public void theInformationRowGetsDeleted() throws Throwable {
//        TODO: Need to handle concurrent deletes by tackling unique Name that we enter.
        deleteBtnsAfterDelete = HotelBookingPage.tableDeleteElements.size();
         System.out.println("-------After Delete Button Pressed Size:"+deleteBtnsAfterDelete);
        Assert.assertTrue("Delete Btns are NOT less size after Delete, Think of solution to Assert Specific row which is deleted.", deleteBtnsAfterDelete != intialDeleteBtnsBefore);
    }
}

