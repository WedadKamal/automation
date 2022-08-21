package com.fawry.API.angularAutomation.backendServices.database.daos;

import com.fawry.API.angularAutomation.backendServices.database.DBConnection;
import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.constants.database.BusinessEntityDB;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.dataModels.LoyaltyProgDM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BEDaos {

    public AddUpdateBusinessEntityDM getBEDetails(String criteria, String addedOrUpdatedModel) throws SQLException, ClassNotFoundException {

        //open database connection to promo DB
        DBConnection conn = new DBConnection();
        Connection BusinessEntityConection = conn.openConnection(GeneralConstants.BUSINESSENTITY_DB_NAME);

        //Create DB Query to selected added/updated BE
        StringBuilder queryCond = new StringBuilder();

        queryCond.append( "select BUSINESS_ENTITY.ID ,BUSINESS_ENTITY.NAME_EN, BUSINESS_ENTITY.NAME_AR, BUSINESS_ENTITY.PHONE_NUMBER, BUSINESS_ENTITY.EMAIL,BUSINESS_ENTITY.LOGO_URL,BUSINESS_ENTITY.STATUS_ID,BUSINESS_ENTITY.CIF,BUSINESS_ENTITY.CREATION_DATE,\n" +
                "LK_CSP.ID as CSP_ID, LK_CSP.CODE as CSP_CODE,LK_CSP.NAME_EN as CSP_NAME_EN,LK_CSP.NAME_AR as CSP_NAME_AR,LK_CSP.IS_DEFAULT as CSP_IS_DEFAULT ,LK_CSP.CHANNEL_CODE as CSP_CHANNEL_CODE ,LK_CSP.SOF_URL as CSP_SOF_URL,LK_CSP.SENDER as CSP_SENDER,\n" +
                "LK_BUSINESS_ENTITY_CATEGORY.ID as CATEGOTY_ID ,LK_BUSINESS_ENTITY_CATEGORY.CODE as CATEGOTY_CODE ,LK_BUSINESS_ENTITY_CATEGORY.NAME_EN as CATEGOTY_NAME_EN ,LK_BUSINESS_ENTITY_CATEGORY.NAME_AR as CATEGOTY_NAME_AR ,\n" +
                "LK_BUSINESS_ENTITY_TYPE.ID as TYPE_ID ,LK_BUSINESS_ENTITY_TYPE.CODE as TYPE_CODE,LK_BUSINESS_ENTITY_TYPE.NAME_AR as TYPE_NAME_AR,LK_BUSINESS_ENTITY_TYPE.NAME_EN as TYPE_NAME_EN,\n" +
                "LK_CHANNEL.ID as CHANNEL_ID,LK_CHANNEL.CODE as CHANNEL_CODE,LK_CHANNEL.NAME_EN as CHANNEL_NAME_EN,LK_CHANNEL.NAME_AR as CHANNEL_NAME_AR,\n" +
                "BUSINESS_ENTITY_ADDRESS.ADDRESS as ADDRESS,\n" +
                "LK_AREA.ID as AREA_ID,LK_AREA.CODE as AREA_CODE,LK_AREA.NAME_EN as AREA_NAME_EN,LK_AREA.NAME_AR as AREA_NAME_AR,\n" +
                "LK_REGION.ID as REGION_ID,LK_REGION.CODE as REGION_CODE,LK_REGION.NAME_EN as REGION_NAME_EN,LK_REGION.NAME_AR as REGION_NAME_AR,\n" +
                "SOCIAL_LINKS.FACEBOOK as FACEBOOK ,SOCIAL_LINKS.TWITTER as TWITTER ,SOCIAL_LINKS.INSTAGRAM as INSTAGRAM ,SOCIAL_LINKS.YOUTUBE as YOUTUBE ,SOCIAL_LINKS.WEBSITE as WEBSITE,\n" +
                "ACCOUNT.ACCOUNT_NUMBER AS ACCOUNT_NUMBER,ACCOUNT.ID As ACCOUNT_ID ,ACCOUNT.BUSINESS_ENTITY_ID AS ACCOUNT_BUSINESS_ENTITY_ID,ACCOUNT.BRANCH_ID AS ACCOUNT_BRANCH_ID ,ACCOUNT.TERMINAL_ID AS ACCOUNT_TERMINAL_ID ,ACCOUNT.CLEARING_ACCOUNT_ID AS ACCOUNT_CLEARING_ACCOUNT_ID ,ACCOUNT.CLEARING_TERM AS ACCOUNT_CLEARING_TERM\n" +
                ",ACCOUNT.CLEARING_NO_OF_DAYS AS ACCOUNT_CLEARING_NO_OF_DAYS ,ACCOUNT.ACCOUNT_BUSINESS_ENTITY_ID AS ACC_ACCOUNT_BUSINESS_ENTITY_ID,ACCOUNT.TYPE AS ACCOUNT_TYPE ,ACCOUNT.PARENT_ID AS ACCOUNT_PARENT_ID ,ACCOUNT.STATUS AS ACCOUNT_STATUS\n" +
                "                from BUSINESS_ENTITY LEFT join LK_CSP\n" +
                "              on BUSINESS_ENTITY.CSP_ID = LK_CSP.ID\n" +
                "              \n" +
                "              LEFT JOIN LK_BUSINESS_ENTITY_CATEGORY\n" +
                "              on BUSINESS_ENTITY.BUSINESS_ENTITY_CATEGORY_ID = LK_BUSINESS_ENTITY_CATEGORY.ID\n" +
                "              \n" +
                "              LEFT JOIN LK_BUSINESS_ENTITY_TYPE\n" +
                "              on BUSINESS_ENTITY.TYPE_ID = LK_BUSINESS_ENTITY_TYPE.ID\n" +
                "              \n" +
                "              LEFT JOIN BUSINESS_ENTITY_CHANNEL_CONFIG\n" +
                "              on BUSINESS_ENTITY.ID = BUSINESS_ENTITY_CHANNEL_CONFIG.BUSINESS_ENTITY_ID\n" +
                "              \n" +
                "              LEFT JOIN LK_CHANNEL\n" +
                "              on BUSINESS_ENTITY_CHANNEL_CONFIG.CHANNEL_ID = LK_CHANNEL.ID\n" +
                "              \n" +
                "              LEFT JOIN BUSINESS_ENTITY_ADDRESS\n" +
                "              on BUSINESS_ENTITY.ID = BUSINESS_ENTITY_ADDRESS.BUSINESS_ENTITY_ID\n" +
                "              \n" +
                "              LEFT JOIN LK_AREA\n" +
                "              on BUSINESS_ENTITY_ADDRESS.AREA_ID = LK_AREA.ID\n" +
                "              \n" +
                "              LEFT JOIN LK_REGION\n" +
                "              on LK_AREA.REGION_ID = LK_REGION.ID\n" +
                "              \n" +
                "              LEFT JOIN SOCIAL_LINKS\n" +
                "              on BUSINESS_ENTITY.ID = SOCIAL_LINKS.BUSINESS_ENTITY_ID\n" +
                "              \n" +
                "              LEFT JOIN ACCOUNT\n" +
                "              ON BUSINESS_ENTITY.ID = ACCOUNT.BUSINESS_ENTITY_ID\n" +
                "              \n" +
                "              where ");
        if(addedOrUpdatedModel.equalsIgnoreCase(GeneralConstants.TEST_CASE_METHOD_ADD)) {
            queryCond.append("BUSINESS_ENTITY.NAME_EN = '");
            queryCond.append(criteria);
            queryCond.append("'");
        }
        else if(addedOrUpdatedModel.equalsIgnoreCase(GeneralConstants.TEST_CASE_METHOD_UPDATE)) {
            queryCond.append("BUSINESS_ENTITY.EMAIL = '");
            queryCond.append(criteria);
            queryCond.append("'");
        }

        // Execute query
        ResultSet BusinessEntityRS = conn.executeQueryAndGetRS(BusinessEntityConection, queryCond.toString());

        // fill data returned from DB into data model
        AddUpdateBusinessEntityDM AddBEDM = new AddUpdateBusinessEntityDM();
     //   BusinessEntityRS.getString("NAME_EN");
    //    System.out.println("row is "+BusinessEntityRS.getString("NAME_EN"));
        while (BusinessEntityRS.next()){
        System.out.println("row is "+BusinessEntityRS.getString("NAME_EN"));
         //  System.out.println("row index is "+BusinessEntityRS.get


        //AddBEDM.setCSP_id(Integer.parseInt(BusinessEntityRS.getString(BusinessEntityDB.CSP_ID)));
            AddBEDM.setBE_ID(BusinessEntityRS.getString(BusinessEntityDB.ID));
            AddBEDM.setBE_nameEn(BusinessEntityRS.getString(BusinessEntityDB.NAME_EN));
        AddBEDM.setBE_nameAr(BusinessEntityRS.getString(BusinessEntityDB.NAME_AR));
        AddBEDM.setBE_phoneNumber(BusinessEntityRS.getString(BusinessEntityDB.PHONE_NUMBER));
        AddBEDM.setBE_email(BusinessEntityRS.getString(BusinessEntityDB.EMAIL));
            AddBEDM.setType_id(BusinessEntityRS.getString(BusinessEntityDB.TYPE_ID));
        AddBEDM.setType_code(BusinessEntityRS.getString(BusinessEntityDB.TYPE_CODE));
            AddBEDM.setType_nameEn(BusinessEntityRS.getString(BusinessEntityDB.TYPE_NAME_EN));
            AddBEDM.setType_nameAr(BusinessEntityRS.getString(BusinessEntityDB.TYPE_NAME_AR));
            AddBEDM.setLogo_URI(BusinessEntityRS.getString(BusinessEntityDB.LOGO_URL));
            AddBEDM.setStatus_id(BusinessEntityRS.getString(BusinessEntityDB.STATUS_ID));
            AddBEDM.setCSP_id(BusinessEntityRS.getString(BusinessEntityDB.CSP_ID));
            AddBEDM.setCSP_code(BusinessEntityRS.getString(BusinessEntityDB.CSP_CODE));
            AddBEDM.setCSP_nameEn(BusinessEntityRS.getString(BusinessEntityDB.CSP_NAME_EN));
            AddBEDM.setCSP_nameAr(BusinessEntityRS.getString(BusinessEntityDB.CSP_NAME_AR));
            AddBEDM.setCSP_channelCode(BusinessEntityRS.getString(BusinessEntityDB.CSP_CHANNEL_CODE));
            AddBEDM.setCSP_isDefault(BusinessEntityRS.getString(BusinessEntityDB.CSP_IS_DEFAULT));
            AddBEDM.setCSP_sender(BusinessEntityRS.getString(BusinessEntityDB.CSP_SENDER));
            AddBEDM.setCSP_sofUrl(BusinessEntityRS.getString(BusinessEntityDB.CSP_SOF_URL));
            AddBEDM.setCategory_id(BusinessEntityRS.getString(BusinessEntityDB.CATEGOTY_ID));
            AddBEDM.setCategory_code(BusinessEntityRS.getString(BusinessEntityDB.CATEGOTY_CODE));
            AddBEDM.setCategory_nameEn(BusinessEntityRS.getString(BusinessEntityDB.CATEGOTY_NAME_EN));
            AddBEDM.setCategory_nameAr(BusinessEntityRS.getString(BusinessEntityDB.CATEGOTY_NAME_AR));
            AddBEDM.setChannels_INT_id(BusinessEntityRS.getString(BusinessEntityDB.CHANNEL_ID));
            AddBEDM.setChannels_INT_code(BusinessEntityRS.getString(BusinessEntityDB.CHANNEL_CODE));
            AddBEDM.setChannels_INT_nameEn(BusinessEntityRS.getString(BusinessEntityDB.CHANNEL_NAME_EN));
            AddBEDM.setChannels_INT_nameAr(BusinessEntityRS.getString(BusinessEntityDB.CHANNEL_NAME_AR));
            AddBEDM.setAddress(BusinessEntityRS.getString(BusinessEntityDB.ADDRESS));
            AddBEDM.setAddress_area_id(BusinessEntityRS.getString(BusinessEntityDB.AREA_ID));
            AddBEDM.setAddress_area_code(BusinessEntityRS.getString(BusinessEntityDB.AREA_CODE));
            AddBEDM.setAddress_area_nameEn(BusinessEntityRS.getString(BusinessEntityDB.AREA_NAME_EN));
            AddBEDM.setAddress_area_nameAr(BusinessEntityRS.getString(BusinessEntityDB.AREA_NAME_AR));
            AddBEDM.setAddress_region_id(BusinessEntityRS.getString(BusinessEntityDB.REGION_ID));
            AddBEDM.setAddress_region_code(BusinessEntityRS.getString(BusinessEntityDB.REGION_CODE));
            AddBEDM.setAddress_region_nameEn(BusinessEntityRS.getString(BusinessEntityDB.REGION_NAME_EN));
            AddBEDM.setAddress_region_nameAr(BusinessEntityRS.getString(BusinessEntityDB.REGION_NAME_AR));
            AddBEDM.setFacebook(BusinessEntityRS.getString(BusinessEntityDB.FACEBOOK));
            AddBEDM.setTwitter(BusinessEntityRS.getString(BusinessEntityDB.TWITTER));
            AddBEDM.setInstagram(BusinessEntityRS.getString(BusinessEntityDB.INSTAGRAM));
            AddBEDM.setWebsite(BusinessEntityRS.getString(BusinessEntityDB.WEBSITE));
            AddBEDM.setYoutube(BusinessEntityRS.getString(BusinessEntityDB.YOUTUBE));
            AddBEDM.setAccount_ID(BusinessEntityRS.getString(BusinessEntityDB.ACCOUNT_ID));
            AddBEDM.setAccount_Number(BusinessEntityRS.getString(BusinessEntityDB.ACCOUNT_NUMBER));
            AddBEDM.setACCOUNT_BUSINESS_ENTITY_ID(BusinessEntityRS.getString(BusinessEntityDB.ACCOUNT_BUSINESS_ENTITY_ID));
            AddBEDM.setACCOUNT_BRANCH_ID(BusinessEntityRS.getString(BusinessEntityDB.ACCOUNT_BRANCH_ID));
            AddBEDM.setACCOUNT_TERMINAL_ID(BusinessEntityRS.getString(BusinessEntityDB.ACCOUNT_TERMINAL_ID));
            AddBEDM.setACCOUNT_CLEARING_ACCOUNT_ID(BusinessEntityRS.getString(BusinessEntityDB.ACCOUNT_CLEARING_ACCOUNT_ID));
            AddBEDM.setACCOUNT_CLEARING_TERM(BusinessEntityRS.getString(BusinessEntityDB.ACCOUNT_CLEARING_TERM));
            AddBEDM.setACCOUNT_CLEARING_NO_OF_DAYS(BusinessEntityRS.getString(BusinessEntityDB.ACCOUNT_CLEARING_NO_OF_DAYS));
            AddBEDM.setACC_ACCOUNT_BUSINESS_ENTITY_ID(BusinessEntityRS.getString(BusinessEntityDB.ACC_ACCOUNT_BUSINESS_ENTITY_ID));
            AddBEDM.setACCOUNT_TYPE(BusinessEntityRS.getString(BusinessEntityDB.ACCOUNT_TYPE));
            AddBEDM.setACCOUNT_PARENT_ID(BusinessEntityRS.getString(BusinessEntityDB.ACCOUNT_PARENT_ID));
            AddBEDM.setACCOUNT_STATUS(BusinessEntityRS.getString(BusinessEntityDB.ACCOUNT_STATUS));
            AddBEDM.setCIF(BusinessEntityRS.getString(BusinessEntityDB.CIF));
            AddBEDM.setCREATION_DATE(BusinessEntityRS.getString(BusinessEntityDB.CREATION_DATE));



        }




    //close db connection
        conn.closeDBConnection(BusinessEntityConection);

        return AddBEDM;

    }

    public AddUpdateBusinessEntityDM getBECount() throws SQLException, ClassNotFoundException {

        //open database connection to promo DB
        DBConnection conn = new DBConnection();
        Connection BusinessEntityConection = conn.openConnection(GeneralConstants.BUSINESSENTITY_DB_NAME);

        //Create DB Query to selected added/updated BE
        StringBuilder queryCond = new StringBuilder();

        queryCond.append( "select *\n" +
                "from\n" +
                "BUSINESS_ENTITY");


        // Execute query
        ResultSet BusinessEntityRS = conn.executeQueryAndGetRS(BusinessEntityConection, queryCond.toString());

        // fill data returned from DB into data model
        AddUpdateBusinessEntityDM AddBEDM = new AddUpdateBusinessEntityDM();
        while (BusinessEntityRS.next()){
            //Resultset.size
            AddBEDM.setCount(BusinessEntityRS.getRow());}




        //close db connection
        conn.closeDBConnection(BusinessEntityConection);

        return AddBEDM;

    }


    public ArrayList<AddUpdateBusinessEntityDM> getBusinessEntityList()
    {
        return new ArrayList<AddUpdateBusinessEntityDM>();
    }
}
