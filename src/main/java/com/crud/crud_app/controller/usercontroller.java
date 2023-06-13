package com.crud.crud_app.controller;

import com.crud.crud_app.entity.user;
import com.crud.crud_app.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class usercontroller {
    @Autowired
    private userservice userservice;

    @PostMapping("/add")
    public String adduser(@RequestBody user user)
    {
        userservice.adduser(user);
        return " added !";

    }

    @GetMapping()
    public List<user> getusers ()
    {
        return userservice.getusers();
    }

    @GetMapping("/get")
    public user getbyId (@RequestParam Integer id)
    {
        return userservice.getbyId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateuser (@PathVariable Integer id ,@RequestBody user user)
    {
        userservice.updateuser(id,user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteuser (@PathVariable Integer id)
    {
        userservice.deleteuser(id);
        return "deleted!";
    }
}
