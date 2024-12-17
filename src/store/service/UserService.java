package store.service;
import java.util.*;
import store.pojo.User;
public class UserService {
	private Scanner sc;
	private User userobj;
	private AdminService ads; 
	private CustomerService cus;
	private UserDao ud;
	public UserService() {
		sc = new Scanner(System.in);
		userobj = new User();
		ads = new AdminService();
		cus = new CustomerService();
		ud = new UserDao();
	}
	public void CheckUser() {
		/*System.out.print("Enter Username ");
		userobj.setUsername(sc.next());
		System.out.print("Enter Password ");
		userobj.setPassword(sc.next());	*/
		ud.searchUser();
		if(ud.userType.equals("admin")) {
			ads.adminMenu();
		}
		else if(ud.userType.equals("New user")){
			System.out.print("Welcome New User !! ");
			System.out.print("Please Register yourself to get 100 Bonus Point as Welcome gift !! ");
			ud.insertUser();
			cus.customerMenu();
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
