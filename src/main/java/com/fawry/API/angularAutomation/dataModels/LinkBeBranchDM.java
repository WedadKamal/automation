package com.fawry.API.angularAutomation.dataModels;

public class LinkBeBranchDM extends MainDataModel{

    private String BE_Name;
    private String branch_table_qr;
    private String branch_table;
    private String branch;
    private String app_be;
    private String branch_service;
    private String branch_shift;
    private String branch_coverage;
    private String branch_working_hours;
    private String branch_category;
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

    public String getBranch_table_qr() {
        return branch_table_qr;
    }

    public void setBranch_table_qr(String branch_table_qr) {
        this.branch_table_qr = branch_table_qr;
    }

    public String getBranch_table() {
        return branch_table;
    }

    public void setBranch_table(String branch_table) {
        this.branch_table = branch_table;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getApp_be() {
        return app_be;
    }

    public void setApp_be(String app_be) {
        this.app_be = app_be;
    }

    public String getBranch_service() {
        return branch_service;
    }

    public void setBranch_service(String branch_service) {
        this.branch_service = branch_service;
    }

    public String getBranch_shift() {
        return branch_shift;
    }

    public void setBranch_shift(String branch_shift) {
        this.branch_shift = branch_shift;
    }

    public String getBranch_coverage() {
        return branch_coverage;
    }

    public void setBranch_coverage(String branch_coverage) {
        this.branch_coverage = branch_coverage;
    }

    public String getBranch_working_hours() {
        return branch_working_hours;
    }

    public void setBranch_working_hours(String branch_working_hours) {
        this.branch_working_hours = branch_working_hours;
    }

    public String getBranch_category() {
        return branch_category;
    }

    public void setBranch_category(String branch_category) {
        this.branch_category = branch_category;
    }

    public int getStatus_Code() {
        return Status_Code;
    }

    public void setStatus_Code(int status_Code) {
        Status_Code = status_Code;
    }


}
