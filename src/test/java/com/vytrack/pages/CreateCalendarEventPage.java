package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
    Create following web elements in this page class:
    - create calendar event button
    - title input box element
    - description input box element

    5. Create void method clickOnCreateCalendarEvenBtn()
6. Create void method enterTitle(String value)
7. Create void method enterDescription(String value)


 */
public class CreateCalendarEventPage extends  BasePage{

    /*@FindBy(xpath = "(//a[contains(text(),'Create Calendar event')])[3]")
    private WebElement createCalendarEvent;*/

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;


    @FindBy(name = "oro_calendar_event_form[title]")
    private WebElement titleInputBoxElement;

    @FindBy(xpath = "//iframe[contains(id,oro_calendar_event_form_description-uid-)]")
    private WebElement iframe;

    @FindBy(className = "mce-content-body")
    private WebElement descriptionInputBox;



    public void  clickOnCreateCalendarEvenBtn(){

        BrowserUtils.clickOnElement(createCalendarEvent);

    }


    public void  enterTitle(String value){

        //titleInputBoxElement.sendKeys(value);
        BrowserUtils.enterText(titleInputBoxElement,value);
    }


    public void  enterDescription(String value){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

        Driver.getDriver().switchTo().defaultContent();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

        //BrowserUtils.enterText(descriptionInputBox,value);
        descriptionInputBox.sendKeys(value);

        Driver.getDriver().switchTo().defaultContent();

    }


    public String getDataFromGeneralInfo(String parameter){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        String xpath = "//label[text()='" + parameter + "']/../div/div";

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

        return element.getText().trim();


    }



}
