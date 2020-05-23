package com.syncfusion.manager;

import java.util.ArrayList;
import java.util.List;

import com.syncfusion.entity.Customer;

public class CustomerManager {
	private List<Customer> customerList= new ArrayList<Customer>();
	public boolean addCustomerDetails(Customer customer) {
		customerList.add(customer);
		if(customerList.isEmpty()) {
			return false;
		}
		return true;
	}
	public List<Customer> getCustomerDetails() {
	
		return new ArrayList<Customer>(customerList);
	}
	public void updateCustomerName(int customerId,String customerName) {
		for(Customer customer :customerList) {
			if(customer.getCustomerId()==customerId) {
				customer.setCustomerName(customerName);
				break;
			}
		}
	}
	public void updateCustomerEmailId(int customerId,String emailId) {
		for(Customer customer :customerList) {
			if(customer.getCustomerId()==customerId) {
				customer.setEmailId(emailId);
				break;
			}
		}
	}
	public void updateCustomerMobileNumber(int customerId, String mobileNumber) {
		for(Customer customer :customerList) {
			if(customer.getCustomerId()==customerId) {
				customer.setMobileNumber(mobileNumber);
				break;
			}
		}
		
	}
	public boolean deleteCustomerFromList(String customerName) {
		// TODO Auto-generated method stub
			boolean isDeleted=false;
			isDeleted=customerList.removeIf(n->(n.getCustomerName().equalsIgnoreCase(customerName)));
			for(Customer customer : customerList) {
				System.out.println(customer.getCustomerName());
			}
		return isDeleted;
	}
}
