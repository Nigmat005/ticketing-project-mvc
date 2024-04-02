package com.cydeo.model;

import com.cydeo.utils.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private int phoneNumber;
    private String passWord;
    private String confirmPassWord;
    private Gender gender;
    private Role role;

}
