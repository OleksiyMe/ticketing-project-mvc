package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;

import java.util.List;

public class UserServiceImpl extends AbstractMapService<UserDTO, String>  implements UserService {


    public UserServiceImpl() {
        super(roleService);
    }

    @Override
    public UserDTO save(UserDTO object) {
        return super.save( object.getUserName(), object );
    }

    @Override
    public UserDTO findById(String s) {
        return super.findById(s);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String s) {
        super.deleteById(s);

    }
}
