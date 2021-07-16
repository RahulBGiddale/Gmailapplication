package com.te.jpawithHibernate.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Inbox {
	@Id
private int Message_Id;
private int User_Id;

private String Message; 
}
