package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.dataModels.LinkBeStoreDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeUsersDM;
import net.minidev.json.JSONObject;

import java.util.ArrayList;

public class LinkBeStorePage extends MainPage{
    public void AddOJsonObjPayload(LinkBeStoreDM LinkBEObj, JSONObject Payload){

        ArrayList features = new ArrayList();
        HandlingArrayList(LinkBEObj.getDynamic_page(),features);
        HandlingArrayList(LinkBEObj.getStore(),features);
        HandlingArrayList(LinkBEObj.getAdvertisement(),features);
        HandlingArrayList(LinkBEObj.getStore_setup(),features);
        ParentJsonObjListArrVs(Payload,"features",features);

    }
}
