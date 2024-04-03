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
    public UserDTO findById(String userName) throws UserException {
      return super.findByID(userName);
    }


    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }


    @Override
    public void deleteByID(String userName) {
       super.deleteByID(userName);
    }


}
