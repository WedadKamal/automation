package com.fawry.API.angularAutomation.dataModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class LoginBusinessEntityDM extends MainDataModel{

    private String userIdentifier;
    private String password;



   // @JsonProperty(value = "user_password")


   public LoginBusinessEntityDM(){}
   public LoginBusinessEntityDM(String userIdentifier, String password){

       setuserIdentifier(userIdentifier);
       setpassword(password);


    }


    public String getuserIdentifier() {
        return userIdentifier;
    }

    public void setuserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }



}
