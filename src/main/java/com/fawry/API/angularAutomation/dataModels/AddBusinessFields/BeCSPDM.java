package com.fawry.API.angularAutomation.dataModels.AddBusinessFields;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class BeCSPDM {
    public BeCSPDM(int CSP_id,
                   String CSP_code,
                   String CSP_nameEn,
                   String CSP_nameAr,
                   int CSP_channelCode,
                   int CSP_isDefault,
                   String CSP_sofUrl,
                   String CSP_sender){
        setCSP_id(CSP_id);
        setCSP_code(CSP_code);
        setCSP_nameEn(CSP_nameEn);
        setCSP_nameAr(CSP_nameAr);
        setCSP_channelCode(CSP_channelCode);
        setCSP_isDefault(CSP_isDefault);
        setCSP_sofUrl(CSP_sofUrl);
        setCSP_sender(CSP_sender);
    }
    private int CSP_id;
    private String CSP_code;
    private String CSP_nameEn;
    private String CSP_nameAr;
    private int CSP_channelCode;
    private int CSP_isDefault;
    private String CSP_sofUrl;
    private String CSP_sender;

    @JsonProperty(value = "id")
    public int getCSP_id() {
        return CSP_id;
    }

    public void setCSP_id(int CSP_id) {
        this.CSP_id = CSP_id;
    }
    @JsonProperty(value = "code")
    public String getCSP_code() {
        return CSP_code;
    }

    public void setCSP_code(String CSP_code) {
        this.CSP_code = CSP_code;
    }

    @JsonProperty(value = "nameEn")
    public String getCSP_nameEn() {
        return CSP_nameEn;
    }

    public void setCSP_nameEn(String CSP_nameEn) {
        this.CSP_nameEn = CSP_nameEn;
    }

    @JsonProperty(value = "nameAr")
    public String getCSP_nameAr() {
        return CSP_nameAr;
    }

    public void setCSP_nameAr(String CSP_nameAr) {
        this.CSP_nameAr = CSP_nameAr;
    }

    @JsonProperty(value = "channelCode")
    public int getCSP_channelCode() {
        return CSP_channelCode;
    }

    public void setCSP_channelCode(int CSP_channelCode) {
        this.CSP_channelCode = CSP_channelCode;
    }

    @JsonProperty(value = "isDefault")
    public int getCSP_isDefault() {
        return CSP_isDefault;
    }

    public void setCSP_isDefault(int CSP_isDefault) {
        this.CSP_isDefault = CSP_isDefault;
    }

    @JsonProperty(value = "sofUrl")
    public String getCSP_sofUrl() {
        return CSP_sofUrl;
    }

    public void setCSP_sofUrl(String CSP_sofUrl) {
        this.CSP_sofUrl = CSP_sofUrl;
    }

    @JsonProperty(value = "sender")
    public String getCSP_sender() {
        return CSP_sender;
    }

    public void setCSP_sender(String CSP_sender) {
        this.CSP_sender = CSP_sender;
    }


}
