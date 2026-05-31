package com.nt.test;


import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.CustomerOperationControler;
import com.nt.model.Customer;

public class RealtimeDITest {
    public static void main(String[] args) {
        
    	Scanner sc= new Scanner(System.in);
    	
    	System.out.println("Enter Customer Name :: ");
    	String name =sc.nextLine();
    	
    	System.out.println("Enter Customer Address :: ");
    	String addres =sc.nextLine();
    	
    	System.out.println("Enter Customer Bill Amount :: ");
    	double billAmt = sc.nextDouble();

    	System.out.println("Enter Customer Discount :: ");
    	double discount = sc.nextDouble();
    	
    	// Create customer class object
    	Customer cust = new Customer();
    	cust.setCname(name);
    	cust.setCaddres(addres);
    	cust.setBillAmount(billAmt);
    	cust.setDiscount(discount);
    	
    	//create IOC Containern
    	
    	ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
    	
    	
    	// get Controller class  object  from the IOC  Container (dependecy Injection)
    	
    	CustomerOperationControler controller = ctx.getBean("custController",CustomerOperationControler.class);
    	
    	try 
    	{
    		String resultMsg =controller.processCustomer(cust);
    		System.out.println(" resultMsg ::"+resultMsg);
    		
    		System.out.println("-------------------------------------------------------------------------------");
    	
    		// Explicitly ask for the Util version to match the Bean
    		java.util.Date dt1 = ctx.getBean("java.util.Date", java.util.Date.class);
    		System.out.println("this date submitted ::" + dt1);
    		
    		// Explicitly ask for the Util version to match the Bean
    		java.util.Date dt2 = ctx.getBean("java.util.Date", java.util.Date.class);
    		System.out.println("this date submitted ::" + dt2);
    		

    	}
    	
    	catch (SQLException se) 
    	{
	
    			/// 		hikariCP  for  project 
    		
  		if (se.getErrorCode()==12899)	//	SQL code
			{
				System.out.println("Problem with colums size");
			}
		else {
				System.out.println("One are Db Prblem ");
			}
   		se.printStackTrace();
			
	
    		}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			System.out.println(" No  DB problem"+e.getMessage());
		}
    	ctx.close();
    	sc.close();
    	
    }
}
