package com.cydeo.entity;

import com.cydeo.utils.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor

/*
when class extends other class, AllArgsConstructor will not create constructor including all filed from parent class
Lombok @AllArgsConstructor doesn't call super() so you need to create constructor manually for derived classes
 */
//@AllArgsConstructor
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String userName;
    private boolean enable;
    private String phone;
    private String passWord;
    private Gender gender;
    private Role role;


    public User(String firstName, String lastName, String userName, boolean enable, String phone,String emailAddress, String passWord, Gender gender, Role role
    , Long id, LocalDateTime insertDateTime,Long insertUserId,LocalDateTime lastUpdateDateTime,Long lastUpdateUserId){
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.enable=enable;
        this.phone=phone;
        this.passWord=passWord;
        this.gender=gender;
        this.role=role;
    }
}
