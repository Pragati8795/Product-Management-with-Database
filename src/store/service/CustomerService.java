package store.service;
import java.util.Scanner;

import store.client.*;
public class CustomerService {
	private Scanner sc;
	private CustomerDao cdo;
	public void customerMenu() {
		sc = new Scanner(System.in);
		cdo = new CustomerDao();
			String choice = "y";
			while(choice.equals("y")) {
				System.out.println("1. Filter by price");
				System.out.println("2. Display List of Products ");
				System.out.println("3. Display Product by category ");				
				int ch = sc.nextInt();
				switch(ch) {
				case 1: 
					cdo.filterByPrice();
					break;
				case 2: 
					cdo.displayDetail();
					break;
				case 3:
					cdo.displayProductsByCategory();
					break;
				}
				System.out.println("You want to cotinue y/n");
				choice = sc.next();
			}
			
		

	}
	
}
