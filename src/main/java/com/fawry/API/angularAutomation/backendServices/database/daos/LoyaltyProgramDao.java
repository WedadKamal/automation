package com.fawry.API.angularAutomation.backendServices.database.daos;

import com.fawry.API.angularAutomation.constants.database.LoyaltyProgDB;
import com.fawry.API.angularAutomation.dataModels.LoyaltyProgDM;
import com.fawry.API.angularAutomation.backendServices.database.DBConnection;
import com.fawry.API.angularAutomation.constants.GeneralConstants;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoyaltyProgramDao {

    public LoyaltyProgDM getLoyaltyProgDetails(String criteria, String addedOrUpdatedModel) throws SQLException, ClassNotFoundException {

        //open database connection to promo DB
        DBConnection conn = new DBConnection();
        Connection promoConection = conn.openConnection(GeneralConstants.PROMO_DB_NAME);

        //Create DB Query to selected added/updated program
        StringBuilder queryCond = new StringBuilder();
        queryCond.append("select\n" +
                "lp.creation_date as crDate\n" +
                ",lp.BASE_EARNING_PER_POINT \n" +
                ",lp.BASE_REDEMPTION_PER_POUND \n" +
                ",lp.EXPIRY_DAYS \n" +
                ",lp.NO_OF_DAYS_TO_USE \n" +
                ",lp.MINIMUM_REDEMPTION_POINTS\n" +
                ",lp.TOTAL_EARNED_POINTS \n" +
                ",lp.TOTAL_EXPIRED_POINTS \n" +
                ",lp.TOTAL_REDEEMED_POINTS \n" +
                ",lp.NAME_EN \n" +
                ",lp.NAME_AR \n" +
                ",lp.TOTAL_CANCELED_POINTS \n" +
                ",lp.BASE_CAT_EARNING_PER_POINT \n" +
                ",lp.CAT_POINTS_EXPIRY_DAYS \n" +
                ",lp.SHORT_DESC_EN \n" +
                ",lp.SHORT_DESC_AR \n" +
                ",lp.IS_CALCULATED_EXTERNAL \n" +
                ",lp.IS_SINGLE_ACCOUNT \n" +
                ",lp.SMS_TEMPLATE_EN \n" +
                ",lp.SMS_TEMPLATE_AR \n" +
                ",lp.CAN_GENERATE_CUSTOM_VOUCHER \n" +
                ",lp.ENABLE_VOUCHER_CREATION_SMS \n" +
                ",lp.ENABLE_SIGN_UP \n" +
                ",lp.LONG_DESC_EN \n" +
                ",lp.LONG_DESC_AR \n" +
                ",lp.TYPE \n" +
                ",lp.SEND_SMS_ENABLED \n" +
                ",lp.REDEMPTION_SMS_EN \n" +
                ",lp.REDEMPTION_SMS_AR \n" +
                ",lp.MERCHANT_DISCOUNT \n" +
                ",lp.CUSTOMER_PERCENTAGE \n" +
                ",lp.TOTAL_SUSPENDED_POINTS \n" +
                ",p.name_en partnerNameEn\n" +
                ",s.name_en status\n" +
                ",lccm.name_en customerCategoryMethod\n" +
                "from\n" +
                "loyalty_program lp\n" +
                "left JOIN partner p on lp.partner_id = p.id\n" +
                "left JOIN lk_status s on lp.status_id = s.id\n" +
                "left JOIN lk_customer_category_method lccm on lp.CATEGORY_METHOD_ID = lccm.id\n" +
                "where ");
        if(addedOrUpdatedModel.equalsIgnoreCase(GeneralConstants.TEST_CASE_METHOD_ADD)) {
            queryCond.append("lp.NAME_EN like '");
            queryCond.append(criteria);
            queryCond.append("'");
        }
        else if(addedOrUpdatedModel.equalsIgnoreCase(GeneralConstants.TEST_CASE_METHOD_UPDATE)) {
            queryCond.append("lp.id = ");
            queryCond.append(criteria);
        }

        // Execute query
        ResultSet loyaltyProgRS = conn.executeQueryAndGetRS(promoConection, queryCond.toString());

        // fill data returned from DB into data model
        LoyaltyProgDM progDM = new LoyaltyProgDM();
        loyaltyProgRS.next();

        progDM.setProgEnglishName(loyaltyProgRS.getString(LoyaltyProgDB.NAME_EN));
        progDM.setProgArabicName(loyaltyProgRS.getString(LoyaltyProgDB.NAME_AR));
        progDM.setProgType(loyaltyProgRS.getString(LoyaltyProgDB.TYPE));
        progDM.setCalculateEarnExternal(loyaltyProgRS.getString(LoyaltyProgDB.IS_CALCULATED_EXTERNAL).equals("1")? GeneralConstants.TRUE: GeneralConstants.FALSE);
        progDM.setEnableCustomvoucherGeneration(loyaltyProgRS.getString(LoyaltyProgDB.CAN_GENERATE_CUSTOM_VOUCHER).equals("1")? GeneralConstants.TRUE: GeneralConstants.FALSE);
        progDM.setSingleAccount(loyaltyProgRS.getString(LoyaltyProgDB.IS_SINGLE_ACCOUNT).equals("1")? GeneralConstants.TRUE: GeneralConstants.FALSE);
        progDM.setSendSMSAfterVoucherCreated(loyaltyProgRS.getString(LoyaltyProgDB.ENABLE_VOUCHER_CREATION_SMS).equals("1")? GeneralConstants.TRUE: GeneralConstants.FALSE);
        progDM.setEnablePortalSignup(loyaltyProgRS.getString(LoyaltyProgDB.ENABLE_SIGN_UP).equals("1")? GeneralConstants.TRUE: GeneralConstants.FALSE);
        progDM.setAccountType("");
        progDM.setAdvancedSettings("");
        progDM.setMerchantDiscountRatio(loyaltyProgRS.getString(LoyaltyProgDB.MERCHANT_DISCOUNT));
        progDM.setCustomerPercentage(loyaltyProgRS.getString(LoyaltyProgDB.CUSTOMER_PERCENTAGE));

        progDM.setEarningPointsValue(loyaltyProgRS.getString(LoyaltyProgDB.TOTAL_EARNED_POINTS));
        progDM.setRedemptionPointsValue(loyaltyProgRS.getString(LoyaltyProgDB.TOTAL_REDEEMED_POINTS));

        progDM.setMinimumRedemptionPoints(loyaltyProgRS.getString(LoyaltyProgDB.MINIMUM_REDEMPTION_POINTS));
        progDM.setDaysBeforeRedeem(loyaltyProgRS.getString(LoyaltyProgDB.NO_OF_DAYS_TO_USE));
        progDM.setDaysBeforeExpire(loyaltyProgRS.getString(LoyaltyProgDB.EXPIRY_DAYS));
        progDM.setCategoryMethodType(loyaltyProgRS.getString("customerCategoryMethod"));
        progDM.setCategoryEarningPoundsPerPoint(loyaltyProgRS.getString(LoyaltyProgDB.BASE_CAT_EARNING_PER_POINT));
        progDM.setCategoryPointsExpiry(loyaltyProgRS.getString(LoyaltyProgDB.CAT_POINTS_EXPIRY_DAYS));
        progDM.setHowToUseProgramEn(loyaltyProgRS.getString(LoyaltyProgDB.LONG_DESC_EN));
        progDM.setHowToUseShortDescEn(loyaltyProgRS.getString(LoyaltyProgDB.SHORT_DESC_EN));
        progDM.setHowToUseProgramAr(loyaltyProgRS.getString(LoyaltyProgDB.LONG_DESC_AR));
        progDM.setHowToUseShortDescAr(loyaltyProgRS.getString(LoyaltyProgDB.SHORT_DESC_AR));
        progDM.setSendSMSUponRedemption(loyaltyProgRS.getString(LoyaltyProgDB.SEND_SMS_ENABLED));

        //close db connection
        conn.closeDBConnection(promoConection);

        return progDM;
    }


    public ArrayList<LoyaltyProgDM> getLoyaltyProgList()
    {
        return new ArrayList<LoyaltyProgDM>();
    }

}
