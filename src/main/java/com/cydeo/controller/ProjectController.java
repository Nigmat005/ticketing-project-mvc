package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//        model.addAttribute("status", DataGenerator.getStatus());
        return "/project/create";
    }

    @PostMapping(value = "/create")
    public String insertProject(ProjectDTO projectDTO,Model model){
        // first store projectDTO created by GetMapping
        projectService.save(projectDTO);

//        model.addAttribute("project",new ProjectDTO());
//        model.addAttribute("managers",userService.findAllManager());
//        model.addAttribute("projects",projectService.findAll());
//        model.addAttribute("status", DataGenerator.getStatus());
        return "redirect:/project/create";  // endPoint
    }

    @GetMapping(value = "/update/{projectCode}")
    public String editProject(Model model, @PathVariable(value = "projectCode") String primaryKey_ProjectCode){
     model.addAttribute("projectToBeUpdated",projectService.findById(primaryKey_ProjectCode));
     model.addAttribute("managers",userService.findAllManager());
     model.addAttribute("projects",projectService.findAll());
     model.addAttribute("status", DataGenerator.getStatus());
     return "/project/update";
    }

    @PostMapping(value = "/update")
    public String updateProject(ProjectDTO projectDTO,Model model){
        // first store updated project
        projectService.update(projectDTO);

        return "redirect:/project/create";
    }

    @GetMapping(value = "/delete/{projectCode}")
    public String deleteProject(@PathVariable(value = "projectCode") String primaryKey_ProjectCode){
        projectService.deleteById(primaryKey_ProjectCode);
      return "redirect:/project/create";
    }

    @GetMapping(value = "/complete/{projectCode}")
    public String completeProject(@PathVariable(value = "projectCode") String primaryKey_ProjectCode){
        projectService.complete(projectService.findById(primaryKey_ProjectCode));
        return "redirect:/project/create";
    }

    @RequestMapping(value = "/manager/project-status",method = RequestMethod.GET)
    public String statusUpdate(Model model){
        UserDTO manager=userService.findById("john@cydeo.com");
        List<ProjectDTO> projects= projectService.findProjectUnderManger(manager);
        model.addAttribute("projects",projects);

        return "/manager/project-status";
    }
}
