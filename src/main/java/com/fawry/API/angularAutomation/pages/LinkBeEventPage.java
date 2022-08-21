package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.dataModels.LinkBeEventDm;
import com.fawry.API.angularAutomation.dataModels.LinkBeInvDM;
import com.fawry.API.angularAutomation.dataModels.MainDataModel;
import net.minidev.json.JSONObject;

import java.util.ArrayList;

public class LinkBeEventPage extends MainPage {

    public void AddOJsonObjPayload(LinkBeEventDm LinkBEObj, JSONObject Payload){

        ArrayList features = new ArrayList();
        HandlingArrayList(LinkBEObj.getApp_event(),features);
        HandlingArrayList(LinkBEObj.getEvent(),features);
        HandlingArrayList(LinkBEObj.getEvent_category(),features);
        ParentJsonObjListArrVs(Payload,"features",features);

    }
}
