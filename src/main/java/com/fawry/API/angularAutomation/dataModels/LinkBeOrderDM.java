package com.fawry.API.angularAutomation.dataModels;

public class LinkBeOrderDM extends MainDataModel{

    private String BE_Name;
    private String order_manage;
    private String orders_board;
    private String order_customer;
    private int Status_Code;

    public String getError_Code() {
        return Error_Code;
    }

    public void setError_Code(String error_Code) {
        Error_Code = error_Code;
    }

    private String Error_Code;

    public String getBE_Name() {
        return BE_Name;
    }

    public void setBE_Name(String BE_Name) {
        this.BE_Name = BE_Name;
    }

    public String getOrder_manage() {
        return order_manage;
    }

    public void setOrder_manage(String order_manage) {
        this.order_manage = order_manage;
    }

    public String getOrders_board() {
        return orders_board;
    }

    public void setOrders_board(String orders_board) {
        this.orders_board = orders_board;
    }

    public String getOrder_customer() {
        return order_customer;
    }

    public void setOrder_customer(String order_customer) {
        this.order_customer = order_customer;
    }

    public int getStatus_Code() {
        return Status_Code;
    }

    public void setStatus_Code(int status_Code) {
        Status_Code = status_Code;
    }


}
