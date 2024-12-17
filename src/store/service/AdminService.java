package store.service;
import java.util.Scanner;
import store.dao.*;
public class AdminService {
	private Scanner sc;
	private ProductDao pdo;
	private  ProductConnect pc;
	public void adminMenu() {
				sc = new Scanner(System.in);
				pdo = new ProductDao();
				pc = new ProductConnect();
				String choice = "y";				
				while(choice.equals("y")) {
					System.out.println("1. List the products in the store" );
					System.out.println("2. Search the product by using Product Id");
					System.out.println("3. List the products by category");
					System.out.println("4. Search the product by using the name");
					System.out.println("5. To check the total amount, spend on her products");
					System.out.println("6. The Profit amount that she gets on category wise");
					System.out.println("7. Add Products");
					
					int ch = sc.nextInt();
					switch(ch) {
					case 1: 
						pc.displayProduct();
						//pdo.displayDetail();
						break;
					case 2: 
						pc.searchProductbyId();
						//pdo.searchByProductID();
						break;
					case 3:
						pc.searchByCategory();
						//pdo.displayProductsByCategory();
						break;
					case 4:
						pc.searchByName();
						//pdo.searchByProductName();
						break;
					case 5:
						pc.totalPrice();
						//pdo.checkTotalAmount();
						break;
					case 6:
						pc.totalProfitByCategory();
						//pdo.findProfitbyCategory();
						break;
					case 7:
						pc.insertProduct();
						//pdo.insertProduct();
						break;
					}
					System.out.println("You want to cotinue y/n");
					choice = sc.next();
				}
	}
}
