package com.hy.backhy.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Testbean {
    String name;

    public  Testbean ( ) {
    }

    public void print () {
        System.out.println(this);
    }

}