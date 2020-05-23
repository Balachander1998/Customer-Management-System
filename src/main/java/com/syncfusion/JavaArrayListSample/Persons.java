package com.syncfusion.JavaArrayListSample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import com.syncfusion.entity.Customer;
import com.syncfusion.manager.CustomerManager;

public class Persons {
	private Customer customer;
	private CustomerManager customerManager;
	private Scanner scanner = new Scanner(System.in);
	private File getFileNameFromResources(String fileName) {
		ClassLoader loader = getClass().getClassLoader();
		URL url = loader.getResource(fileName);
		if(url!=null) {
			System.out.println("File Found");
			return new File(url.getFile());
		}
		else {
		System.out.println("File Not Found");
		}
		return null;
	}
	private boolean addCustomerDetailsToList() {
		boolean isCustomersAdded=false;
		try {		
			File file = getFileNameFromResources("CustomerDetails");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line=bufferedReader.readLine();
			customerManager=new CustomerManager();
			while(line!=null) {
				String[] customerDetails=line.split(",");
				customer =new Customer();
				customer.setCustomerId(Integer.parseInt(customerDetails[0]));
				customer.setCustomerName(customerDetails[1]);
				customer.setEmailId(customerDetails[4]);
				customer.setMobileNumber(customerDetails[3]);
				isCustomersAdded=customerManager.addCustomerDetails(customer);
				line=bufferedReader.readLine();			
			}
			
			bufferedReader.close();
			fileReader.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return isCustomersAdded;
	}
	public void getCustomerDetailsFromList() {
	List<Customer> customerList=customerManager.getCustomerDetails();	
	for(Customer customer : customerList) {
		System.out.println(customer.getCustomerId()+" "+customer.getCustomerName()+" "+customer.getEmailId()+" "+customer.getMobileNumber());
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persons person = new Persons();
		boolean isPersonAdded=person.addCustomerDetailsToList();
		if(isPersonAdded==true) {
			System.out.println("The Customer details are been added to the list");
		}
		person.getCustomerDetailsFromList();
		person.updateCustomerDetails();	
		System.out.println("Enter the Customer Name you want to delete from the list...");
		String customerName=person.scanner.nextLine();
		boolean isDeleted=person.customerManager.deleteCustomerFromList(customerName);
		if(isDeleted) {
			System.out.println("Customer Deleted from the list..");
		}
	}
	private void updateCustomerDetails() {
		// TODO Auto-generated method stub
		System.out.println("Enter the number which you want to update");
		System.out.println("1. Customer Name");
		System.out.println("2. Customer MobileNumber");
		System.out.println("3. Customer Email_Id");
		int choiceForUpdate = scanner.nextInt();
		switch(choiceForUpdate) {
			case 1:
			{
				//For CustomerName
				System.out.println("Enter the customer Id to update name ....");
				int customerId =scanner.nextInt();	
				System.out.println("Enter the Name to be Updated....");
				String customerName=scanner.next();
				customerManager.updateCustomerName(customerId, customerName);
				break;
			}
			case 2:
			{
				//For customer MobileNumber
				System.out.println("Enter the customer Id to update mobileNumber");
				int customerId= scanner.nextInt();
				System.out.println("Enter the mobileNumber to be Updated....");
				String mobileNumber =scanner.next();
				customerManager.updateCustomerMobileNumber(customerId, mobileNumber);
				break;
			}
			case 3:
			{
				//For Customer EmailId
				System.out.println("Enter the customer Id to update email Id");
				int customerId=scanner.nextInt();
				System.out.println("Enter the emailId to be updated.....");
				String emailId=scanner.next();
				customerManager.updateCustomerEmailId(customerId, emailId);
				break;
			}		
			default:
			{
				System.out.println("Error 404 Not Found");
			}
		}
	}


}
