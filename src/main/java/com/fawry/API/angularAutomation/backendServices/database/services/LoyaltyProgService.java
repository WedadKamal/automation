package com.fawry.API.angularAutomation.backendServices.database.services;

import com.fawry.API.angularAutomation.backendServices.database.daos.LoyaltyProgramDao;
import com.fawry.API.angularAutomation.dataModels.LoyaltyProgDM;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoyaltyProgService {
    public LoyaltyProgDM getLoyaltyProgDetails(String criteria, String addOrUpdateModel) throws SQLException, ClassNotFoundException {
        LoyaltyProgramDao lpDAO = new LoyaltyProgramDao();
        LoyaltyProgDM loyaltyProgram = lpDAO.getLoyaltyProgDetails(criteria, addOrUpdateModel);
        return loyaltyProgram;
    }

    public ArrayList<LoyaltyProgDM> getLoyaltyProgList()
    {
        LoyaltyProgramDao lpDAO = new LoyaltyProgramDao();
        ArrayList<LoyaltyProgDM> loyaltyProgramsList = lpDAO.getLoyaltyProgList();
        return loyaltyProgramsList;
    }

}
