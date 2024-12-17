package store.service;
import java.util.Scanner;

import store.client.*;
import store.dao.ProductConnect;
public class CustomerService {
	private Scanner sc;
	private CustomerDao cdo;
	private  ProductConnect pc;
	public void customerMenu() {
		sc = new Scanner(System.in);
		cdo = new CustomerDao();
		pc = new ProductConnect();
			String choice = "y";
			while(choice.equals("y")) {
				System.out.println("1. Filter by price");
				System.out.println("2. Display List of Products ");
				System.out.println("3. Display Product by category ");				
				int ch = sc.nextInt();
				switch(ch) {
				case 1: 
					pc.displayProductByPrice();
					//cdo.filterByPrice();
					break;
				case 2: 
					pc.displayProduct();
					//cdo.displayDetail();
					break;
				case 3:
					pc.searchByCategory();
					//cdo.displayProductsByCategory();
					break;
				}
				System.out.println("You want to cotinue y/n");
				choice = sc.next();
			}
			
		

	}
	
}
