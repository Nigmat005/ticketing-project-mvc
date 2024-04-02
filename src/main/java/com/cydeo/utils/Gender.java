package com.cydeo.utils;

import lombok.*;

@Getter(AccessLevel.PUBLIC)
@ToString
@AllArgsConstructor
public enum Gender {
    MALE("male"),FEMALE("female");
    private String genderType;
//    private Gender(String genderType){
//        this.genderType=genderType;
//    }

//    public String getGenderType(){
//        return this.genderType;
//    }
}
