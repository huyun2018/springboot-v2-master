package com.springboot.v2.chapter08.pojo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**** imports ****/
@Document
public class Role implements Serializable {
	private static final long serialVersionUID = -6843667995895038741L;
	private Long id;
	@Field("role_name")
	private String roleName = null;
	private String note = null;

	/**** setter and getter ****/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}