package com.crud.crud_app.service.implementation;

import com.crud.crud_app.entity.user;
import com.crud.crud_app.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.crud.crud_app.repository.userRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class userServiceImplelnts implements userservice {
    @Autowired
    private userRepository userRepository;
    @Override
    public void adduser(user user) {
        userRepository.save(user);
    }

    @Override
    public List<user> getusers() {
        return userRepository.findAll();
    }

    @Override
    public user getbyId(Integer id) {
        user user = userRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND , "invalid user id" +id));
        return user;
    }

    @Override
    public void updateuser(Integer id, user user) {
        userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , "invalid user id"+id));
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void deleteuser(Integer id) {
       user user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , "invalid user id"+id));
       userRepository.delete(user);

    }
}
