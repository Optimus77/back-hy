package com.hy.backhy.Impl;

import com.hy.backhy.repository.testInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.lang.annotation.*;

@Slf4j
@Service
public class testInterImpl implements testInter {
    private static final String TAG = "testInterImpl";
    @Override
    public void get() {
        System.out.print("111111");
    }

    public void Test (){
    }

}
