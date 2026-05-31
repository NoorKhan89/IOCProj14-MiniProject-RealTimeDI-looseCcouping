package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Customer;
import com.nt.service.ICustomerMgmtService;

@Controller("custController")
public class CustomerOperationControler 
{
	@Autowired
	private ICustomerMgmtService custService;
	
	public String processCustomer(Customer customer)throws Exception
	{
		String result = custService.registerCustomer(customer);
		return result;
	}
	
}
