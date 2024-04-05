package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final RoleService roleService;
    private final UserService userService;
    @Autowired
    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }
    @GetMapping("/create")
    public String userCreate(Model model){
        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles",roleService.findAll()); // bring me all roles from database meaning this is business logic and should come from Service level
        model.addAttribute("users",userService.findAll());
        System.out.println(userService.findAll());
        return "user/create";
    }

    @PostMapping("/create")
    public String  insertUser(@ModelAttribute("user") UserDTO userDTO,Model model){
        userService.save(userDTO);
        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("users",userService.findAll());
        return "/user/create";
    }
}
