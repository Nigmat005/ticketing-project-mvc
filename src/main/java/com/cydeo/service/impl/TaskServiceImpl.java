package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO,Long> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO object) {
        if(object.getStatus()==null){
            object.setStatus(Status.OPEN);
        }
        if(object.getAssignedDate()==null){
            object.setAssignedDate(LocalDate.now());
        }

        if(object.getId()==null){
            object.setId(UUID.randomUUID().getMostSignificantBits());
        }
        return super.save(object.getId(),object);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void update(TaskDTO object) {
      this.save(object);
    }

    @Override
    public List<TaskDTO> findTasksByManager(UserDTO manager) {
        return super.findAll().stream()
                .filter(eachTask->eachTask.getProject().getAssignedManager().equals(manager))
                .collect(Collectors.toList());
    }
}
