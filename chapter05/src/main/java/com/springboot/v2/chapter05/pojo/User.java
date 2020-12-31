//package com.springboot.v2.chapter05.pojo;
//
//import com.springboot.v2.chapter05.converter.SexConverter;
//import com.springboot.v2.chapter05.enums.SexEnum;
//
//import javax.persistence.*;
//
//@Entity(name = "user")
//@Table(name = "t_user")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id = null;
//
//    @Column(name = "user_name")
//    private String userName = null;
//
//    @Convert(converter = SexConverter.class)
//    private SexEnum sex = null;//枚举
//
//    @Column(name = "note")
//    private String note = null;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public SexEnum getSex() {
//        return sex;
//    }
//
//    public void setSex(SexEnum sex) {
//        this.sex = sex;
//    }
//
//    public String getNote() {
//        return note;
//    }
//
//    public void setNote(String note) {
//        this.note = note;
//    }
//}
