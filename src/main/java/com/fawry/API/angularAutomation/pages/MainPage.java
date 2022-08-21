package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.paulhammant.ngwebdriver.NgWebDriver;
import net.minidev.json.JSONObject;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainPage {

    // Initialize web drivers
    WebDriver driver;
    NgWebDriver ngDriver;

    public MainPage(WebDriver driver, NgWebDriver ngDriver) {
        this.driver = driver;
        this.ngDriver = ngDriver;

        //Set a delay of 30 secs to wait for elements' visibility
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(factory, this);

//		PageFactory.initElements(driver, this);

    }
    public MainPage() {

    }

    void HandlingJsonObj(String Key, String Value, JSONObject JSOBJ) {

        if (Value != "") {
            JSOBJ.put(Key, Value);
        }


    }

    void HandlingJsonObjint(String Key, int Value, JSONObject JSOBJ) {


        if (Value != 0) {
            JSOBJ.put(Key, Value);
        }}

    void HandlingArrayList(String value, ArrayList ArrList){
        if (value != "") {
            ArrList.add(value);
        }

    }


    void ParentJsonObjList(JSONObject JSOBJ,List<Object> JsList){
        if (JSOBJ.size() > 0) {
            JsList.add(JSOBJ);
        }
    }

    void ParentJsonObjListArrVs(JSONObject JSOBJ,String listKey,ArrayList List){
        if (List.size() > 0) {
            JSOBJ.put(listKey,List);
        }
    }

    void ParentJsonObjListVs(JSONObject JSOBJ,String listKey,List<Object> JsList){
        if (JsList.size() > 0) {
            JSOBJ.put(listKey,JsList);
        }
    }
    void ParentJsonObj(JSONObject JSOBJ,String JsonKey,JSONObject parentJSOBJ){
        if (JSOBJ.size() > 0) {
            parentJSOBJ.put(JsonKey, JSOBJ);
        }
    }

    public void timestamp(AddUpdateBusinessEntityDM ADDObjDM) {

        String dateTime = new SimpleDateFormat("mmsss").format(new Date());
        if(ADDObjDM.getBE_nameEn() == ""){
            ADDObjDM.setBE_nameEn("autoNameEn" + dateTime);
        }
        if(ADDObjDM.getBE_nameEn().length()<3){
            ADDObjDM.setBE_nameEn(ADDObjDM.getBE_nameEn() + dateTime);
        }

        if(ADDObjDM.getBE_nameAr() == ""){
            ADDObjDM.setBE_nameAr("autoNameAR" + dateTime);
        }
        if(ADDObjDM.getBE_nameAr().length()<3){
            ADDObjDM.setBE_nameAr(ADDObjDM.getBE_nameAr() + dateTime);
        }

        if(ADDObjDM.getBE_email() == ""){
            ADDObjDM.setBE_email("autoMail" + dateTime+ "@gmail.com");
        }

        if(ADDObjDM.getBE_email().length()<3){
            ADDObjDM.setBE_email(ADDObjDM.getBE_email() + dateTime+ "@gmail.com");
        }

        if(ADDObjDM.getBE_phoneNumber() == ""){
            ADDObjDM.setBE_phoneNumber("010917" + dateTime);
        }

        if(ADDObjDM.getBE_phoneNumber().length()<4){
            ADDObjDM.setBE_phoneNumber(ADDObjDM.getBE_phoneNumber() + dateTime +"222");
        }


/*        ADDObjDM.setBE_nameEn(ADDObjDM.getBE_nameEn() + randomNumber);
        ADDObjDM.setBE_nameAr(ADDObjDM.getBE_nameAr() + randomNumber);
        ADDObjDM.setBE_email(ADDObjDM.getBE_email() + randomNumber + "@gmail.com");
        ADDObjDM.setBE_phoneNumber(ADDObjDM.getBE_phoneNumber() + randomNumber);*/

    }

    public void timestampforUpdate(AddUpdateBusinessEntityDM ADDObjDM, int randomNumber) {

        ADDObjDM.setBE_nameEn("updatedBE"+randomNumber);
        ADDObjDM.setBE_nameAr("updatedBE"+randomNumber);
        ADDObjDM.setBE_email("updatedBE"+randomNumber+"@gmail.com");
        ADDObjDM.setBE_phoneNumber("011"+randomNumber);

    }





    //locate all error messages dispalyed in the page
    @FindBy(tagName = "mat-error")
    public List<WebElement> errorMessages;



    public String getAllErrorsMessage()
    {
        String errorsMessage = "";
        for(int i = 0; i<errorMessages.size();i++)
        {
            if (errorMessages.get(i).getText().isEmpty())
                continue;
            errorsMessage = errorsMessage + errorMessages.get(i).getText();
            if (i != errorMessages.size() - 1)
                errorsMessage = errorsMessage + GeneralConstants.STRING_DELIMETER;
        }
        return errorsMessage;
}

    // get mat-select's options after locating matselect and click it
    public ArrayList<WebElement> getMatSelectOptions(WebElement matSelect)
    {
        ArrayList<WebElement> selectOptions = new ArrayList<>();

        String selectOptionsIDSString = matSelect.getAttribute("aria-owns");
        String[] selectOptionsIDs = selectOptionsIDSString.split(" ");
        for(int i=0; i<selectOptionsIDs.length; i++)
            selectOptions.add(driver.findElement(By.id(selectOptionsIDs[i])));

        return selectOptions;
    }

    // clear a multiple selection mat-select's options by unselecting all options
    public void unselectAllMatSelectOptions(WebElement matSelect)
    {
        String selectOptionsIDSString = matSelect.getAttribute("aria-owns");
        System.out.println("selectOptionsIDSString aria-owns: " + selectOptionsIDSString);
        String[] selectOptionsIDs = selectOptionsIDSString.split(" ");
        for(int i=0; i<selectOptionsIDs.length; i++) {
            if (driver.findElement(By.id(selectOptionsIDs[i])).getAttribute("class").contains("mat-selected"))
                driver.findElement(By.id(selectOptionsIDs[i])).click();
        }
    }

    // select mat-select's option(s) by displayed text
    public void  selectOptionByDisplayedText(WebElement matSelect, String displayedText)
    {
        // check if matselect is not disabled and selected option(s) are not empty
        if(matSelect.getAttribute("aria-disabled").equalsIgnoreCase(GeneralConstants.FALSE) && !displayedText.isEmpty() && displayedText != null)
        {
            matSelect.click();
            // check if dropdown is multiple selection and it is required to select more than one option that are separated with ;
            String[] selectedOptions = null;

            // check if it is a multiple select dropdown list
            if (displayedText.contains(GeneralConstants.STRING_DELIMETER))
            {
                unselectAllMatSelectOptions(matSelect);
                selectedOptions = displayedText.split(GeneralConstants.STRING_DELIMETER);
                for (int i = 0; i < selectedOptions.length; i++)
                    driver.findElement(By.xpath("//mat-option/span[contains(text(),'" + selectedOptions[i].trim() + "')]")).click();
            }
            // else it is a single-select dropdown list
            else
                driver.findElement(By.xpath("//mat-option/span[contains(text(),'" + displayedText.trim() + "')]")).click();
        }
    }

    // get mat-select's option by index after locating matselect and click it
    public void  selectOptionByindex(WebElement matSelect, String optionIndex)
    {
        // check if matselect is not disabled and selected option(s) are not empty
        if(!optionIndex.isEmpty() && optionIndex != null && matSelect.getAttribute("aria-disabled").equalsIgnoreCase(GeneralConstants.FALSE))
        {
            String selectOptionsIDSString = matSelect.getAttribute("aria-owns");
            String[] selectOptionsIDs = selectOptionsIDSString.split(GeneralConstants.STRING_DELIMETER);
            driver.findElement(By.id(selectOptionsIDs[Integer.getInteger(optionIndex)])).click();
        }
    }

     //Set checkbox value to checked or unchecked as required
    public void setCheckboxValue(WebElement checkbox, String requiredToBeChecked)
    {
        if(!requiredToBeChecked.isEmpty() && requiredToBeChecked != null && !checkbox.getAttribute("class").contains("disabled"))
            if((requiredToBeChecked.equalsIgnoreCase(GeneralConstants.TRUE) && !checkbox.getAttribute("class").contains("mat-checked"))
                || ((requiredToBeChecked.equalsIgnoreCase(GeneralConstants.FALSE) && checkbox.getAttribute("class").contains("mat-checked"))))
                    checkbox.click();
    }

    //Do not perform action on input text unless  text in test data sheet contains a values. Otherwise, keep it value as is.
    public void setTextValue(WebElement inputText, String testDataText)
    {
        if(!testDataText.isEmpty() && testDataText != null && !inputText.getAttribute("class").contains("disabled")) {
            inputText.clear();
            inputText.sendKeys(testDataText);
        }
    }




}
