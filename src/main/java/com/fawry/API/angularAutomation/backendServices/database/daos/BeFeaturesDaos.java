package com.fawry.API.angularAutomation.backendServices.database.daos;

import com.fawry.API.angularAutomation.backendServices.database.DBConnection;
import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.constants.database.BusinessEntityDB;
import com.fawry.API.angularAutomation.constants.database.BusinessEntityFeaturesDB;
import com.fawry.API.angularAutomation.constants.database.LoyaltyProgDB;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.dataModels.BusinessEntityLinkDM;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BeFeaturesDaos {

    public List<String> getBEFeatures(String criteria, String addedOrUpdatedModel) throws SQLException, ClassNotFoundException {

        //open database connection to promo DB
        DBConnection conn = new DBConnection();
        Connection BusinessEntityConection = conn.openConnection(GeneralConstants.USERS_DB_NAME);

        //Create DB Query to selected added/updated BE
        StringBuilder queryCond = new StringBuilder();

        queryCond.append( "select BUSINESS_ENTITY.ID, BUSINESS_ENTITY.NAME_EN ,\n" +
                "FEATURE.CODE AS FEATURE_CODE from BUSINESS_ENTITY\n" +
                "left join BUSINESS_ENTITY_FEATURE\n" +
                "on BUSINESS_ENTITY.ID = BUSINESS_ENTITY_FEATURE.BUSINESS_ENTITY_ID\n" +
                "\n" +
                "left join FEATURE\n" +
                "on BUSINESS_ENTITY_FEATURE.FEATURE_ID = FEATURE.ID\n" +
                "\n" +
                "where ");
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

        ResultSet BusinessEntityRS = conn.executeQueryAndGetRS(BusinessEntityConection, queryCond.toString());
        BusinessEntityLinkDM BeLinkDM = new BusinessEntityLinkDM();
        List<String> lock = new ArrayList<String>();
        while (BusinessEntityRS.next()){

            lock.add(BusinessEntityRS.getString(BusinessEntityFeaturesDB.FEATURE_CODE));
        }


   /*     System.out.println(lock.get(0));
        System.out.println(lock.get(1));*/
        //close db connection
        conn.closeDBConnection(BusinessEntityConection);

        return lock;

    }
}
