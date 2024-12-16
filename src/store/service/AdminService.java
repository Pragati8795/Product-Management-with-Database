package store.service;
import java.util.Scanner;
import store.dao.*;
public class AdminService {
	private Scanner sc;
	private ProductDao pdo;
	public void adminMenu() {
				sc = new Scanner(System.in);
				pdo = new ProductDao();
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
						pdo.displayDetail();
						break;
					case 2: 
						pdo.searchByProductID();
						break;
					case 3:
						pdo.displayProductsByCategory();
						break;
					case 4:
						pdo.searchByProductName();
						break;
					case 5:
						pdo.checkTotalAmount();
						break;
					case 6:
						pdo.findProfitbyCategory();
						break;
					case 7:
						pdo.insertProduct();
						break;
					}
					System.out.println("You want to cotinue y/n");
					choice = sc.next();
				}
	}
}
