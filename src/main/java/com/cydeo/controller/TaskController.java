package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping(value = "/task")
public class TaskController {

    private final ProjectService projectService;
    private final UserService userService;
    private final TaskService taskService;

    @Autowired
    public TaskController(ProjectService projectService, UserService userService,TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }



    @GetMapping("/create")
    public String createTask(Model model){
        model.addAttribute("taskObject",new TaskDTO());
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("employees",userService.findAllEmployees());
        model.addAttribute("tasks",taskService.findAll());
//        System.out.println("Before Save UUID is: "+taskDTO.getId());


        return "/task/create";
    }

    @PostMapping("/create")
    public String insertTask(@ModelAttribute("taskObject") TaskDTO taskDTO){
//        System.out.println("Before save method UUID is: "+taskDTO.getId());
        taskService.save(taskDTO);
//        System.out.println("After save method UUID is: "+taskDTO.getId());
//        System.out.println("After saved"+ taskService.findById(taskDTO.getId()));
        return "redirect:/task/create";
    }
    @GetMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteById(taskId);
        return "redirect:/task/create";
    }

    @GetMapping("/update/{taskId}")
    public String editTask(@PathVariable("taskId") Long taskId, Model model) {

        model.addAttribute("taskToBeUpdated", taskService.findById(taskId));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findAllEmployees());
        model.addAttribute("tasks", taskService.findAll());
        System.out.println(taskId);
        System.out.println(taskService.findById(taskId));

        return "task/update";

    }
    /*
        if variable in path is same as filed name in DTO class, then
        Spring will help you to sync the variable in pathVariable so that we don't need to
        call setter method to set the id
         */

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable(value = "id")Long id, TaskDTO task) {
        System.out.println(task.getId());
        System.out.println(taskService.findById(task.getId()));
        taskService.update(task);
        return "redirect:/task/create";
        }

//    @PostMapping("/update/{ids}")
//    public String updateTask(@PathVariable(value = "ids")Long id, TaskDTO task) {
//        System.out.println(task.getId());
//        System.out.println(taskService.findById(task.getId()));
//        task.setId(id);
//        taskService.update(task);
//        return "redirect:/task/create";
//    }
    }
