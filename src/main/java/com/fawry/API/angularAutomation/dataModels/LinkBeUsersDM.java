package com.fawry.API.angularAutomation.dataModels;

public class LinkBeUsersDM extends MainDataModel {

    private String BE_Name;
    private String app_user;
    private String user;
    private String user_role;
    private String integrationUrl;
    private int Status_Code;
    private String Error_Code;

    public String getError_Code() {
        return Error_Code;
    }

    public void setError_Code(String error_Code) {
        Error_Code = error_Code;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBE_Name() {
        return BE_Name;
    }

    public void setBE_Name(String BE_Name) {
        this.BE_Name = BE_Name;
    }

    public String getApp_user() {
        return app_user;
    }

    public void setApp_user(String app_user) {
        this.app_user = app_user;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getIntegrationUrl() {
        return integrationUrl;
    }

    public void setIntegrationUrl(String integrationUrl) {
        this.integrationUrl = integrationUrl;
    }

    public int getStatus_Code() {
        return Status_Code;
    }

    public void setStatus_Code(int status_Code) {
        Status_Code = status_Code;
    }


}
