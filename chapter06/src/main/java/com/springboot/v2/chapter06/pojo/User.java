package com.springboot.v2.chapter06.pojo;


import org.apache.ibatis.type.Alias;

@Alias("user")
public class User {

    private Long id = null;

    private String userName = null;

    private String note = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
