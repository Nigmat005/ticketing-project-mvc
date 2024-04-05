package com.cydeo.service.serviceimpl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RoleServiceImpl  extends AbstractMapService<RoleDTO,Long> implements RoleService {
    List<RoleDTO> roles=new ArrayList<>();

    @Override
    public RoleDTO save(RoleDTO roleDTO){
     return super.save(roleDTO.getId(),roleDTO);
    }

    @Override
    public RoleDTO findById(Long id) {
       return super.findById(id);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }


    @Override
    public void deleteById(Long id) {
     super.deleteById(id);
    }
}
