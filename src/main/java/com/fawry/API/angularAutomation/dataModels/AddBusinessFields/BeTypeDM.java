package com.fawry.API.angularAutomation.dataModels.AddBusinessFields;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BeTypeDM {
    private int Type_ID;
    private String Type_Code ;
    private String Type_NameEn;
    private String Type_NameAr;

    @JsonProperty(value = "id")
    public int getType_ID() {
        return Type_ID;
    }

    public void setType_ID(int type_ID) {
        Type_ID = type_ID;
    }

    @JsonProperty(value = "id")
    public String getType_Code() {
        return Type_Code;
    }

    public void setType_Code(String type_Code) {
        Type_Code = type_Code;
    }

    public String getType_NameEn() {
        return Type_NameEn;
    }

    public void setType_NameEn(String type_NameEn) {
        Type_NameEn = type_NameEn;
    }

    public String getType_NameAr() {
        return Type_NameAr;
    }

    public void setType_NameAr(String type_NameAr) {
        Type_NameAr = type_NameAr;
    }


}
