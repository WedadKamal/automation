package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.dataModels.BusinessEntityLinkDM;
import net.minidev.json.JSONObject;

import java.util.ArrayList;

public class LinkBeFpPage extends MainPage{


    public void AddOJsonObjPayload(BusinessEntityLinkDM LinkBEObj, JSONObject Payload){

        ArrayList features = new ArrayList();
        HandlingArrayList(LinkBEObj.getAllow_cash_account(),features);
        HandlingArrayList(LinkBEObj.getInvoice(),features);
        HandlingArrayList(LinkBEObj.getApp_fp(),features);
        HandlingArrayList(LinkBEObj.getEstatment(),features);
        HandlingArrayList(LinkBEObj.getInstallment(),features);
        HandlingArrayList(LinkBEObj.getPrevent_multiple_customer_login(),features);
        HandlingArrayList(LinkBEObj.getPromo(),features);
        HandlingArrayList(LinkBEObj.getShipping_option(),features);
        HandlingArrayList(LinkBEObj.getStore_option(),features);
        ParentJsonObjListArrVs(Payload,"features",features);
       // Payload.put("features",features);
        HandlingJsonObj("integrationUrl",LinkBEObj.getIntegrationUrl(),Payload);

    }
}
