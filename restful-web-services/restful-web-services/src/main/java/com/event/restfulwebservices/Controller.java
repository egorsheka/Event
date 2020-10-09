package com.event.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(path = "/get")
    public String getMethod(){
        return "json";
    }

    @GetMapping(path = "/user/{name}")
    public String getMethodUser(@PathVariable String name){
        return "His name is " + name;
    }

    @PostMapping(path = "/post")
    public String postMethod(){
        return "json";
    }


}
