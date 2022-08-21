package com.fawry.API.angularAutomation.dataModels;

import net.minidev.json.annotate.JsonIgnore;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.json.JSONObject;

public class AddUpdateBusinessEntityDM extends MainDataModel{
    private String BE_ID;

    private String BE_nameEn;
    private String BE_nameAr;
    private String BE_email;
    private String BE_phoneNumber;
    private String CSP_id;
    private String CSP_code;
    private String CSP_nameEn;
    private String CSP_nameAr;
    private String CSP_channelCode;
    private String CSP_isDefault;
    private String CSP_sofUrl;
    private String CSP_sender;
    private String category_id;
    private String category_code;
    private String category_nameEn;
    private String category_nameAr;
    private String type_id;
    private String type_code;
    private String type_nameEn;
    private String type_nameAr;
    private String channels_POS_id;
    private String channels_POS_code;
    private String channels_POS_nameEn;
    private String channels_POS_nameAr;
    private String channels_INT_id;
    private String channels_INT_code;
    private String channels_INT_nameEn;
    private String channels_INT_nameAr;
    private String channels_MOB_id;
    private String channels_MOB_code;
    private String channels_MOB_nameEn;
    private String channels_MOB_nameAr;
    private String address_area_id;
    private String address_area_code;
    private String address_area_nameEn;
    private String address_area_nameAr;
    private String address_region_id;
    private String address_region_code;
    private String address_region_nameEn;
    private String address_region_nameAr;
    private String address;
    private String twitter;
    private String facebook;
    private String instagram;
    private String youtube;
    private String website;
    private String status_id;
    private String logo;
    private int status_Code;
    private int Count;
    private String TestCaseTitleForView;
    private String Address_ID;
    private String SocialLink_ID;
    private String Logo_URI;
    private String Pass_Added;
    private String TestCaseTitleForUpdate;

    private String Account_Number;
    private String Account_ID;
    private String ACCOUNT_BUSINESS_ENTITY_ID;
    private String ACCOUNT_BRANCH_ID;
    private String ACCOUNT_TERMINAL_ID;
    private String ACCOUNT_CLEARING_ACCOUNT_ID;
    private String ACCOUNT_CLEARING_TERM;
    private String ACCOUNT_CLEARING_NO_OF_DAYS;
    private String ACC_ACCOUNT_BUSINESS_ENTITY_ID;
    private String ACCOUNT_TYPE;
    private String ACCOUNT_PARENT_ID;
    private String ACCOUNT_STATUS;
    private String CIF;
    private String CREATION_DATE;
    public String getCREATION_DATE() {
        return CREATION_DATE;
    }

    public void setCREATION_DATE(String CREATION_DATE) {
        this.CREATION_DATE = CREATION_DATE;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }



    public String getAccount_ID() {
        return Account_ID;
    }

    public void setAccount_ID(String account_ID) {
        Account_ID = account_ID;
    }

    public String getACCOUNT_BUSINESS_ENTITY_ID() {
        return ACCOUNT_BUSINESS_ENTITY_ID;
    }

    public void setACCOUNT_BUSINESS_ENTITY_ID(String ACCOUNT_BUSINESS_ENTITY_ID) {
        this.ACCOUNT_BUSINESS_ENTITY_ID = ACCOUNT_BUSINESS_ENTITY_ID;
    }

    public String getACCOUNT_BRANCH_ID() {
        return ACCOUNT_BRANCH_ID;
    }

    public void setACCOUNT_BRANCH_ID(String ACCOUNT_BRANCH_ID) {
        this.ACCOUNT_BRANCH_ID = ACCOUNT_BRANCH_ID;
    }

    public String getACCOUNT_TERMINAL_ID() {
        return ACCOUNT_TERMINAL_ID;
    }

    public void setACCOUNT_TERMINAL_ID(String ACCOUNT_TERMINAL_ID) {
        this.ACCOUNT_TERMINAL_ID = ACCOUNT_TERMINAL_ID;
    }

    public String getACCOUNT_CLEARING_ACCOUNT_ID() {
        return ACCOUNT_CLEARING_ACCOUNT_ID;
    }

    public void setACCOUNT_CLEARING_ACCOUNT_ID(String ACCOUNT_CLEARING_ACCOUNT_ID) {
        this.ACCOUNT_CLEARING_ACCOUNT_ID = ACCOUNT_CLEARING_ACCOUNT_ID;
    }

    public String getACCOUNT_CLEARING_TERM() {
        return ACCOUNT_CLEARING_TERM;
    }

    public void setACCOUNT_CLEARING_TERM(String ACCOUNT_CLEARING_TERM) {
        this.ACCOUNT_CLEARING_TERM = ACCOUNT_CLEARING_TERM;
    }

    public String getACCOUNT_CLEARING_NO_OF_DAYS() {
        return ACCOUNT_CLEARING_NO_OF_DAYS;
    }

    public void setACCOUNT_CLEARING_NO_OF_DAYS(String ACCOUNT_CLEARING_NO_OF_DAYS) {
        this.ACCOUNT_CLEARING_NO_OF_DAYS = ACCOUNT_CLEARING_NO_OF_DAYS;
    }

    public String getACC_ACCOUNT_BUSINESS_ENTITY_ID() {
        return ACC_ACCOUNT_BUSINESS_ENTITY_ID;
    }

    public void setACC_ACCOUNT_BUSINESS_ENTITY_ID(String ACC_ACCOUNT_BUSINESS_ENTITY_ID) {
        this.ACC_ACCOUNT_BUSINESS_ENTITY_ID = ACC_ACCOUNT_BUSINESS_ENTITY_ID;
    }

    public String getACCOUNT_TYPE() {
        return ACCOUNT_TYPE;
    }

    public void setACCOUNT_TYPE(String ACCOUNT_TYPE) {
        this.ACCOUNT_TYPE = ACCOUNT_TYPE;
    }

    public String getACCOUNT_PARENT_ID() {
        return ACCOUNT_PARENT_ID;
    }

    public void setACCOUNT_PARENT_ID(String ACCOUNT_PARENT_ID) {
        this.ACCOUNT_PARENT_ID = ACCOUNT_PARENT_ID;
    }

    public String getACCOUNT_STATUS() {
        return ACCOUNT_STATUS;
    }

    public void setACCOUNT_STATUS(String ACCOUNT_STATUS) {
        this.ACCOUNT_STATUS = ACCOUNT_STATUS;
    }

    public String getAccount_Number() {
        return Account_Number;
    }

    public void setAccount_Number(String account_Number) {
        Account_Number = account_Number;
    }

    public String getTestCaseTitleForUpdate() {
        return TestCaseTitleForUpdate;
    }

    public void setTestCaseTitleForUpdate(String testCaseTitleForUpdate) {
        TestCaseTitleForUpdate = testCaseTitleForUpdate;
    }

    public String getPass_Added() {
        return Pass_Added;
    }

    public void setPass_Added(String pass_Added) {
        Pass_Added = pass_Added;
    }
    public String getLogo_URI() {
        return Logo_URI;
    }

    public void setLogo_URI(String logo_URI) {
        Logo_URI = logo_URI;
    }
    public String getBE_ID() {
        return BE_ID;
    }

    public void setBE_ID(String BE_ID) {
        this.BE_ID = BE_ID;
    }

    public String getAddress_ID() {
        return Address_ID;
    }

    public void setAddress_ID(String address_ID) {
        Address_ID = address_ID;
    }

    public String getSocialLink_ID() {
        return SocialLink_ID;
    }

    public void setSocialLink_ID(String socialLink_ID) {
        SocialLink_ID = socialLink_ID;
    }

    public String getTestCaseTitleForView() {
        return TestCaseTitleForView;
    }

    public void setTestCaseTitleForView(String testCaseTitleForView) {
        TestCaseTitleForView = testCaseTitleForView;
    }
    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }


    public int getStatus_Code() {
        return status_Code;
    }

    public void setStatus_Code(int status_Code) {
        this.status_Code = status_Code;
    }
    public String getBE_nameEn() {
        return BE_nameEn;
    }

    public void setBE_nameEn(String BE_nameEn) {
        this.BE_nameEn = BE_nameEn;
    }

    public String getBE_nameAr() {
        return BE_nameAr;
    }

    public void setBE_nameAr(String BE_nameAr) {
        this.BE_nameAr = BE_nameAr;
    }

    public String getBE_email() {
        return BE_email;
    }

    public void setBE_email(String BE_email) {
        this.BE_email = BE_email;
    }

    public String getBE_phoneNumber() {
        return BE_phoneNumber;
    }

    public void setBE_phoneNumber(String BE_phoneNumber) {
        this.BE_phoneNumber = BE_phoneNumber;
    }

    public String getCSP_id() {
        return CSP_id;
    }

    public void setCSP_id(String CSP_id) {
        this.CSP_id = CSP_id;
    }

    public String getCSP_code() {
        return CSP_code;
    }

    public void setCSP_code(String CSP_code) {
        this.CSP_code = CSP_code;
    }

    public String getCSP_nameEn() {
        return CSP_nameEn;
    }

    public void setCSP_nameEn(String CSP_nameEn) {
        this.CSP_nameEn = CSP_nameEn;
    }

    public String getCSP_nameAr() {
        return CSP_nameAr;
    }

    public void setCSP_nameAr(String CSP_nameAr) {
        this.CSP_nameAr = CSP_nameAr;
    }

    public String getCSP_channelCode() {
        return CSP_channelCode;
    }

    public void setCSP_channelCode(String CSP_channelCode) {
        this.CSP_channelCode = CSP_channelCode;
    }
    public String getCSP_isDefault() {
        return CSP_isDefault;
    }

    public void setCSP_isDefault(String CSP_isDefault) {
        this.CSP_isDefault = CSP_isDefault;
    }

    public String getCSP_sofUrl() {
        return CSP_sofUrl;
    }

    public void setCSP_sofUrl(String CSP_sofUrl) {
        this.CSP_sofUrl = CSP_sofUrl;
    }

    public String getCSP_sender() {
        return CSP_sender;
    }

    public void setCSP_sender(String CSP_sender) {
        this.CSP_sender = CSP_sender;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public String getCategory_nameEn() {
        return category_nameEn;
    }

    public void setCategory_nameEn(String category_nameEn) {
        this.category_nameEn = category_nameEn;
    }

    public String getCategory_nameAr() {
        return category_nameAr;
    }

    public void setCategory_nameAr(String category_nameAr) {
        this.category_nameAr = category_nameAr;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getType_code() {
        return type_code;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }

    public String getType_nameEn() {
        return type_nameEn;
    }

    public void setType_nameEn(String type_nameEn) {
        this.type_nameEn = type_nameEn;
    }

    public String getType_nameAr() {
        return type_nameAr;
    }

    public void setType_nameAr(String type_nameAr) {
        this.type_nameAr = type_nameAr;
    }

    public String getChannels_POS_id() {
        return channels_POS_id;
    }

    public void setChannels_POS_id(String channels_POS_id) {
        this.channels_POS_id = channels_POS_id;
    }

    public String getChannels_POS_code() {
        return channels_POS_code;
    }

    public void setChannels_POS_code(String channels_POS_code) {
        this.channels_POS_code = channels_POS_code;
    }

    public String getChannels_POS_nameEn() {
        return channels_POS_nameEn;
    }

    public void setChannels_POS_nameEn(String channels_POS_nameEn) {
        this.channels_POS_nameEn = channels_POS_nameEn;
    }

    public String getChannels_POS_nameAr() {
        return channels_POS_nameAr;
    }

    public void setChannels_POS_nameAr(String channels_POS_nameAr) {
        this.channels_POS_nameAr = channels_POS_nameAr;
    }

    public String getChannels_INT_id() {
        return channels_INT_id;
    }

    public void setChannels_INT_id(String channels_INT_id) {
        this.channels_INT_id = channels_INT_id;
    }

    public String getChannels_INT_code() {
        return channels_INT_code;
    }

    public void setChannels_INT_code(String channels_INT_code) {
        this.channels_INT_code = channels_INT_code;
    }

    public String getChannels_INT_nameEn() {
        return channels_INT_nameEn;
    }

    public void setChannels_INT_nameEn(String channels_INT_nameEn) {
        this.channels_INT_nameEn = channels_INT_nameEn;
    }

    public String getChannels_INT_nameAr() {
        return channels_INT_nameAr;
    }

    public void setChannels_INT_nameAr(String channels_INT_nameAr) {
        this.channels_INT_nameAr = channels_INT_nameAr;
    }

    public String getChannels_MOB_id() {
        return channels_MOB_id;
    }

    public void setChannels_MOB_id(String channels_MOB_id) {
        this.channels_MOB_id = channels_MOB_id;
    }

    public String getChannels_MOB_code() {
        return channels_MOB_code;
    }

    public void setChannels_MOB_code(String channels_MOB_code) {
        this.channels_MOB_code = channels_MOB_code;
    }

    public String getChannels_MOB_nameEn() {
        return channels_MOB_nameEn;
    }

    public void setChannels_MOB_nameEn(String channels_MOB_nameEn) {
        this.channels_MOB_nameEn = channels_MOB_nameEn;
    }

    public String getChannels_MOB_nameAr() {
        return channels_MOB_nameAr;
    }

    public void setChannels_MOB_nameAr(String channels_MOB_nameAr) {
        this.channels_MOB_nameAr = channels_MOB_nameAr;
    }

    public String getAddress_area_id() {
        return address_area_id;
    }

    public void setAddress_area_id(String address_area_id) {
        this.address_area_id = address_area_id;
    }

    public String getAddress_area_code() {
        return address_area_code;
    }

    public void setAddress_area_code(String address_area_code) {
        this.address_area_code = address_area_code;
    }

    public String getAddress_area_nameEn() {
        return address_area_nameEn;
    }

    public void setAddress_area_nameEn(String address_area_nameEn) {
        this.address_area_nameEn = address_area_nameEn;
    }

    public String getAddress_area_nameAr() {
        return address_area_nameAr;
    }

    public void setAddress_area_nameAr(String address_area_nameAr) {
        this.address_area_nameAr = address_area_nameAr;
    }

    public String getAddress_region_id() {
        return address_region_id;
    }

    public void setAddress_region_id(String address_region_id) {
        this.address_region_id = address_region_id;
    }

    public String getAddress_region_code() {
        return address_region_code;
    }

    public void setAddress_region_code(String address_region_code) {
        this.address_region_code = address_region_code;
    }

    public String getAddress_region_nameEn() {
        return address_region_nameEn;
    }

    public void setAddress_region_nameEn(String address_region_nameEn) {
        this.address_region_nameEn = address_region_nameEn;
    }

    public String getAddress_region_nameAr() {
        return address_region_nameAr;
    }

    public void setAddress_region_nameAr(String address_region_nameAr) {
        this.address_region_nameAr = address_region_nameAr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    public AddUpdateBusinessEntityDM(){

    }





}
