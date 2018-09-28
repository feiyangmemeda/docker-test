package com.example.spring5.webflux;

/**
 * @author feiyang.d
 * @date 2018/7/20
 */
public class User {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}
