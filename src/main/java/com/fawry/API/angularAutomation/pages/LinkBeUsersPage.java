package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.dataModels.BusinessEntityLinkDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeUsersDM;
import net.minidev.json.JSONObject;

import java.util.ArrayList;

public class LinkBeUsersPage extends MainPage{

    public void AddOJsonObjPayload(LinkBeUsersDM LinkBEObj, JSONObject Payload){

        ArrayList features = new ArrayList();
        HandlingArrayList(LinkBEObj.getApp_user(),features);
        HandlingArrayList(LinkBEObj.getUser(),features);
        HandlingArrayList(LinkBEObj.getUser_role(),features);
        ParentJsonObjListArrVs(Payload,"features",features);
        HandlingJsonObj("integrationUrl",LinkBEObj.getIntegrationUrl(),Payload);

    }
}
