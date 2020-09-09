package com.spiritual.note.controller;

import com.spiritual.note.model.entity.User;
import com.spiritual.note.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users/")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping(value = "createUsers")
    //response entity created to send status code
    public ResponseEntity<String> create_users()
    {
        String result=userServices.setUsers();
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @PostMapping(value = "saveUser")
    public User saveUser(@RequestBody User user)
    {
        /*User user1=userServices.saveUser(user);
        return new ResponseEntity<>(user1,HttpStatus.CREATED);*/
        return userServices.saveUser(user);
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<List<User>> getAll()
    {
        List<User> userList= (List<User>) userServices.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping(value = "findUser/{id}")
    public User findUser(@PathVariable int id) {
            return userServices.getUserById(id);
    }

    @DeleteMapping(value = "deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id)
    {
        userServices.deleteUserById(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }

}
