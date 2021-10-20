package com.example.demo.controller;

import com.example.demo.Responsedata;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public interface FirstController {

    @GetMapping(path = "/getdata")
    Responsedata getData(@RequestParam("name") String name);

}
