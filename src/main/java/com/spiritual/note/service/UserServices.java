package com.spiritual.note.service;

import com.spiritual.note.error.exceptions.ConflictException;
import com.spiritual.note.error.exceptions.NotFoundExceptionHandler;
import com.spiritual.note.error.exceptions.NotNullException;
import com.spiritual.note.genericTools.Validation;
import com.spiritual.note.model.entity.User;
import com.spiritual.note.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    /*
    * set users manually
    * */
    public String setUsers()
    {
        for (int i=0;i<=10;i++)
        {
            User user=new User();
            user.setName("username"+i);
            user.setPassword("password"+i);
            user.setAge(20+i);
            userRepository.save(user);
        }
        return "Users Created Successfully";
    }

    public Iterable<User> getAllUsers()
    {
        return userRepository.findAll();
    }


    public void deleteUserById(int id)
    {
        userRepository.deleteById(id);
    }


    public User saveUser(User user)
    {
        if(userRepository.findByName(user.getName()) !=null)
        {
            throw new ConflictException("this username is exist");
        }
        else if(!(Validation.validateText(user.getName())))
        {
            throw new NotNullException("username can't be empty");
        }
        return userRepository.save(user);
    }


    public User getUserById(int id)
    {
        try {
            return userRepository.findById(id).get();
        }catch (NoSuchElementException exception)
        {
            throw new NotFoundExceptionHandler(String.format("This user with id: [%s] not found",id));
        }
    }

}
