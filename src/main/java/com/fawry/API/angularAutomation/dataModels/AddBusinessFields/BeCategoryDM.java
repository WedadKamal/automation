package com.fawry.API.angularAutomation.dataModels.AddBusinessFields;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class BeCategoryDM {



    public BeCategoryDM(int Category_ID,String Category_Code,String Category_NameEn,String Category_NameAr){
        setCategory_ID(Category_ID);
        setCategory_Code(Category_Code);
        setCategory_NameEn(Category_NameEn);
        setCategory_NameAr(Category_NameAr);
    }


    private int Category_ID ;
    private String Category_Code ;
    private String Category_NameEn;
    private String Category_NameAr;

    @JsonProperty(value = "id")
    public int getCategory_ID() {
        return Category_ID;
    }

    public void setCategory_ID(int category_ID) {
        Category_ID = category_ID;
    }

    @JsonProperty(value = "code")
    public String getCategory_Code() {
        return Category_Code;
    }

    public void setCategory_Code(String category_Code) {
        Category_Code = category_Code;
    }

    @JsonProperty(value = "nameEn")
    public String getCategory_NameEn() {
        return Category_NameEn;
    }

    public void setCategory_NameEn(String category_NameEn) {
        Category_NameEn = category_NameEn;
    }

    @JsonProperty(value = "nameAr")
    public String getCategory_NameAr() {
        return Category_NameAr;
    }

    public void setCategory_NameAr(String category_NameAr) {
        Category_NameAr = category_NameAr;
    }


}
