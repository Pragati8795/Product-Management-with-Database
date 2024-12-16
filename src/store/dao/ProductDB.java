package store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductDB {
	private static Connection cn;
	public ProductDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Item","root","root123");
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
		ProductDB e1 = new ProductDB();
		return cn;
	}


}