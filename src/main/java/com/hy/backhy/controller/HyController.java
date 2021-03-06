package com.hy.backhy.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hy.backhy.entity.PC;
import com.hy.backhy.entity.Phone;
import com.hy.backhy.repository.PcRepository;
import com.hy.backhy.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope(value = "singleton")
public class HyController {
    @Value("${index}")
    private String index;

    @Autowired
    private PhoneRepository phoneRepo;

    @Autowired
    private PcRepository pcRepo;

    @RequestMapping("/${Phone}")
    ResponseEntity phone(){

        JSONObject data=new JSONObject();
        JSONArray phones=new JSONArray();
        List<Phone> phoneList= phoneRepo.getPhoneList();

        for(Phone p:phoneList){
            phones.add(p);
        }

        data.put("phones",phones);
        data.put("totalPages","1");
        data.put("totalElements","2");

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @RequestMapping("/${Computer}")
    ResponseEntity pc(){
        JSONObject data=new JSONObject();
        JSONArray pcs=new JSONArray();
        List<PC> pcList= pcRepo.getPCList();

        for(PC p:pcList){
            pcs.add(p);
        }

        data.put("pcs",pcs);
        data.put("totalPages","1");
        data.put("totalElements","2");

        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
