package com.crud.crud_app.service;

import com.crud.crud_app.entity.user;

import java.util.List;

public interface userservice {
    void adduser (user user);
    List<user> getusers ();

    user getbyId(Integer id);

    void updateuser(Integer id, user user);

    void deleteuser(Integer id);
}
