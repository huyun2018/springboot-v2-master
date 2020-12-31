package com.springboot.v2.chapter05.pojo;

import com.springboot.v2.chapter05.enums.SexEnum;
import org.apache.ibatis.type.Alias;

@Alias(value="tuser")//MyBatis指定别名
public class TUser {

    private Long id = null;

    private String userName = null;

    //性别枚举，这里需要typeHandler进行转换
    private SexEnum sex = null;//枚举

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

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
