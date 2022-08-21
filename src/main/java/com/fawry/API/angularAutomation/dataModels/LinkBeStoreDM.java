package com.fawry.API.angularAutomation.dataModels;

public class LinkBeStoreDM extends MainDataModel {

    private String BE_Name;
    private String dynamic_page;
    private String store;
    private String advertisement;
    private String store_setup;
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

    public String getDynamic_page() {
        return dynamic_page;
    }

    public void setDynamic_page(String dynamic_page) {
        this.dynamic_page = dynamic_page;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    public String getStore_setup() {
        return store_setup;
    }

    public void setStore_setup(String store_setup) {
        this.store_setup = store_setup;
    }

    public int getStatus_Code() {
        return Status_Code;
    }

    public void setStatus_Code(int status_Code) {
        Status_Code = status_Code;
    }


}
