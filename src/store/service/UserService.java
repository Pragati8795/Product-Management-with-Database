package store.service;
import java.util.*;
import store.pojo.User;
public class UserService {
	private Scanner sc;
	private User userobj;
	private AdminService ads; 
	private CustomerService cus;
	public UserService() {
		sc = new Scanner(System.in);
		userobj = new User();
		ads = new AdminService();
		cus = new CustomerService();
	}
	public void CheckUser() {
		System.out.print("Enter Username ");
		userobj.setUsername(sc.next());
		System.out.print("Enter Password ");
		userobj.setPassword(sc.next());		
		if(userobj.getUsername().equals("admin") && userobj.getPassword().equals("admin")) {
			ads.adminMenu();
		}
		else {
			cus.customerMenu();
		}
	}
	
	public static void main(String[] args) {
		UserService us = new UserService();
		us.CheckUser();
	}
	
}
