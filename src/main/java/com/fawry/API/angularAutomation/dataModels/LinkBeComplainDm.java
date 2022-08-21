package com.fawry.API.angularAutomation.dataModels;

public class LinkBeComplainDm extends MainDataModel {


    private String BE_Name;
    private int Status_Code;
    private String app_complaint;
    private String Error_Code;

    public String getError_Code() {
        return Error_Code;
    }

    public void setError_Code(String error_Code) {
        Error_Code = error_Code;
    }
    public String getBE_Name() {
        return BE_Name;
    }

    public void setBE_Name(String BE_Name) {
        this.BE_Name = BE_Name;
    }

    public int getStatus_Code() {
        return Status_Code;
    }


    public void setStatus_Code(int status_Code) {
        Status_Code = status_Code;
    }


    public String getApp_complaint() {
        return app_complaint;
    }

    public void setApp_complaint(String app_complaint) {
        this.app_complaint = app_complaint;
    }


}
