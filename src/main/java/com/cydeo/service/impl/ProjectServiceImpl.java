package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {
     private final TaskService taskService;
    @Autowired
    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }



    @Override
    public ProjectDTO save(ProjectDTO object) {
        if(object.getStatus()==null){
            object.setStatus(Status.OPEN);
        }
        return super.save(object.getProjectCode(),object);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDTO object) {
     super.update(object.getProjectCode(),object);
    }

    @Override
    public void deleteById(String projectCode) {
     super.deleteById(projectCode);
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public void complete(ProjectDTO projectDTO) {
        projectDTO.setStatus(Status.COMPLETE);
//        super.save(projectDTO.getProjectCode(),projectDTO);
    }

    @Override
    public List<ProjectDTO> findProjectUnderManger(UserDTO manager) {
        return super.findAll().stream()
                .filter(eachProject->eachProject.getAssignedManager().getUserName().equalsIgnoreCase(manager.getUserName()))
                .map(filteredProject->{
                    List<TaskDTO> tasks=taskService.findTasksByManager(manager);
                  int  unfinishedTaskCounts= (int) tasks.stream()
                          .filter(eachTask->eachTask.getProject().equals(filteredProject) && eachTask.getStatus()==Status.IN_PROGRESS).count();
                  int  completedTaskCounts= (int) tasks.stream().filter(eachTask->eachTask.getProject().equals(filteredProject) && eachTask.getStatus()==Status.COMPLETE).count();
                  filteredProject.setUnfinishedTaskCounts(unfinishedTaskCounts);
                  filteredProject.setCompleteTaskCounts(completedTaskCounts);
                  return filteredProject;
                })
                .collect(Collectors.toList());
    }
}
