package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.dataModels.LoyaltyProgDM;
import com.fawry.API.angularAutomation.utils.Log;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoyaltyProgDetailsPage extends MainPage
{
    //invoke parent's constructor
    public LoyaltyProgDetailsPage(WebDriver driver, NgWebDriver ngWebDriver)
    {
        super(driver, ngWebDriver);
    }

    // Initialize web elements
    @FindBy(name = "LocalLoyaltyProgramNameEn")
    WebElement loyaltyProgNameEnText;

    @FindBy(name = "loyaltyProgramNameAr")
    WebElement loyaltyProgNameArText;

    @FindBy(name = "loyaltyProgramType")
    WebElement loyaltyProgramType;

    @FindBy(name = "isCalculatedExternal")
    WebElement isCalculatedExternal;

    @FindBy(name = "canGenerateCustomVoucher")
    WebElement canGenerateCustomVoucher;

    @FindBy(name = "isSingleAccount")
    WebElement isSingleAccount;

    @FindBy(name = "enableSendSMSForVoucherCreation")
    WebElement enableSendSMSForVoucherCreation;

    @FindBy(name = "enableSignUp")
    WebElement enableSignUp;

    @FindBy(name = "accountType")
    WebElement accountType;

    @FindBy(name = "advanced")
    WebElement advancedSettings;

    @FindBy(name = "merchantDiscount")
    WebElement merchantDiscount;

    @FindBy(name = "customerPercentage")
    WebElement customerPercentage;

    @FindBy(name = "loyaltyProgramEarningPerPoint")
    WebElement loyaltyProgramEarningPerPoint;

    @FindBy(name = "loyaltyProgramRedeemPerPoint")
    WebElement loyaltyProgramRedeemPerPoint;

    @FindBy(name = "loyaltyProgramMinimumRedemption")
    WebElement loyaltyProgramMinimumRedemption;

    @FindBy(name = "loyaltyProgramNumberOfDaysToUse")
    WebElement loyaltyProgramNumberOfDaysToUse;

    @FindBy(name = "loyaltyProgramExpiryDays")
    WebElement loyaltyProgramExpiryDays;

    @FindBy(name = "localCustomerCategoryMethod")
    WebElement localCustomerCategoryMethod;

    @FindBy(name = "baseCategoryEarningPerPoi")
    WebElement baseCategoryEarningPerPoint;

    @FindBy(name = "loyaltyProgramExpiryDays")
    WebElement categoryPointsExpDays;

    @FindBy(xpath = "//div[contains(text(),'English content')]")
    WebElement englishContentTab;

    @FindBy(xpath = "//mat-tab-body/div[1]/div[1]/div[2]/div[3]/textarea[1]")
    WebElement englishContentText;

    @FindBy(name = "shortDescEn")
    WebElement shortDescEn;

    @FindBy(xpath = "//div[contains(text(),'Arabic contnet')]")
    WebElement arabicContentTab;

    @FindBy(xpath = "//mat-tab-body/div[1]/div[1]/div[2]/div[3]/textarea[1]")
    WebElement arabicContentText;

    @FindBy(name = "shortDescAr")
    WebElement shortDescAr;

    @FindBy(name = "enableSendSms")
    WebElement enableSendSms;

    @FindBy(id = "addProgramAndCloseBtn")
    WebElement addProgramAndCloseBtn;

    @FindBy(id = "addProgramAndContinueBtn")
    WebElement addProgramAndContinueBtn;


    // List page's actions

    //Add/Update new loyalty program
    public String setLoyaltyProgDetails(LoyaltyProgDM progDM)
    {
        System.out.println("progDM.getTestCaseTitle() " + progDM.getTestCaseTitle());
        String errorsMessage = "";
        try {
            setTextValue(loyaltyProgNameEnText, progDM.getProgEnglishName());
            setTextValue(loyaltyProgNameArText, progDM.getProgArabicName());

            selectOptionByDisplayedText(loyaltyProgramType, progDM.getProgType());
//            selectOptionByindex(loyaltyProgramType, 0);

            if(progDM.getProgType().equalsIgnoreCase("AMOUNT"))
                setCheckboxValue(isCalculatedExternal, progDM.getCalculateEarnExternal());
            setCheckboxValue(canGenerateCustomVoucher, progDM.getEnableCustomvoucherGeneration());
            setCheckboxValue(isSingleAccount, progDM.getSingleAccount());
            setCheckboxValue(enableSendSMSForVoucherCreation, progDM.getSendSMSAfterVoucherCreated());
            setCheckboxValue(enableSignUp, progDM.getEnablePortalSignup());

            selectOptionByDisplayedText(accountType, progDM.getAccountType());
            accountType.sendKeys(Keys.ESCAPE);

            if(!isCalculatedExternal.getAttribute("class").contains("mat-checked"))
            {
                setCheckboxValue(advancedSettings, progDM.getAdvancedSettings());
                if (progDM.getAdvancedSettings().equalsIgnoreCase(GeneralConstants.TRUE))
                {
                    setTextValue(merchantDiscount, progDM.getMerchantDiscountRatio());
                    setTextValue(customerPercentage, progDM.getCustomerPercentage());
                }
            }

            if(progDM.getProgType().equalsIgnoreCase("AMOUNT") && !isCalculatedExternal.getAttribute("class").contains("mat-checked"))
                setTextValue(loyaltyProgramEarningPerPoint, progDM.getEarningPointsValue());
            setTextValue(loyaltyProgramRedeemPerPoint, progDM.getRedemptionPointsValue());

            setTextValue(loyaltyProgramMinimumRedemption, progDM.getMinimumRedemptionPoints());
            setTextValue(loyaltyProgramNumberOfDaysToUse, progDM.getDaysBeforeRedeem());
            setTextValue(loyaltyProgramExpiryDays, progDM.getDaysBeforeExpire());

            selectOptionByDisplayedText(localCustomerCategoryMethod, progDM.getCategoryMethodType());
            if(progDM.getCategoryMethodType().equalsIgnoreCase("POINTS"))
            {
                setTextValue(baseCategoryEarningPerPoint, progDM.getCategoryEarningPoundsPerPoint());
                setTextValue(categoryPointsExpDays, progDM.getCategoryPointsExpiry());
            }

            englishContentTab.click();
//            englishContentText.sendKeys(progDM.getHowToUseProgramEn());
            setTextValue(shortDescEn, progDM.getHowToUseShortDescEn());

            arabicContentTab.click();
//            arabicContentText.sendKeys(progDM.getHowToUseProgramAr());
            setTextValue(shortDescAr, progDM.getHowToUseShortDescAr());

            setCheckboxValue(enableSendSms, progDM.getSendSMSUponRedemption());

            addProgramAndCloseBtn.click();

            //Check if there is any error message displayed in page
            if(!progDM.getExpectedMessage().equalsIgnoreCase(GeneralConstants.SUCCESS)) {
                errorsMessage = getAllErrorsMessage();
                System.out.println("errorMessages.size() " + errorMessages.size());

                if(!errorsMessage.isEmpty())
                    return errorsMessage;
            }

        } catch (Exception e) {
            Log.error("Error occured in " + new Object() {}
                    .getClass()
                    .getEnclosingMethod()
                    .getName() + " for testcase *** " +  progDM.getTestCaseTitle() + " ***", e);
            return GeneralConstants.FAILED;
        }


        return GeneralConstants.SUCCESS;
    }



}
