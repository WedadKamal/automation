package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.dataModels.LinkBeBranchDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeCallCenterDM;
import net.minidev.json.JSONObject;

import java.util.ArrayList;

public class LinkBeCallCenterPage extends MainPage{

    public void AddOJsonObjPayload(LinkBeCallCenterDM LinkBEObj, JSONObject Payload){

        ArrayList features = new ArrayList();
        HandlingArrayList(LinkBEObj.getApp_shop_callcenter(),features);
        ParentJsonObjListArrVs(Payload,"features",features);

    }
}
