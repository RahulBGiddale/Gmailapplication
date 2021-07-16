package com.te.jpawithHibernate.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Account implements Serializable{

	
	@Id
	private int User_id;
	private String  User_Name;
	private  String Password;
	private String Email;
	
	


}
