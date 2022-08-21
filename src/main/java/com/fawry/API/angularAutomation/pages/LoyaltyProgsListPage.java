package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.utils.Log;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoyaltyProgsListPage extends MainPage
{
    //invoke parent's constructor
    public LoyaltyProgsListPage(WebDriver driver, NgWebDriver ngWebDriver)
    {
        super(driver, ngWebDriver);
    }

    // Initialize web elements
    @FindBy(id = "addNewProgramBtn")
    WebElement addNewProgramBtn;


    @FindBy(id = "menu-Btn")
    WebElement actionsMenuBtn;

    @FindBy(id = "updateProgramBtn")
    WebElement updateProgBtn;

    //  list page's actions
    public String selectAddNewLoyaltypProg()
    {
        try
        {
            addNewProgramBtn.sendKeys(Keys.RETURN);
        }
        catch (Exception e)
        {
            Log.error("Error occured in " + new Object() {}
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }

    public String selectFirstLoyaltypProgForUpdate()
    {
        try {
            actionsMenuBtn.click();
            updateProgBtn.click();
        }
        catch (Exception e)
        {
            Log.error("Error occured in " + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
                return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;

    }

    public String checkProgramExistsInProgList(String progName)
    {
        try {
            String progNameInTable = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'" + progName + "')]")).getText();
        } catch (Exception e)
        {
            Log.error("Error occured in " + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }

}
