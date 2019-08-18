package com.hy.backhy.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Data
@Entity
@Table(name="pc")
public class PC {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    private String price;
    private String title;

    public PC() {
    }

    public PC(String name, String price, String title) {
        this.name = name;
        this.price = price;
        this.title = title;
    }

}
