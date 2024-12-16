package store.dao;
import java.sql.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections; 

import store.pojo.Product;

public class ProductConnect {
	private Connection con;
	PreparedStatement stat;
	private Scanner sc;
	public String userType;
	private Product p;
	
	public ProductConnect() {
		con = ProductDB.getConnection();
		sc = new Scanner(System.in);
		p = new Product();
		}
	
	public void insertProduct() {	
		System.out.println("Enter Product Id");
		int pid = sc.nextInt();		
		System.out.println("Enter Product Name");
		String pn = sc.next();		
		System.out.println("Enter Product Price");
		double pr = sc.nextInt();		 
		double sr = pr+pr*0.5;
		System.out.println("Enter Product Quantity");
		int pq = sc.nextInt();		
		System.out.println("Enter Product Category");
		String pc = sc.next();
		
		try {
			stat = con.prepareStatement("Insert Product values(?,?,?,?,?,?)");
			stat.setInt(1, pid);
			stat.setString(2, pn);
			stat.setDouble(3, pr);
			stat.setInt(4, pq);
			stat.setString(5, pc);
			stat.setDouble(6, sr);
			int result = stat.executeUpdate();
			if(result>0) {
				System.out.println("Successfully Added Products");
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}		
		
	}
	public void displayProduct() {
		try {
			stat = con.prepareStatement("select * from product");
			ResultSet r = stat.executeQuery();	
			while(r.next()) {
				System.out.println("Product ID "+r.getString(1));
				System.out.println("Product Name "+r.getString(2));
				System.out.println("Product Price "+r.getString(3));
				System.out.println("Product Quantity "+r.getString(4));
				System.out.println("Product Category "+r.getString(5));
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void searchProductbyId() {
		try {
			System.out.println("Enter Product ID");
			int prid = sc.nextInt();
			stat = con.prepareStatement("select * from product where ProductID=?");
			stat.setInt(1, prid);
			ResultSet r = stat.executeQuery();	
			while(r.next()) {
				System.out.println("Product ID "+r.getString(1));
				System.out.println("Product Name "+r.getString(2));
				System.out.println("Product Price "+r.getString(3));
				System.out.println("Product Quantity "+r.getString(4));
				System.out.println("Product Category "+r.getString(5));
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void searchByCategory() {
		
		try {
			stat = con.prepareStatement("select * from product");
			ResultSet rs = stat.executeQuery();	
			System.out.println("Available categories are: ");
			while(rs.next()) {
				System.out.println("Product Category "+rs.getString(5));
			}
			System.out.println("Enter Category name you want to search ");
			String pcat = sc.next();
			stat = con.prepareStatement("select * from product where ProductCategory=?");
			stat.setString(1, pcat);
			ResultSet r = stat.executeQuery();	
			while(r.next()) {
				
				System.out.println("Product Name "+r.getString(2));
				System.out.println("Product Price "+r.getString(3));
				System.out.println("Product Quantity "+r.getString(4));
				System.out.println("Product Category "+r.getString(5));
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
public void searchByName() {
		
		try {
			System.out.println("Enter Product name you want to search ");
			String pname = sc.next();
			stat = con.prepareStatement("select * from product where ProductName=?");
			stat.setString(1, pname);
			ResultSet r = stat.executeQuery();	
			while(r.next()) {
				System.out.println("Product ID "+r.getString(1));
				System.out.println("Product Name "+r.getString(2));
				System.out.println("Product Price "+r.getString(3));
				System.out.println("Product Quantity "+r.getString(4));
				System.out.println("Product Category "+r.getString(5));
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void totalPrice() {
	
	try {
		
		double totalPrice =0.0;
		stat = con.prepareStatement("select * from product");
		ResultSet r = stat.executeQuery();	
		while(r.next()) {
			totalPrice = r.getDouble(3) + totalPrice;
			
		}
		System.out.println("Total Price "+totalPrice);
		
	}
	catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	
}
	public void totalProfitByCategory() {
		
		try {
			int i =0;
			int x=0;
			double totalprice =0.0;
			System.out.println("i"+i);
			
			stat = con.prepareStatement("select * from product");			
			ResultSet r = stat.executeQuery();	
			while(r.next()) {
				i++;				
			}
			Double [] prices = new Double[i];
			
			String [] productnameList = new String[i];
			
			 List list1 = new ArrayList();
			 
			stat = con.prepareStatement("select * from product");			
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				
				if(list1.contains(rs.getString(5))) {
					System.out.println("Match c");
					int index = list1.indexOf(rs.getString(5));
					totalprice = rs.getDouble(6) - rs.getDouble(3);
					prices[index]= prices[index] + totalprice;
					totalprice = 0.0;
				}
				else {
					totalprice = rs.getDouble(6) - rs.getDouble(3);				
					prices[x]= totalprice;
					list1.add(rs.getString(5)) ;
					x++;
					totalprice =0.0;
				}
				
			}
						
			for(int y=0; y<x; y++) {
				System.out.println("Total Profit Price for Product Category: "+list1.get(y) + " is " +prices[y] );
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void displayProductByPrice() {
		
		try {
			
			int x=0;
			
			 List pricelist = new ArrayList();
			 List productNamelist = new ArrayList();
			 
			stat = con.prepareStatement("select * from product");			
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {				
				productNamelist.add(rs.getString(2));									
				pricelist.add(rs.getDouble(6)) ;	
				x++;
				
			}
			
			Collections.sort(pricelist, Collections.reverseOrder());  	
			System.out.println("Product Filter as per Price is: ");
			for(int y=0; y<x; y++) {
				System.out.println("Product name " +productNamelist.get(y) + "Price is  : "  +pricelist.get(y) );
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	
}
