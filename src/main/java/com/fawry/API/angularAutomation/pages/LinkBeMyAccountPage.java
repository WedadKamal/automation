package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.dataModels.LinkBeMyAccountDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeStoreDM;
import net.minidev.json.JSONObject;

import java.util.ArrayList;

public class LinkBeMyAccountPage extends MainPage{
    public void AddOJsonObjPayload(LinkBeMyAccountDM LinkBEObj, JSONObject Payload){

        ArrayList features = new ArrayList();
        HandlingArrayList(LinkBEObj.getMy_account_parent(),features);
        HandlingArrayList(LinkBEObj.getMy_account(),features);
        ParentJsonObjListArrVs(Payload,"features",features);

    }
}
