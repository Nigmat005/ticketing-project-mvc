package com.cydeo.service.serviceimpl;

import com.cydeo.dto.UserDTO;
import com.cydeo.exception.UserException;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class UserServiceImpl extends AbstractMapService<UserDTO,String>implements UserService {

    @Override
    public UserDTO save(UserDTO userDTO) {
     return super.save(userDTO.getUserName(),userDTO);
    }

    @Override
    public UserDTO findById(String userName) {
      return super.findById(userName);
    }


    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }


    @Override
    public void deleteById(String userName) {
       super.deleteById(userName);
    }


}
