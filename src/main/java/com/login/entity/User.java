package com.login.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name="userdetails")
@Data
@Table(name="User")
public class User {
	
	@Id
	private int id;
	private String username;
	private String password;
	//private String email;
	

}
