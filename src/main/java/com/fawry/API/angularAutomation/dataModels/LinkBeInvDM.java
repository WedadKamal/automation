package com.fawry.API.angularAutomation.dataModels;

public class LinkBeInvDM extends MainDataModel{

    private String BE_Name;
    private String app_inv;
    private String single_invoice;
    private String recurring_invoice;
    private String group_invoice;
    private String payment_link;
    private String segregate_user_access;
    private int Status_Code;

    public String getError_Code() {
        return error_Code;
    }

    public void setError_Code(String error_Code) {
        this.error_Code = error_Code;
    }

    private String error_Code;

    public String getBE_Name() {
        return BE_Name;
    }

    public void setBE_Name(String BE_Name) {
        this.BE_Name = BE_Name;
    }

    public String getApp_inv() {
        return app_inv;
    }

    public void setApp_inv(String app_inv) {
        this.app_inv = app_inv;
    }

    public String getSingle_invoice() {
        return single_invoice;
    }

    public void setSingle_invoice(String single_invoice) {
        this.single_invoice = single_invoice;
    }

    public String getRecurring_invoice() {
        return recurring_invoice;
    }

    public void setRecurring_invoice(String recurring_invoice) {
        this.recurring_invoice = recurring_invoice;
    }

    public String getGroup_invoice() {
        return group_invoice;
    }

    public void setGroup_invoice(String group_invoice) {
        this.group_invoice = group_invoice;
    }

    public String getPayment_link() {
        return payment_link;
    }

    public void setPayment_link(String payment_link) {
        this.payment_link = payment_link;
    }

    public String getSegregate_user_access() {
        return segregate_user_access;
    }

    public void setSegregate_user_access(String segregate_user_access) {
        this.segregate_user_access = segregate_user_access;
    }

    public int getStatus_Code() {
        return Status_Code;
    }

    public void setStatus_Code(int status_Code) {
        Status_Code = status_Code;
    }


}
