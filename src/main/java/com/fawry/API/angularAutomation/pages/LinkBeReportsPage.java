package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.dataModels.LinkBeReportsDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeStoreDM;
import net.minidev.json.JSONObject;

import java.util.ArrayList;

public class LinkBeReportsPage extends MainPage{

    public void AddOJsonObjPayload(LinkBeReportsDM LinkBEObj, JSONObject Payload){

        ArrayList features = new ArrayList();
        HandlingArrayList(LinkBEObj.getApp_report(),features);
        HandlingArrayList(LinkBEObj.getReport_event(),features);
        HandlingArrayList(LinkBEObj.getBranches_reports(),features);
        HandlingArrayList(LinkBEObj.getBranch_shifts_reports(),features);
        ParentJsonObjListArrVs(Payload,"features",features);

    }
}
