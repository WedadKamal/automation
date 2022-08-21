package com.fawry.API.angularAutomation.dataModels;

public class LinkBeBeDM extends MainDataModel{


    private String BE_Name;
    private String app_be_profile;
    private String profile;
    private int Status_Code;
    private String Error_Code;

    public String getError_Code() {
        return Error_Code;
    }

    public void setError_Code(String error_Code) {
        Error_Code = error_Code;
    }
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getBE_Name() {
        return BE_Name;
    }

    public void setBE_Name(String BE_Name) {
        this.BE_Name = BE_Name;
    }

    public String getApp_be_profile() {
        return app_be_profile;
    }

    public void setApp_be_profile(String app_be_profile) {
        this.app_be_profile = app_be_profile;
    }

    public int getStatus_Code() {
        return Status_Code;
    }

    public void setStatus_Code(int status_Code) {
        Status_Code = status_Code;
    }

}
