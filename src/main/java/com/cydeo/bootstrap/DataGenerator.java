package com.cydeo.bootstrap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// should be gotten from database, since we don't have db set up yet we use DataGenerator
public class DataGenerator {
  private static  List<String> roles=new ArrayList<>();
    public static List<String> getAllRole(){
        roles= Arrays.asList("Manager","Admin");
        return  roles;
    }
}
