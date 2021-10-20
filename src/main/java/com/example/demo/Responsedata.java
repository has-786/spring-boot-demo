package com.example.demo;

import com.example.demo.entities.RtvPlanEntity;
import lombok.Data;

import java.util.List;

@Data
public class Responsedata{
    String name;
    List<RtvPlanEntity> rtvPlanEntityList;

}