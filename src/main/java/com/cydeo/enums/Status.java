package com.cydeo.enums;

public enum Status {
    OPEN("Open"),IN_PROGRESS("In Progress"),COMPLETE("Complete");
    private String statusType;
    private Status(String statusType){
        this.statusType=statusType;
    }
    public String getStatusType(){
        return statusType;
    }
}
