package com.hy.backhy.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="pc")
public class PC {
    @Id
    private String id;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
}
