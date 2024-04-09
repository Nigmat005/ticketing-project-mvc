package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;
    @Autowired
    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("users",userService.findAll());

        return "/user/create";
    }


    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user, Model model){

        userService.save(user);

        return "redirect:/user/create"; // redirecting to endpoint not view, if there is no redirect then will go to view

    }

    /* todo
             path variable username will be defined in create.html when user clicks "Update" button, then pathVariable will
             be present in http request and  @PathVariable(value = "username") will assign value to (String primaryKey_UserName)
             then we can use primaryKey_UserName which is assigned userName from path variable to invoke UserDTO object that we want to update
         */
    @GetMapping("/update/{username}") // username is primary key (need to use primary key for the object you want to capture)
    public String editUser(@PathVariable("username") String primaryKey_UserName, Model model){
        UserDTO tobeUpdated=userService.findById(primaryKey_UserName);

        model.addAttribute("userToBeUpdated",tobeUpdated);

        // to fill Role dropDown
        model.addAttribute("roles",roleService.findAll());

        // to fill UserList table
        model.addAttribute("users",userService.findAll());

        return "/user/update";
    }

    @PostMapping("/update")
    public String update( UserDTO userDTO) {
        userService.update(userDTO);
        System.out.println(userService.findById(userDTO.getUserName()));
        return "redirect:/user/create";
    }


    @GetMapping("/delete/{username}")
    public String delete(@PathVariable(value = "username") String primaryKey_UserName){
        userService.deleteById(primaryKey_UserName);
        return "redirect:/user/create";
    }













}
