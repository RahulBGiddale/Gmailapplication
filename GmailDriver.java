package com.te.HiberanatewithjdbcDynamic;

import java.nio.channels.AcceptPendingException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.jpawithHibernate.bean.Account;
import com.te.jpawithHibernate.bean.Inbox;

public class GmailDriver {
	


public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	System.out.println("Press 1 for login ");
	System.out.println("Press 2 for resister ");
	
	int Option=scanner.nextInt();
	switch(Option)
	{
	case(1):
	{
	System.out.println("enter Ur email id");
	String mail=scanner.next();
	System.out.println("enter your password");
	String pwd=scanner.next();
	EntityManagerFactory factory=null;
	EntityManager  manager=null;
	EntityTransaction  transaction=null;
	factory=Persistence.createEntityManagerFactory("GmailData");
	manager=factory.createEntityManager();
	String query="select Email from Account";
	String query3="select Password from Account";
	 Query  query2= manager.createQuery(query);
	Query  query4=	 manager.createQuery(query3);
	List<Account> list2=query4.getResultList();
	List<Account> list=query2.getResultList();
//	System.out.println(list);
//	System.out.println(list2);
	if(list.contains(mail)&&list2.contains(pwd))
	{
		System.out.println("Welcome To GMAIL");
		System.out.println("press A for compose");
		System.out.println("press B for show inbox");
		String option=scanner.next();
	switch(option)
	{
	case("A"):
	{
		System.out.println("enter from email id");
		String from=scanner.next();
		System.out.println("enter to email id");
		String to=scanner.next();
		System.out.println("enter the message");
		String Message=scanner.next();
		Account account=new Account();
		
	//	System.out.println(account.getUser_id());
	Inbox inbox2=new Inbox();
	inbox2.setMessage(Message);
	int User_Id=account.getUser_id();
	inbox2.setUser_Id(User_Id);
	int Message_Id=account.getUser_id()+to.charAt(1);
	//Message_Id++;
	inbox2.setMessage_Id(Message_Id);
	
		EntityManagerFactory factory2=null;
		EntityTransaction transaction2=null;
		EntityManager manager2=null;
		factory2=Persistence.createEntityManagerFactory("GmailData");
		manager2=factory2.createEntityManager();
		transaction2=manager2.getTransaction();
		transaction2.begin();
		
		
		manager2.persist(inbox2);
		
		
		transaction2.commit();
	System.out.println("your message hs been send sucessfully...............");
		System.out.println("Your unic Message_id is "+Message_Id);
		break;
	}
	case("B"):
	{
		System.out.println("INBOX");
		EntityManagerFactory  factory3=null;
		EntityManager manager3=null;
		EntityTransaction transaction3=null;
		factory3=Persistence.createEntityManagerFactory("GmailData");
		manager3=factory3.createEntityManager();
		transaction3=manager3.getTransaction();
		transaction3.begin();
		String query5="select Message from Inbox ";
		Query  query6= manager3.createQuery(query5);
		List list3=query6.getResultList();
		System.out.println(list3);
		
		
	}
	}
	}else
	{
	System.out.println("invalid user name or password");
	}
	break;
	}
	case(2):
	{
	
		System.out.println("Welcome to gmail resistration");
		System.out.println("Enter User Name");
		
		String User_Name=scanner.next();
		System.out.println("Enter the Password");
		String Password=scanner.next();
		System.out.println("Enter the Email");
	
		
		String Email=scanner.next();
		
		EntityManagerFactory  factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		factory=Persistence.createEntityManagerFactory("GmailData");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		transaction.begin();
		Account account=new  Account();
		account.setUser_Name(User_Name);
		account.setPassword(Password);
		account.setEmail(Email);
		
		int User_id=account.getUser_Name().charAt(2)+account.getUser_id()+17+account.getEmail().charAt(2)+account.getPassword().charAt(2);
		;
		account.setUser_id(User_id);
		manager.persist(account);
		System.out.println("Your Account has been successfully created........");
	
		System.out.println("Your unic User_Id is "+User_id);
	
		
		transaction.commit();
		break;
		
	}
	}
	
}
}
