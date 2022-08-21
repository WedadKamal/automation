package com.fawry.API.angularAutomation.pages;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import net.minidev.json.JSONObject;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;


public class GetBusinessEntityPage {


/*
    {"nameEn":"AmalProduct","phoneNumber":"01282716882","email":"Eng.amal87@gmail.com","accountNumber":null,"status":"ACTIVE","category":"Online Store"}
*/


    public void BEViewByParam(String value, String Criteria,JSONObject jsnobj) {


        if (Criteria.equalsIgnoreCase("email")) {
            jsnobj.put(Criteria, value);
        } else if (Criteria.equalsIgnoreCase("phoneNumber")) {
            jsnobj.put(Criteria, value);
        } else if (Criteria.equalsIgnoreCase("nameEn")) {
            jsnobj.put(Criteria, value);
        } else if (Criteria.equalsIgnoreCase("status")) {
            jsnobj.put(Criteria, value);
        } else if (Criteria.equalsIgnoreCase("category")) {
            jsnobj.put(Criteria, value);
        }else if (Criteria.equalsIgnoreCase("accountNumber")) {
            jsnobj.put(Criteria, value);
        }
    }

    public void BEViewByTwoParam(String value, String Criteria,String NameValue,JSONObject jsnobj) {


         if (Criteria.equalsIgnoreCase("status")) {
            jsnobj.put(Criteria, value);
             jsnobj.put("nameEn", NameValue);

         } else if (Criteria.equalsIgnoreCase("category")) {
            jsnobj.put(Criteria, value);
             jsnobj.put("nameEn", NameValue);

         }
    }

}

