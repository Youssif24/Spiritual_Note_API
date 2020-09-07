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
    public void setUsers()
    {
        User user1=new User();
        user1.setName("Youssif Saad");
        user1.setAge(24);
        user1.setPassword("password1");
        userRepository.save(user1);

        User user2=new User();
        user2.setName("Hany Saad");
        user2.setAge(31);
        user2.setPassword("password2");
        userRepository.save(user2);

        User user3=new User();
        user3.setName("Nabil Saad");
        user3.setAge(34);
        user3.setPassword("password3");
        userRepository.save(user3);
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
