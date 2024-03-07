package com.learnsecurity.service;


import com.learnsecurity.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> userList = new ArrayList<>();

    public UserService() {
        userList.add(new User("abc","abc","abc@gmai;.com"));
        userList.add(new User("xyz","xyz","xyz@gmail.com"));

    }

    public List<User> getAllUsers(){
        return this.userList;
    }

    public User getUser(String username){

        return this.userList.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    public User addUser(User user){
        this.userList.add(user);
        return user;
    }


}
