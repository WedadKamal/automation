package com.fawry.API.angularAutomation.dataModels;

public class LinkBeCallCenterDM extends MainDataModel{
    private String BE_Name;
    private String app_shop_callcenter;
    private int Status_Code;
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

    public String getApp_shop_callcenter() {
        return app_shop_callcenter;
    }

    public void setApp_shop_callcenter(String app_shop_callcenter) {
        this.app_shop_callcenter = app_shop_callcenter;
    }

    public int getStatus_Code() {
        return Status_Code;
    }

    public void setStatus_Code(int status_Code) {
        Status_Code = status_Code;
    }


}
