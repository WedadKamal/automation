package com.fawry.API.angularAutomation.backendServices;

import com.fawry.API.angularAutomation.backendServices.database.services.BEService;
import com.fawry.API.angularAutomation.backendServices.database.services.BeFeaturesService;
import com.fawry.API.angularAutomation.backendServices.database.services.LoyaltyProgService;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.dataModels.BusinessEntityLinkDM;
import com.fawry.API.angularAutomation.dataModels.LoyaltyProgDM;
import com.fawry.API.angularAutomation.utils.Log;

import java.util.ArrayList;
import java.util.List;

public class ServicesDelegate {

    public ServicesDelegate()
    {
        Log.info(" *******   Create an instance of ServiceDelegate to start backend verification     ******** ");
    }

    public LoyaltyProgDM getLoyaltyProgDetails(String criteria, String addOrUpdateModel)
    {
        LoyaltyProgDM loyaltyProgram = null;
        try {
            LoyaltyProgService lpService = new LoyaltyProgService();
            loyaltyProgram = lpService.getLoyaltyProgDetails(criteria, addOrUpdateModel);
        }
        catch (Exception e)
        {
            Log.error("ERROR occured in " + new Object() {}
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
        }
        return loyaltyProgram;
    }

    public ArrayList<LoyaltyProgDM> getLoyaltyProgList()
    {
        ArrayList<LoyaltyProgDM> loyaltyProgramsList = null;
        try {
            LoyaltyProgService lpService = new LoyaltyProgService();
            loyaltyProgramsList = lpService.getLoyaltyProgList();
        }
        catch (Exception e)
        {
            Log.error("ERROR occured in " + new Object() {}
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
        }
        return loyaltyProgramsList;
    }

    public AddUpdateBusinessEntityDM getBEDetails(String criteria, String addOrUpdateModel)
    {
        AddUpdateBusinessEntityDM BusinessEntity = null;
        try {
            BEService BeService = new BEService();
            BusinessEntity = BeService.getBEDetails(criteria, addOrUpdateModel);
        }
        catch (Exception e)
        {
            Log.error("ERROR occured in " + new Object() {}
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
        }
        return BusinessEntity;
    }

    public List<String> getBEFeatures(String criteria, String addOrUpdateModel)
    {
        List<String> BusinessEntityFeatures = null;
        try {
            BeFeaturesService BeFeaturesService = new BeFeaturesService();
             BusinessEntityFeatures = BeFeaturesService.getBEFeatures(criteria, addOrUpdateModel);
        }
        catch (Exception e)
        {
            Log.error("ERROR occured in " + new Object() {}
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
        }
        return BusinessEntityFeatures;
    }

    public ArrayList<AddUpdateBusinessEntityDM> getBusinessEntityList()
    {
        ArrayList<AddUpdateBusinessEntityDM> BusinessEntityList = null;
        try {
            BEService beService = new BEService();
            BusinessEntityList = beService.getBusinessEntityList();
        }
        catch (Exception e)
        {
            Log.error("ERROR occured in " + new Object() {}
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
        }
        return BusinessEntityList;
    }
	

}
