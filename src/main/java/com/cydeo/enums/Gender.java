package com.cydeo.enums;

import lombok.*;

@Getter(AccessLevel.PUBLIC)
@ToString
@AllArgsConstructor
public enum Gender {
    MALE("Male"),FEMALE("Female");
    private String genderType;
//    private Gender(String genderType){
//        this.genderType=genderType;
//    }

//    public String getGenderType(){
//        return this.genderType;
//    }
}
