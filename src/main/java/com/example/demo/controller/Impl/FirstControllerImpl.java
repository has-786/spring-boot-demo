package com.example.demo.controller.Impl;
import com.example.demo.Responsedata;
import com.example.demo.controller.FirstController;
import com.example.demo.entities.RtvPlanEntity;
import com.example.demo.repository.RtvPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FirstControllerImpl implements FirstController {

    @Autowired
    RtvPlanRepo rtvPlanRepo;
    @Override
    public Responsedata getData(String name){
        Responsedata data=new Responsedata();
        data.setName(name);
        List<RtvPlanEntity> rtvPlanEntityList=rtvPlanRepo.findAll();
        rtvPlanEntityList.forEach(r->System.out.println(r.getVendorName()));
        data.setRtvPlanEntityList(rtvPlanEntityList);
        return data;
    }
}

