package store.service;
import java.sql.*;
import java.util.*;
public class UserDao {
	
		private Connection con;
		PreparedStatement stat;
		private Scanner sc;
		public String userType;
		
		public UserDao() {
			con = UserConnect.getConnection();
			sc = new Scanner(System.in);
			
			}
		
		public void insertUser() {
			System.out.println("Enter User name ");
			String ename = sc.next();
			System.out.println("Enter User password ");
			String pass= sc.next();
			
			try {
				stat = con.prepareStatement("Insert users values(?,?)");
				stat.setString(1, ename);
				stat.setString(2, pass );				
				int result = stat.executeUpdate();
				if(result>0) {
					System.out.println("Successfully Registered");
				}
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}		
			
		}
	public void searchUser() {
		System.out.println("Enter username");
		String usn = sc.next();
		System.out.println("Enter Password");
		String upass = sc.next();
		try {
			stat=con.prepareStatement("Select username,password from users");
			System.out.println("check: "+usn);
			ResultSet r = stat.executeQuery();
			while(r.next()) {
				
				if(usn.equals("admin")) {
					
					this.userType = "admin";
					
				}
				else if((r.getString(1).equals(usn))){	
					
					this.userType = "Customer";
					break;
					
				}
				else {
					this.userType = "New user";
				}
			
				
		}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}


