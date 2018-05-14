package com.controller;

import com.daoImpl.TestDao;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TestController {
    @Autowired
    private TestDao testDao;

    @GetMapping(value = "/test")
    public User hello(){
        User user = testDao.findByUsername("123").get(0);
        return user;
    }

    @GetMapping(value = "/")
    public String test(){
        return "123";
    }
}
