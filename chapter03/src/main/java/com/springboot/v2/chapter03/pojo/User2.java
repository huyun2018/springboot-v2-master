package com.springboot.v2.chapter03.pojo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("user2")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class User2 {

//    @Value("2")
    private Long id;

//    @Value("user_name_2")
    private String userName;

//    @Value("note_2")
    private String note;

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
