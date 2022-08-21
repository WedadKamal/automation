package com.fawry.API.angularAutomation.dataModels;

public class BusinessEntityLinkDM extends MainDataModel {


    private String BE_Name;
    private String prevent_multiple_customer_login;
    private String app_fp;
    private String allow_cash_account;
    private String promo;
    private String invoice;
    private String installment;
    private String shipping_option;
    private String store_option;
    private String estatment;
    private String integrationUrl;
    private String TestCaseTitle;
    private int Status_Code;
    private String Error_Code;

    public String getError_Code() {
        return Error_Code;
    }

    public void setError_Code(String error_Code) {
        Error_Code = error_Code;
    }


    public int getStatus_Code() {
        return Status_Code;
    }

    public void setStatus_Code(int status_Code) {
        Status_Code = status_Code;
    }

    public String getBE_Name() {
        return BE_Name;
    }

    public void setBE_Name(String BE_Name) {
        this.BE_Name = BE_Name;
    }
    public String getTestCaseTitle() {
        return TestCaseTitle;
    }

    public void setTestCaseTitle(String testCaseTitle) {
        TestCaseTitle = testCaseTitle;
    }
    public String getPrevent_multiple_customer_login() {
        return prevent_multiple_customer_login;
    }

    public void setPrevent_multiple_customer_login(String prevent_multiple_customer_login) {
        this.prevent_multiple_customer_login = prevent_multiple_customer_login;
    }

    public String getApp_fp() {
        return app_fp;
    }

    public void setApp_fp(String app_fp) {
        this.app_fp = app_fp;
    }

    public String getAllow_cash_account() {
        return allow_cash_account;
    }

    public void setAllow_cash_account(String allow_cash_account) {
        this.allow_cash_account = allow_cash_account;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }

    public String getShipping_option() {
        return shipping_option;
    }

    public void setShipping_option(String shipping_option) {
        this.shipping_option = shipping_option;
    }

    public String getStore_option() {
        return store_option;
    }

    public void setStore_option(String store_option) {
        this.store_option = store_option;
    }

    public String getEstatment() {
        return estatment;
    }

    public void setEstatment(String estatment) {
        this.estatment = estatment;
    }

    public String getIntegrationUrl() {
        return integrationUrl;
    }

    public void setIntegrationUrl(String integrationUrl) {
        this.integrationUrl = integrationUrl;
    }



}
