package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.dataModels.LinkBeOrderDM;
import com.fawry.API.angularAutomation.dataModels.LinkBeProductDM;
import net.minidev.json.JSONObject;

import java.util.ArrayList;

public class LinkBeProductPage extends MainPage{
    public void AddOJsonObjPayload(LinkBeProductDM LinkBEObj, JSONObject Payload){
        ArrayList features = new ArrayList();
        HandlingArrayList(LinkBEObj.getProduct(),features);
        HandlingArrayList(LinkBEObj.getTax(),features);
        HandlingArrayList(LinkBEObj.getApp_product(),features);
        HandlingArrayList(LinkBEObj.getReview(),features);
        HandlingArrayList(LinkBEObj.getBrand(),features);
        HandlingArrayList(LinkBEObj.getProduct_category(),features);
        HandlingArrayList(LinkBEObj.getProduct_type(),features);
        HandlingArrayList(LinkBEObj.getBranch_cat_product_price(),features);
        HandlingArrayList(LinkBEObj.getProduct_video(),features);
        HandlingArrayList(LinkBEObj.getProduct_gender(),features);
        HandlingArrayList(LinkBEObj.getProduct_tag(),features);
        HandlingArrayList(LinkBEObj.getProduct_measure(),features);
        HandlingArrayList(LinkBEObj.getProduct_variant(),features);
        HandlingArrayList(LinkBEObj.getProduct_inventory(),features);
        HandlingArrayList(LinkBEObj.getBranch_product_stock(),features);
        HandlingArrayList(LinkBEObj.getBranch_product_stock_reset(),features);
        ParentJsonObjListArrVs(Payload,"features",features);

    }
}
