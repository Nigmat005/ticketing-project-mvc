package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final UserService userService;
    private final ProjectService projectService;
    @Autowired
    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }


    @GetMapping(value = "/create")
    public String create(Model model){
        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("managers",userService.findAllManager());
        model.addAttribute("projects",projectService.findAll());
        return "/project/create";
    }

    @PostMapping(value = "/create")
    public String insertProject(ProjectDTO projectDTO,Model model){
        // first store projectDTO created by GetMapping
        projectService.save(projectDTO);

        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("managers",userService.findAllManager());
        model.addAttribute("projects",projectService.findAll());
        return "/project/create";
    }
}
