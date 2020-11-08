package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCarPage extends  BasePage{

   /* @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement LicencePlate;
*/
    @FindBy(name = "custom_entity_type[LicensePlate]")
    private WebElement licencePlateInputBox;

    @FindBy(name = "custom_entity_type[ModelYear]")
    private WebElement modelYearInputBox;

    @FindBy(xpath="//a[@title='Create Car']/..")
    private WebElement createCar;

    public void clickOnCreateCar(){

        BrowserUtils.clickOnElement(createCar);
        System.out.println("Clicking on 'Create Car' button");

    }


    public void enterLicencePlate(String licencePlate){

        BrowserUtils.enterText(licencePlateInputBox,licencePlate);
    }


    public void enterModelYear(String modelyear){

        BrowserUtils.enterText(modelYearInputBox,modelyear);
    }


}

