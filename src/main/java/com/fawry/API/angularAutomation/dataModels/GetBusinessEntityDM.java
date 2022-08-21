package com.fawry.API.angularAutomation.dataModels;

public class GetBusinessEntityDM extends MainDataModel{
    private String nameAr;
    private String nameEn;
    private String phoneNumber;
    private String email;
    private String Payload;

    public   GetBusinessEntityDM(){

        setPayload("{\"email\": \"Eng.amal87@gmail.com\"}");

    }
    //for using in add business entyty and get business entity with java object
    public   GetBusinessEntityDM(String nameAr,String nameEn,String phoneNumber,String email ){

        setNameAr(nameAr);
        setNameEn(nameEn);
        setPhoneNumber(phoneNumber);
        setEmail(email);

    }
    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPayload() {
        return Payload;
    }

    public void setPayload(String payload) {
        Payload = payload;
    }



}
