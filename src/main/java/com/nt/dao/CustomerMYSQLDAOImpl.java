package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Customer;

@Repository("custDAO-mysql")
public class CustomerMYSQLDAOImpl implements ICustomerDAO 
{
	//private static final String CUSTOMER_INFO_INSERT_QUERY="INSERT INTO SPRING_CUSTOMER_INFO VALUES(CNO,?,?,?,?,?)";
	
	// Notice we only provide 5 '?' because CNo is handled by the DB
		private static final String CUSTOMER_INFO_INSERT_QUERY = 
	    "INSERT INTO Spring_Customer_Info (CName, CAdd, BillAmount, Discount, FinalAmount) VALUES (?,?,?,?,?)";
	
	@Autowired
	private DataSource ds;

	@Override
	public int insert(Customer cust)throws Exception
	{
		int count = 0;
		
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(CUSTOMER_INFO_INSERT_QUERY);
			)
		{
			ps.setString(1,cust.getCname());
			ps.setString(2,cust.getCaddres());
			ps.setDouble(3,cust.getBillAmount());
			ps.setDouble(4,cust.getDiscount());
			ps.setDouble(5,cust.getFinalAmount());
			
			// execute Quesry In Sql Query
			count= ps.executeUpdate();
		}
		catch (SQLException se)
		{
			se.printStackTrace();
			throw se;  // exception rethrowing for exception proprogation
		}
		
		catch (Exception e) {
			e.printStackTrace();
			throw e;  // exception rethrowing for exception proprogation
		}
		
		return count;
	}

}
