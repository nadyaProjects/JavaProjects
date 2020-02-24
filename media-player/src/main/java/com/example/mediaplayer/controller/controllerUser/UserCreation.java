package com.example.mediaplayer.controller.controllerUser;

import com.example.mediaplayer.repository.repositoryUser.DAO;
import com.example.mediaplayer.model.modelUser.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCreation {

    @Autowired
    DAO<User> userDao;

    public void process() {


        User user = User.create("Dana", "Whitley", "danaW@gmail.com", "1987-05-27", true);
        System.out.println("saving: " + user);
        userDao.save(user);

        user = User.create("Robin", "Cash", "cashR@gmail.com", "1994-03-12", false);

        user = User.create("Cate", "John", "catty@gmail.com", "2000-09-30", true);

        System.out.println("saving: " + user);
        userDao.save(user);

        List<User> list = userDao.loadAll();
        System.out.println("Loaded all: " + list);

    }
}
