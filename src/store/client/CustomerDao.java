package store.client;
import store.pojo.Product;
import java.util.*;
import store.dao.*;
public class CustomerDao {
	private Map<Integer, Product> mapproduct;
	private Scanner sc;
	public CustomerDao() {
		mapproduct = new HashMap<>();
		sc = new Scanner(System.in);
	}
	public void displayDetail() {
		mapproduct.entrySet().stream().forEach(data->{
			Product pd = data.getValue();
			System.out.println("Product Name "+pd.getProductName());
			System.out.println("Product Quantity"+pd.getAvailableQuantity());
			System.out.println("Buying Price "+pd.getBuyingPrice());
			System.out.println("Selling Price "+pd.getSellingPrice());
		
		});
		}
	public void displayProductsByCategory(){
		
		mapproduct.entrySet().stream().forEach(product->{
			Product prd = product.getValue();			
				System.out.println("Product Name "+ prd.getProductName());
				System.out.println("Product Selling Price "+ prd.getSellingPrice());
				System.out.println("Product Available quantity "+ prd.getAvailableQuantity());
		});
		
	}
	public void filterByPrice() {
		List<Product> listofproduct = new ArrayList<Product>();
		double min = 0.0;
		double max = 100000;
		//System.out.println(listofproducts +" size: " +listofproducts.size());
		ProductDao p = new ProductDao();
		for (Product productsVar : p.listofproducts){ 
		    if(productsVar.getSellingPrice()>= min && productsVar.getSellingPrice()<= max){
		       listofproduct.add(productsVar);
		    }
		    System.out.println("Products by Filter Price : "+listofproduct);
	}
	}
}

