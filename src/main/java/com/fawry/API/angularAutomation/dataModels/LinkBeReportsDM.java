package com.fawry.API.angularAutomation.dataModels;

public class LinkBeReportsDM extends MainDataModel{
    private String app_report;
    private String report_event;
    private String branches_reports;
    private String branch_shifts_reports;
    private String BE_Name;
    private int Status_Code;
    private String Error_Code;

    public String getError_Code() {
        return Error_Code;
    }

    public void setError_Code(String error_Code) {
        Error_Code = error_Code;
    }

    public String getApp_report() {
        return app_report;
    }

    public void setApp_report(String app_report) {
        this.app_report = app_report;
    }

    public String getReport_event() {
        return report_event;
    }

    public void setReport_event(String report_event) {
        this.report_event = report_event;
    }

    public String getBranches_reports() {
        return branches_reports;
    }

    public void setBranches_reports(String branches_reports) {
        this.branches_reports = branches_reports;
    }

    public String getBranch_shifts_reports() {
        return branch_shifts_reports;
    }

    public void setBranch_shifts_reports(String branch_shifts_reports) {
        this.branch_shifts_reports = branch_shifts_reports;
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
}
