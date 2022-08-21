package com.fawry.API.angularAutomation.dataModels;

public class LinkBeEventDm extends MainDataModel{

    private String BE_Name;
    private String app_event;
    private String event;
    private String event_category;
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

    public String getApp_event() {
        return app_event;
    }

    public void setApp_event(String app_event) {
        this.app_event = app_event;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEvent_category() {
        return event_category;
    }

    public void setEvent_category(String event_category) {
        this.event_category = event_category;
    }

    public int getStatus_Code() {
        return Status_Code;
    }

    public void setStatus_Code(int status_Code) {
        Status_Code = status_Code;
    }


}
