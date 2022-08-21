package com.fawry.API.angularAutomation.backendServices.database.services;

import com.fawry.API.angularAutomation.backendServices.database.daos.BEDaos;
import com.fawry.API.angularAutomation.backendServices.database.daos.BeFeaturesDaos;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.dataModels.BusinessEntityLinkDM;

import java.sql.SQLException;
import java.util.List;

public class BeFeaturesService {

    public List<String> getBEFeatures(String criteria, String addOrUpdateModel) throws SQLException, ClassNotFoundException {
        BeFeaturesDaos BEDAO = new BeFeaturesDaos();
        List<String> BusinessEntityFeatures = BEDAO.getBEFeatures(criteria, addOrUpdateModel);
        return BusinessEntityFeatures;
    }
}
