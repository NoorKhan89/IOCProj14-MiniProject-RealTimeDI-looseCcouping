package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.dao.ICustomerDAO;
import com.nt.model.Customer;
@Service("custService")
public class ICustomerMgmSeriveImpl implements ICustomerMgmtService {

	@Autowired
	
	@Qualifier("db")
	private ICustomerDAO custDAO;
	@Override
	public String registerCustomer(Customer customer) throws Exception 
	{
		// calcuate discount and final amount
		
		double discountAmount =(customer.getBillAmount()*(customer.getDiscount()/100.0));
		
		double finalAmount = customer.getBillAmount()-discountAmount;
		customer.setFinalAmount(finalAmount);
		//		Using DAO
		int count = custDAO.insert(customer);
		
		return count == 0 ? "Customer registraction faild pelase try again()......":"Customer Registaction having BillAmount ::"+
		customer.getBillAmount()+""
				+ " Discount Amount :: "+customer.getDiscount()+" Final Amount :: "+finalAmount;
	}

}
