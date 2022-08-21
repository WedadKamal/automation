package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.dataModels.BusinessEntityLinkDM;
import com.fawry.API.angularAutomation.dataModels.LinkBePromoDM;
import net.minidev.json.JSONObject;

import java.util.ArrayList;

public class LinkBePromoPage extends MainPage{

    public void AddOJsonObjPayload(LinkBePromoDM LinkBEObj, JSONObject Payload){

        ArrayList features = new ArrayList();
        HandlingArrayList(LinkBEObj.getApp_promo_be(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_deal(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_deal_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_deal_view(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_customer_offer(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_customer_offer_campaign(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_campaign_view(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_campaign_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_customer_offer_discount_code(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_customer_offer_discount_view(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_customer_offer_discount_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_product(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_product_feature(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_product_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_product_view(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_category_feature(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_category_view(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_category_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_branch(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_branch_view(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_branch_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_emp(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_emp_view(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_emp_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_redemption_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_redemption_problem(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_redemption_coupon_operation(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_redemption_coupon_redemption(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_redemption_emp_redemption(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_loyalty(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_loyalty_program(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_loyalty_program_view(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_loyalty_program_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_loyalty_customer(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_loyalty_customer_view(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_loyalty_customer_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_loyalty_offer(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_loyalty_offer_view(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_loyalty_offer_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_loyalty_reports(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_loyalty_points(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_loyalty_points_view(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_loyalty_points_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_installment(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_installment_bank(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_installment_direct(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_installment_bank_view(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_installment_bank_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_installment_direct_view(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_installment_direct_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_static_pages(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_static_pages_view(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_static_pages_manage(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_accounts(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_reconciliation(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_reports(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_accounting(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_audit_trail_report(),features);
        HandlingArrayList(LinkBEObj.getApp_promo_dashboard(),features);
        ParentJsonObjListArrVs(Payload,"features",features);
        HandlingJsonObj("integrationUrl",LinkBEObj.getIntegrationUrl(),Payload);

    }
}
