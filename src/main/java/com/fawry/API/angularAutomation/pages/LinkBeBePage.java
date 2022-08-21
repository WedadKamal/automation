package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.dataModels.LinkBeBeDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeInvDM;
import net.minidev.json.JSONObject;

import java.util.ArrayList;

public class LinkBeBePage extends MainPage{
    public void AddOJsonObjPayload(LinkBeBeDM LinkBEObj, JSONObject Payload){

        ArrayList features = new ArrayList();
        HandlingArrayList(LinkBEObj.getApp_be_profile(),features);
        HandlingArrayList(LinkBEObj.getProfile(),features);
        ParentJsonObjListArrVs(Payload,"features",features);

    }
}
