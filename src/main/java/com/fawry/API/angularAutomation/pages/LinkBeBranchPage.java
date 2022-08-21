package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.dataModels.BusinessEntityLinkDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeBranchDM;
import net.minidev.json.JSONObject;

import java.util.ArrayList;

public class LinkBeBranchPage extends MainPage{

    public void AddOJsonObjPayload(LinkBeBranchDM LinkBEObj, JSONObject Payload){

        ArrayList features = new ArrayList();
        HandlingArrayList(LinkBEObj.getBranch_table_qr(),features);
        HandlingArrayList(LinkBEObj.getBranch_table(),features);
        HandlingArrayList(LinkBEObj.getBranch(),features);
        HandlingArrayList(LinkBEObj.getApp_be(),features);
        HandlingArrayList(LinkBEObj.getBranch_service(),features);
        HandlingArrayList(LinkBEObj.getBranch_shift(),features);
        HandlingArrayList(LinkBEObj.getBranch_coverage(),features);
        HandlingArrayList(LinkBEObj.getBranch_working_hours(),features);
        HandlingArrayList(LinkBEObj.getBranch_category(),features);
        ParentJsonObjListArrVs(Payload,"features",features);

    }
}
