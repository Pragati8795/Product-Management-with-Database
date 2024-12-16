package store.service;
import java.sql.*;
public class UserConnect {
	
	
		private static Connection cn;
		private UserConnect() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deloitteemp","root","root123");
				System.out.println("Database connected");
			}
			catch(ClassNotFoundException ex) {
				System.out.println("Unable to load driver");
			}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
			
		}
		/*public static void main(String []arg) {
			EmployeeConnect ec = new EmployeeConnect();
		}*/
		
		public static Connection getConnection() {
			UserConnect e1 = new UserConnect();
			return cn;
		}
	

}
