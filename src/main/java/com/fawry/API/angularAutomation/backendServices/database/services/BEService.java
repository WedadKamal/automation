package com.fawry.API.angularAutomation.backendServices.database.services;

import com.fawry.API.angularAutomation.backendServices.database.daos.BEDaos;
import com.fawry.API.angularAutomation.backendServices.database.daos.LoyaltyProgramDao;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.dataModels.LoyaltyProgDM;

import java.sql.SQLException;
import java.util.ArrayList;

public class BEService {

    public AddUpdateBusinessEntityDM getBEDetails(String criteria, String addOrUpdateModel) throws SQLException, ClassNotFoundException {
        BEDaos BEDAO = new BEDaos();
        AddUpdateBusinessEntityDM BusinessEntity = BEDAO.getBEDetails(criteria, addOrUpdateModel);
        return BusinessEntity;
    }


    public ArrayList<AddUpdateBusinessEntityDM> getBusinessEntityList()
    {
        BEDaos BEDAO = new BEDaos();
        ArrayList<AddUpdateBusinessEntityDM> loyaltyProgramsList = BEDAO.getBusinessEntityList();
        return loyaltyProgramsList;
    }
}
