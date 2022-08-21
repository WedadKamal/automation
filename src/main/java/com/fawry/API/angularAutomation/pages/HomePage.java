package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.utils.Log;
import com.paulhammant.ngwebdriver.NgWebDriver;
import net.minidev.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends MainPage{
    //invoke parent's constructor
    public HomePage(WebDriver driver, NgWebDriver ngWebDriver)
    {
        super(driver, ngWebDriver);
    }

    // Initialize web elements
    @FindBy(tagName= "small")
    WebElement welcomeMsg;

    @FindBy(id= "LoyaltyLink")
    public WebElement loyaltySystemsMenuItem;

    @FindBy(id= "loyaltyPrograms")
    public WebElement loyaltyProgramsMenuItem;

    @FindBy(id= "loyaltyProgramsPortalConfiguration")
    public WebElement loyaltyPortalConfigMenuItem;

    @FindBy(id= "loyaltyProgramsPortalConfiguration")
    public WebElement loyaltyProgPartnersMenuItem;

    @FindBy(id= "loyaltyProgramsPortalConfiguration")
    public WebElement loyaltyProgInputConfigMenuItem;

    @FindBy(id= "loyaltyProgramCategoriesLink")
    public WebElement loyaltyCategoriesMenuItem;

    @FindBy(id= "loyaltyProgramRulesLink")
    public WebElement loyaltyProgRulesMenuItem;

    @FindBy(id= "loyaltyProgramRulesLink")
    public WebElement loyaltyProgTransMenuItem;

    @FindBy(id= "loyaltyProgramCustomersLink")
    public WebElement loyaltyCustomersMenuItem;

    @FindBy(id= "loyaltyExternalProgramsLink")
    public WebElement loyaltyExternalProgsMenuItem;

    @FindBy(id= "loyaltyoffersLink")
    public WebElement loyaltyOffersMenuItem;

    @FindBy(linkText= "Loyalty Reports")
    public WebElement loyaltyReportsMenuItem;

    @FindBy(id= "loyaltyReportsEarningLink")
    public WebElement loyaltyEarningReportsMenuItem;

    @FindBy(id= "loyaltyReportsBurningLink")
    public WebElement loyaltyBurningReportsMenuItem;



//    list page's actions

    //get welcome message
    public String getWelcomeMsg()
    {
        return welcomeMsg.getText();
    }

    public void selectLoyaltySystemsMenuLink()
    {
        System.out.println("loyaltySystemsMenuItem.getAttribute(\"aria-expanded\") " + loyaltySystemsMenuItem.getAttribute("aria-expanded"));
        if(loyaltySystemsMenuItem.getAttribute("aria-expanded").equalsIgnoreCase("false"))
            loyaltySystemsMenuItem.click();
    }



    public void navigateToLoyaltyPrograms()
    {
        try
        {
            Log.info("Navigate to Loyalty programs page" );
            selectLoyaltySystemsMenuLink();
            loyaltyProgramsMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occured while navigating to Loyalty programs page in " + new Object() {}
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
        }
    }

    public void navigateToLoyaltyPortalConfigs()
    {
        try {
            Log.info("Navigate to Loyalty Portal Configs page" );
            selectLoyaltySystemsMenuLink();
            loyaltyPortalConfigMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occured while navigating to Loyalty Portal Configs page", e);
        }
    }

    public void navigateToLoyaltyProgramPartners()
    {
        try {
            Log.info("Navigate to Loyalty Program Partners page" );
            selectLoyaltySystemsMenuLink();
            loyaltyProgPartnersMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occured while navigating to Loyalty Program Partners page", e);        }
    }

    public void navigateToLoyaltyProgramInputConfig()
    {
        try {
            Log.info("Navigate to Loyalty Program Input Config page" );
            selectLoyaltySystemsMenuLink();
            loyaltyProgInputConfigMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occured while navigating to Loyalty Program Input Config page", e);
        }
    }

    public void navigateToLoyaltyCategories()
    {
        try {
            Log.info("Navigate to Loyalty Categories page" );
            selectLoyaltySystemsMenuLink();
            loyaltyCategoriesMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occured while navigating to Loyalty Categories page", e);
        }
    }

    public void navigateToLoyaltyProgramRules()
    {
        try {
            Log.info("Navigate to Loyalty Program Rules page" );
            selectLoyaltySystemsMenuLink();
            loyaltyProgRulesMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occured while navigating to Loyalty Program Rules page", e);
        }
    }

    public void navigateToLoyaltyProgramTrans()
    {
        try {
            Log.info("Navigate to Loyalty Program Transactions page" );
            selectLoyaltySystemsMenuLink();
            loyaltyProgTransMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occured while navigating to Loyalty Program Transactions page", e);
        }
    }

    public void navigateToLoyaltyCustomers()
    {
        try {
            Log.info("Navigate to Loyalty Customers page" );
            selectLoyaltySystemsMenuLink();
            loyaltyCustomersMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occured while navigating to Loyalty Customers page", e);
        }
    }

    public void navigateToLoyaltyExtLoyaltyProgs()
    {
        try {
            Log.info("Navigate to Loyalty external loyalty programs page" );
            selectLoyaltySystemsMenuLink();
            loyaltyExternalProgsMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occured while navigating to Loyalty External loyalty programs page", e);
        }
    }

    public void navigateToLoyaltyOffers()
    {
        try {
            Log.info("Navigate to Loyalty Offers page" );
            selectLoyaltySystemsMenuLink();
            loyaltyOffersMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occured while navigating to Loyalty Offers page", e);
        }
    }

    public void navigateToLoyaltyEarningReports()
    {
        try {
            Log.info("Navigate to Loyalty Earning reports page" );
            selectLoyaltySystemsMenuLink();
            loyaltyReportsMenuItem.click();
            loyaltyEarningReportsMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occured while navigating to Loyalty Earning reports page", e);
        }
    }

    public void navigateToLoyaltyBurningReports()
    {
        try {
            Log.info("Navigate to Loyalty Burning reports page" );
            selectLoyaltySystemsMenuLink();
            loyaltyReportsMenuItem.click();
            loyaltyBurningReportsMenuItem.click();
        } catch (Exception e) {
            Log.error("Error occured while navigating to Loyalty Burning reports page", e);
        }
    }



}
