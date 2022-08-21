package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.backendServices.database.daos.BEDaos;
import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.dataModels.AddUpdateBusinessEntityDM;
import com.fawry.API.angularAutomation.utils.Log;
import net.minidev.json.JSONObject;
import okhttp3.Response;
import org.openqa.selenium.WebElement;


import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class AddUpdateBusinessEntityPage extends MainPage {


    public void AddOJsonObjPayload(AddUpdateBusinessEntityDM AddBEObj,AddUpdateBusinessEntityDM DataBaseDM,Boolean ProfileCriteria, JSONObject payload,int BE_Id){


        String Unique_BE_name = AddBEObj.getBE_nameEn();
        String BE_nameAr = AddBEObj.getBE_nameAr();
        String BE_Mail = AddBEObj.getBE_email();
        String BE_PhoneNumber = AddBEObj.getBE_phoneNumber();
        String CSP_Id = AddBEObj.getCSP_id();
        String CSP_code = AddBEObj.getCSP_code();
        String CSPNameEn = AddBEObj.getCSP_nameEn();
        String CSP_NameAr = AddBEObj.getCSP_nameAr();
        String CSP_ChannelCode = AddBEObj.getCSP_channelCode();
        String CSP_IsDefault = AddBEObj.getCSP_isDefault();
        String CSP_SofYrl = AddBEObj.getCSP_sofUrl();
        String CSP_Sender = AddBEObj.getCSP_sender();
        String Category_ID = AddBEObj.getCategory_id();
        String Category_Code = AddBEObj.getCategory_code();
        String Category_NameEn = AddBEObj.getCategory_nameEn();
        String Category_NameAr = AddBEObj.getCategory_nameAr();
        String Type_ID = AddBEObj.getType_id();
        String Type_Code = AddBEObj.getType_code();
        String Type_NameEn = AddBEObj.getType_nameEn();
        String Type_NameAr = AddBEObj.getType_nameAr();
        String POS_ID = AddBEObj.getChannels_POS_id();
        String POS_CODE = AddBEObj.getChannels_POS_code();
        String POS_NameEn = AddBEObj.getChannels_POS_nameEn();
        String POS_NameAr = AddBEObj.getChannels_POS_nameAr();
        String MOB_ID = AddBEObj.getChannels_MOB_id();
        String MOB_Code = AddBEObj.getChannels_MOB_code();
        String MOB_NameEn = AddBEObj.getChannels_MOB_nameEn();
        String MOB_NameAr = AddBEObj.getChannels_MOB_nameAr();
        String INT_ID = AddBEObj.getChannels_INT_id();
        String INT_Code = AddBEObj.getChannels_INT_code();
        String INT_NameEn = AddBEObj.getChannels_INT_nameEn();
        String INT_NameAr = AddBEObj.getChannels_INT_nameAr();
        String Area_ID = AddBEObj.getAddress_area_id();
        String Area_Code = AddBEObj.getAddress_area_code();
        String Area_NameEn = AddBEObj.getAddress_area_nameEn();
        String Area_NameAr = AddBEObj.getAddress_area_nameAr();
        String Region_ID = AddBEObj.getAddress_region_id();
        String Region_Code = AddBEObj.getAddress_region_code();
        String Region_NameEn = AddBEObj.getAddress_region_nameEn();
        String Region_NameAr = AddBEObj.getAddress_region_nameAr();
        String Address = AddBEObj.getAddress();
        String Twitter = AddBEObj.getTwitter();
        String Facebook = AddBEObj.getFacebook();
        String Instagram = AddBEObj.getInstagram();
        String Youtube = AddBEObj.getYoutube();
        String Website = AddBEObj.getWebsite();
        String Status_ID = AddBEObj.getStatus_id();
        String Logo = AddBEObj.getLogo();
        String ErrorType = AddBEObj.getErrType();
        int ExpectedStatusCode = AddBEObj.getStatus_Code();

        //Database DM
        String ACCOUNT_ID = DataBaseDM.getAccount_ID();
        String ACCOUNT_NUMBER = DataBaseDM.getAccount_Number();
        String ACCOUNT_BUSINESS_ENTITY_ID = DataBaseDM.getACCOUNT_BUSINESS_ENTITY_ID();
        String ACCOUNT_BRANCH_ID = DataBaseDM.getACCOUNT_BRANCH_ID();
        String ACCOUNT_TERMINAL_ID = DataBaseDM.getACCOUNT_TERMINAL_ID();
        String ACCOUNT_CLEARING_ACCOUNT_ID = DataBaseDM.getACCOUNT_CLEARING_ACCOUNT_ID();
        String ACCOUNT_CLEARING_TERM = DataBaseDM.getACCOUNT_CLEARING_TERM();
        String ACCOUNT_CLEARING_NO_OF_DAYS = DataBaseDM.getACCOUNT_CLEARING_NO_OF_DAYS();
        String ACC_ACCOUNT_BUSINESS_ENTITY_ID = DataBaseDM.getACC_ACCOUNT_BUSINESS_ENTITY_ID();
        String ACCOUNT_TYPE = DataBaseDM.getACCOUNT_TYPE();
        String ACCOUNT_PARENT_ID = DataBaseDM.getACCOUNT_PARENT_ID();
        String LogoURI = DataBaseDM.getLogo_URI();
        String ACCOUNT_STATUS = DataBaseDM.getACCOUNT_STATUS();
        String CIF = DataBaseDM.getCIF();
        String CREATION_DATE = DataBaseDM.getCREATION_DATE();
        String internationalNumber = internationalNumber(DataBaseDM.getBE_phoneNumber());
        String nationalNumber = nationalNumber(DataBaseDM.getBE_phoneNumber());


        if (ProfileCriteria.equals(true)){
            JSONObject phoneNumber = new JSONObject();
            HandlingJsonObj("number",DataBaseDM.getBE_phoneNumber(),phoneNumber);
            HandlingJsonObj("internationalNumber","+2"+internationalNumber,phoneNumber);
            HandlingJsonObj("nationalNumber",nationalNumber,phoneNumber);
            HandlingJsonObj("e164Number","+2"+DataBaseDM.getBE_phoneNumber(),phoneNumber);
            HandlingJsonObj("countryCode","EG",phoneNumber);
            HandlingJsonObj("dialCode","+20",phoneNumber);
            ParentJsonObj(phoneNumber,"phoneNumber",payload);

        }
        else if (ProfileCriteria==false){

            HandlingJsonObj("phoneNumber", BE_PhoneNumber, payload);
        }



  /*          "number": "01298155955",
                    "internationalNumber": "+20 129 815 5955",
                    "nationalNumber": "0129 815 5955",
                    "e164Number": "+201298155955",
                    "countryCode": "EG",
                    "dialCode": "+20"*/



        JSONObject csp = new JSONObject();

        HandlingJsonObj("id", CSP_Id, csp);
        HandlingJsonObj("code", CSP_code, csp);
        HandlingJsonObj("nameAr", CSP_NameAr, csp);
        HandlingJsonObj("nameEn", CSPNameEn, csp);
        HandlingJsonObj("channelCode", CSP_ChannelCode, csp);
        HandlingJsonObj("isDefault", CSP_IsDefault, csp);
        HandlingJsonObj("sofUrl", CSP_SofYrl, csp);
        HandlingJsonObj("sender", CSP_Sender, csp);






        JSONObject ChannelsPOS = new JSONObject();
        JSONObject ChannelsMOB = new JSONObject();
        JSONObject ChannelsINT = new JSONObject();

        HandlingJsonObj("id", POS_ID, ChannelsPOS);
        HandlingJsonObj("code", POS_CODE, ChannelsPOS);
        HandlingJsonObj("nameAr", POS_NameAr, ChannelsPOS);
        HandlingJsonObj("nameEn", POS_NameEn, ChannelsPOS);

        HandlingJsonObj("id", MOB_ID, ChannelsMOB);
        HandlingJsonObj("code", MOB_Code, ChannelsMOB);
        HandlingJsonObj("nameAr", MOB_NameAr, ChannelsMOB);
        HandlingJsonObj("nameEn", MOB_NameEn, ChannelsMOB);

        HandlingJsonObj("id", INT_ID, ChannelsINT);
        HandlingJsonObj("code", INT_Code, ChannelsINT);
        HandlingJsonObj("nameAr", INT_NameAr, ChannelsINT);
        HandlingJsonObj("nameEn", INT_NameEn, ChannelsINT);

        JSONObject Category = new JSONObject();
        HandlingJsonObj("id", Category_ID, Category);
        HandlingJsonObj("code", Category_Code, Category);
        HandlingJsonObj("nameAr", Category_NameAr, Category);
        HandlingJsonObj("nameEn", Category_NameEn, Category);

        JSONObject Type = new JSONObject();
        HandlingJsonObj("id", Type_ID, Type);
        HandlingJsonObj("code", Type_Code, Type);
        HandlingJsonObj("nameAr", Type_NameAr, Type);
        HandlingJsonObj("nameEn", Type_NameEn, Type);

        JSONObject SocialLinks = new JSONObject();
        HandlingJsonObj("twitter", Twitter, SocialLinks);
        HandlingJsonObj("facebook", Facebook, SocialLinks);
        HandlingJsonObj("instagram", Instagram, SocialLinks);
        HandlingJsonObj("youtube", Youtube, SocialLinks);
        HandlingJsonObj("website", Website, SocialLinks);

        JSONObject Region = new JSONObject();
        HandlingJsonObj("id", Region_ID, Region);
        HandlingJsonObj("code", Region_Code, Region);
        HandlingJsonObj("nameAr", Region_NameAr, Region);
        HandlingJsonObj("nameEn", Region_NameEn, Region);

        JSONObject Area = new JSONObject();
        HandlingJsonObj("id", Area_ID, Area);
        HandlingJsonObj("code", Area_Code, Area);
        HandlingJsonObj("nameAr", Area_NameAr, Area);
        HandlingJsonObj("nameEn", Area_NameEn, Area);

        ParentJsonObj(Region,"region",Area);

        JSONObject Status = new JSONObject();
        HandlingJsonObj("id", Status_ID, Status);

        JSONObject Addresses = new JSONObject();
        HandlingJsonObj("address", Address, Addresses);
        ParentJsonObj(Area,"area",Addresses);

        List<Object> Channels = new LinkedList<>();

        ParentJsonObjList(ChannelsPOS,Channels);
        ParentJsonObjList(ChannelsMOB,Channels);
        ParentJsonObjList(ChannelsINT,Channels);
        HandlingJsonObj("nameEn", Unique_BE_name, payload);
        HandlingJsonObj("nameAr", BE_nameAr, payload);
        HandlingJsonObj("email", BE_Mail, payload);

        HandlingJsonObj("logo", Logo, payload);
        ParentJsonObj(csp,"csp",payload);

        if(BE_Id!=0){
            payload.put("id", BE_Id);
            SocialLinks.put("id", BE_Id);
            Addresses.put("id", BE_Id);

            JSONObject cspDB = new JSONObject();

            HandlingJsonObj("id", DataBaseDM.getCSP_id(), cspDB);
            HandlingJsonObj("code", DataBaseDM.getCSP_code(), cspDB);
            HandlingJsonObj("nameAr", DataBaseDM.getCSP_nameAr(), cspDB);
            HandlingJsonObj("nameEn", DataBaseDM.getCSP_nameEn(), cspDB);
            HandlingJsonObj("channelCode", DataBaseDM.getCSP_channelCode(), cspDB);
            HandlingJsonObj("isDefault", DataBaseDM.getCSP_isDefault(), cspDB);
            HandlingJsonObj("sofUrl", DataBaseDM.getCSP_sofUrl(), cspDB);
            HandlingJsonObj("sender", DataBaseDM.getCSP_sender(), cspDB);


            JSONObject ChannelsPOSDB = new JSONObject();
            JSONObject ChannelsMOBDB = new JSONObject();
            JSONObject ChannelsINTDB = new JSONObject();

            HandlingJsonObj("id", DataBaseDM.getChannels_POS_id(), ChannelsPOSDB);
            HandlingJsonObj("code", DataBaseDM.getChannels_POS_code(), ChannelsPOSDB);
            HandlingJsonObj("nameAr", DataBaseDM.getChannels_POS_nameAr(), ChannelsPOSDB);
            HandlingJsonObj("nameEn", DataBaseDM.getChannels_POS_nameEn(), ChannelsPOSDB);

            HandlingJsonObj("id", DataBaseDM.getChannels_MOB_id(), ChannelsMOBDB);
            HandlingJsonObj("code", DataBaseDM.getChannels_MOB_code(), ChannelsMOBDB);
            HandlingJsonObj("nameAr", DataBaseDM.getChannels_MOB_nameAr(), ChannelsMOBDB);
            HandlingJsonObj("nameEn", DataBaseDM.getChannels_MOB_nameEn(), ChannelsMOBDB);

            HandlingJsonObj("id", DataBaseDM.getChannels_INT_id(), ChannelsINTDB);
            HandlingJsonObj("code", DataBaseDM.getChannels_MOB_code(), ChannelsINTDB);
            HandlingJsonObj("nameAr", DataBaseDM.getChannels_INT_nameAr(), ChannelsINTDB);
            HandlingJsonObj("nameEn", DataBaseDM.getChannels_MOB_nameEn(), ChannelsINTDB);

            List<Object> ChannelsDB = new LinkedList<>();

            ParentJsonObjList(ChannelsPOSDB,ChannelsDB);
            ParentJsonObjList(ChannelsMOBDB,ChannelsDB);
            ParentJsonObjList(ChannelsINTDB,ChannelsDB);

            JSONObject StatusDB = new JSONObject();
            HandlingJsonObj("id", DataBaseDM.getStatus_id(), StatusDB);

            JSONObject CategoryDB = new JSONObject();
            HandlingJsonObj("id", DataBaseDM.getCategory_id(), CategoryDB);
            HandlingJsonObj("code", DataBaseDM.getCategory_code(), CategoryDB);
            HandlingJsonObj("nameAr", DataBaseDM.getCategory_nameAr(), CategoryDB);
            HandlingJsonObj("nameEn", DataBaseDM.getCategory_nameEn(), CategoryDB);

            JSONObject TypeDB = new JSONObject();
            HandlingJsonObj("id", DataBaseDM.getType_id(), TypeDB);
            HandlingJsonObj("code", DataBaseDM.getType_code(), TypeDB);
            HandlingJsonObj("nameAr", DataBaseDM.getType_nameAr(), TypeDB);
            HandlingJsonObj("nameEn", DataBaseDM.getType_nameEn(), TypeDB);

            List<Object> ChannelsInBE = new LinkedList<>();
            JSONObject account = new JSONObject();
            HandlingJsonObj("id", ACCOUNT_ID, account);
            HandlingJsonObj("accountNumber", ACCOUNT_NUMBER, account);
            JSONObject clearingAccount = new JSONObject();
            HandlingJsonObj("id", ACCOUNT_CLEARING_ACCOUNT_ID, clearingAccount);
            HandlingJsonObj("accountNumber", ACCOUNT_NUMBER, clearingAccount);
            HandlingJsonObj("clearingAccount", null, clearingAccount);
            HandlingJsonObj("businessEntity", null, clearingAccount);
            HandlingJsonObj("branch", null, clearingAccount);
            HandlingJsonObj("terminal", null, clearingAccount);
            HandlingJsonObj("clearingNoOfDays", null, clearingAccount);
            HandlingJsonObj("accountBalanceModel", null, clearingAccount);
            HandlingJsonObj("subAccounts", null, clearingAccount);
            HandlingJsonObj("clearingTerm", null, clearingAccount);
            HandlingJsonObj("type", ACCOUNT_TYPE, clearingAccount);
            HandlingJsonObj("status", ACCOUNT_STATUS, clearingAccount);
            HandlingJsonObj("branch", null, account);
            HandlingJsonObj("terminal", null, account);
            HandlingJsonObj("clearingNoOfDays", null, account);
            HandlingJsonObj("accountBalanceModel", null, account);
            HandlingJsonObj("subAccounts", null, account);
            HandlingJsonObj("clearingTerm", null, account);
            HandlingJsonObj("type", ACCOUNT_TYPE, account);
            HandlingJsonObj("status", ACCOUNT_STATUS, account);
            ParentJsonObj(clearingAccount,"clearingAccount",account);

            JSONObject businessEntity = new JSONObject();
            businessEntity.put("id", BE_Id);
            HandlingJsonObj("nameAr",DataBaseDM.getBE_nameAr() , businessEntity);
            HandlingJsonObj("nameEn", DataBaseDM.getBE_nameEn(), businessEntity);
            HandlingJsonObj("account", null, businessEntity);
            HandlingJsonObj("logoUri", DataBaseDM.getLogo_URI(), businessEntity);
            HandlingJsonObj("logo", null, businessEntity);
            HandlingJsonObj("cif", CIF, businessEntity);
            HandlingJsonObj("phoneNumber", DataBaseDM.getBE_phoneNumber(), businessEntity);
            HandlingJsonObj("email", DataBaseDM.getBE_email(), businessEntity);
            HandlingJsonObj("creationDate", CREATION_DATE, businessEntity);
            HandlingJsonObj("parentId", null, businessEntity);
            HandlingJsonObj("selfRegisteredMerchantPassword", null, businessEntity);
            ParentJsonObj(StatusDB,"status",businessEntity);
            ParentJsonObj(cspDB,"csp",businessEntity);
            ParentJsonObjListVs(businessEntity,"channels",ChannelsDB);
            ParentJsonObj(CategoryDB,"category",businessEntity);
            ParentJsonObj(TypeDB,"type",businessEntity);

            JSONObject user = new JSONObject();
            user.put("id", 0);
            HandlingJsonObj("email", "bo@fawry.com", user);
            HandlingJsonObj("mobileNumber", "01234567890", user);
            HandlingJsonObj("status", null, user);
            HandlingJsonObj("branch", null, user);
            JSONObject businessEntityinsideUser = new JSONObject();
            businessEntityinsideUser.put("id", 0);
            HandlingJsonObj("nameAr", "BO", businessEntityinsideUser);
            HandlingJsonObj("nameEn", "BO", businessEntityinsideUser);
            HandlingJsonObj("account", null, businessEntityinsideUser);
            HandlingJsonObj("logoUri", null, businessEntityinsideUser);
            HandlingJsonObj("logo", null, businessEntityinsideUser);
            HandlingJsonObj("cif", null, businessEntityinsideUser);
            HandlingJsonObj("status", null, businessEntityinsideUser);
            HandlingJsonObj("phoneNumber", null, businessEntityinsideUser);
            HandlingJsonObj("email", "bo@fawry.com", businessEntityinsideUser);
            HandlingJsonObj("creationDate", null, businessEntityinsideUser);
            HandlingJsonObj("csp", null, businessEntityinsideUser);
            HandlingJsonObj("category", null, businessEntityinsideUser);
            HandlingJsonObj("parentId", null, businessEntityinsideUser);
            HandlingJsonObj("type", null, businessEntityinsideUser);
            ParentJsonObjListVs(businessEntityinsideUser,"channels",ChannelsInBE);
            HandlingJsonObj("selfRegisteredMerchantPassword", null, businessEntityinsideUser);
            HandlingJsonObj("user", null, businessEntityinsideUser);
            ParentJsonObj(businessEntityinsideUser,"businessEntity",user);
            ParentJsonObj(user,"user",businessEntity);
            ParentJsonObj(businessEntity,"businessEntity",account);
            ParentJsonObj(account,"account",payload);


        }

        ParentJsonObjListVs(payload,"channels",Channels);
        ParentJsonObj(Category,"category",payload);
        ParentJsonObj(Type,"type",payload);
        ParentJsonObj(Addresses,"address",payload);
        ParentJsonObj(SocialLinks,"socialLinks",payload);
        ParentJsonObj(Status,"status",payload);

    }


    public String internationalNumber(String phone1) {
        StringBuilder result2 = new StringBuilder();

        for (int i = 0; i < 1; i++) {

            result2.append(phone1.charAt(i));
        }
        result2.append(" ");
        for (int i = 1; i < 4; i++) {

            result2.append(phone1.charAt(i));
        }
        result2.append(" ");
        for (int i = 4; i < 7; i++) {

            result2.append(phone1.charAt(i));
        }
        result2.append(" ");
        for (int i = 7; i < 11; i++) {

            result2.append(phone1.charAt(i));
        }

        System.out.println(result2);
        String ResString =result2.toString();
        return ResString;
    }

    public String nationalNumber(String phone1) {
        StringBuilder result = new StringBuilder();
        StringBuilder result2 = new StringBuilder();

        for (int i = 0; i < 4; i++) {

            result.append(phone1.charAt(i));
        }
        result.append(" ");
        for (int i = 4; i < 7; i++) {

            result.append(phone1.charAt(i));
        }
        result.append(" ");
        for (int i = 7; i < 11; i++) {

            result.append(phone1.charAt(i));
        }

        System.out.println(result);
        String ResString =result.toString();
        return ResString;
    }


    /* void HandlingJsonObj(String Key, String Value, JSONObject JSOBJ) {

        if (Value != "") {
            JSOBJ.put(Key, Value);
        }


    }*/

}









