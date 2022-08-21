package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.dataModels.LinkBeMyAccountDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeOrderDM;
import net.minidev.json.JSONObject;

import java.util.ArrayList;

public class LinkBeOrderPage extends MainPage{



    public void AddOJsonObjPayload(LinkBeOrderDM LinkBEObj, JSONObject Payload){

        ArrayList features = new ArrayList();
        HandlingArrayList(LinkBEObj.getOrder_manage(),features);
        HandlingArrayList(LinkBEObj.getOrders_board(),features);
        HandlingArrayList(LinkBEObj.getOrder_customer(),features);
        ParentJsonObjListArrVs(Payload,"features",features);

    }







}
