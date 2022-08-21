package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.dataModels.BusinessEntityLinkDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeInvDM;
import net.minidev.json.JSONObject;

import java.util.ArrayList;

public class LinkBeInvPage extends MainPage{

    public void AddOJsonObjPayload(LinkBeInvDM LinkBEObj, JSONObject Payload){

        ArrayList features = new ArrayList();
        HandlingArrayList(LinkBEObj.getApp_inv(),features);
        HandlingArrayList(LinkBEObj.getSingle_invoice(),features);
        HandlingArrayList(LinkBEObj.getRecurring_invoice(),features);
        HandlingArrayList(LinkBEObj.getGroup_invoice(),features);
        HandlingArrayList(LinkBEObj.getPayment_link(),features);
        HandlingArrayList(LinkBEObj.getSegregate_user_access(),features);
        ParentJsonObjListArrVs(Payload,"features",features);

    }
}
