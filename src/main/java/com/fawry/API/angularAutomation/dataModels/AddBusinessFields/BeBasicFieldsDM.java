package com.fawry.API.angularAutomation.dataModels.AddBusinessFields;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fawry.API.angularAutomation.dataModels.MainDataModel;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class BeBasicFieldsDM extends MainDataModel {
    public BeBasicFieldsDM(String BE_nameEn,
                           String BE_nameAr,
                           String BE_email,
                           String BE_phoneNumber,
                           BeCSPDM CSP,
                           BeCategoryDM Category){
        setBE_nameEn(BE_nameEn);
        setBE_nameAr(BE_nameAr);
        setBE_email(BE_email);
        setBE_phoneNumber(BE_phoneNumber);
        setCSP(CSP);
        setCategory(Category);
    }




    private BeCategoryDM Category;
    private BeCSPDM CSP;
    private String BE_nameEn;
    private String BE_nameAr;
    private String BE_email;
    private String BE_phoneNumber;


    @JsonProperty(value = "category")
    public BeCategoryDM getCategory() {
        return Category;
    }

    public void setCategory(BeCategoryDM category) {
        Category = category;
    }


    @JsonProperty(value = "csp")
    public BeCSPDM getCSP() {
        return CSP;
    }

    public void setCSP(BeCSPDM CSP) {
        this.CSP = CSP;
    }

    @JsonProperty(value = "nameEn")
    public String getBE_nameEn() {
        return BE_nameEn;
    }

    public void setBE_nameEn(String BE_nameEn) {
        this.BE_nameEn = BE_nameEn;
    }

    @JsonProperty(value = "nameAr")
    public String getBE_nameAr() {
        return BE_nameAr;
    }

    public void setBE_nameAr(String BE_nameAr) {
        this.BE_nameAr = BE_nameAr;
    }

    @JsonProperty(value = "email")
    public String getBE_email() {
        return BE_email;
    }

    public void setBE_email(String BE_email) {
        this.BE_email = BE_email;
    }

    @JsonProperty(value = "phoneNumber")
    public String getBE_phoneNumber() {
        return BE_phoneNumber;
    }

    public void setBE_phoneNumber(String BE_phoneNumber) {
        this.BE_phoneNumber = BE_phoneNumber;
    }


}
