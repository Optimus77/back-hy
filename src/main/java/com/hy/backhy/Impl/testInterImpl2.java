package com.hy.backhy.Impl;

import com.hy.backhy.repository.testInter;
import org.springframework.stereotype.Service;

@Service
public class testInterImpl2 implements testInter {
    @Override
    public void get() {
        System.out.print("222222");
    }
}
