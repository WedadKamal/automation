package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.dataModels.LinkBeCallCenterDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeComplainDm;
import net.minidev.json.JSONObject;

import java.util.ArrayList;

public class LinkBeComplainPage extends MainPage{
    public void AddOJsonObjPayload(LinkBeComplainDm LinkBEObj, JSONObject Payload){

        ArrayList features = new ArrayList();
        HandlingArrayList(LinkBEObj.getApp_complaint(),features);
        ParentJsonObjListArrVs(Payload,"features",features);

    }
}
