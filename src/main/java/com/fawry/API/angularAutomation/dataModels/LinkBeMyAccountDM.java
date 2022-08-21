package com.fawry.API.angularAutomation.dataModels;

public class LinkBeMyAccountDM extends MainDataModel{
    private String BE_Name;
    private String my_account_parent;
    private String my_account;
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

    public String getMy_account_parent() {
        return my_account_parent;
    }

    public void setMy_account_parent(String my_account_parent) {
        this.my_account_parent = my_account_parent;
    }

    public String getMy_account() {
        return my_account;
    }

    public void setMy_account(String my_account) {
        this.my_account = my_account;
    }

    public int getStatus_Code() {
        return Status_Code;
    }

    public void setStatus_Code(int status_Code) {
        Status_Code = status_Code;
    }


}
