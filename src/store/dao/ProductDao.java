package store.dao;
import store.pojo.Product;
import java.util.*;
public class ProductDao {
	private Map<Integer, Product> mapproduct;
	private Scanner sc;
	public List<Product> listofproducts ;
	public ProductDao() {
		mapproduct = new HashMap<>();
		sc = new Scanner(System.in);
		listofproducts = new ArrayList<Product>();
	}
	public void insertProduct() {
		System.out.println("Insert how many  Product");
		int noofProduct = sc.nextInt();
		for(int x =0; x < noofProduct; x++ ) {
			Product p = new Product();
			System.out.println("Enter Product Id");
			int pid = sc.nextInt();
			p.setProductID(pid);
			System.out.println("Enter Product Name");
			String pn = sc.next();
			p.setProductName(pn);
			System.out.println("Enter Product Price");
			double pr = sc.nextInt();
			p.setBuyingPrice(pr);
			p.setSellingPrice(pr);
			System.out.println("Enter Product Quantity");
			int pq = sc.nextInt();
			p.setAvailableQuantity(pq);
			System.out.println("Enter Product Category");
			String pc = sc.next();
			p.setCategory(pc);
			this.listofproducts.add(p);
			mapproduct.put(pid, p);
		}
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
	public void searchByCategory() {
		System.out.println("Enter Category");
		String pct = sc.next();
		mapproduct.entrySet().stream().forEach(product->{
			Product prd = product.getValue();
			if(prd.getCategory().equals(pct)) {
				System.out.println("Product name "+prd.getProductName());
				System.out.println("Product price is "+prd.getBuyingPrice());
			}
		});
	}
	public void searchByProductID() {
		System.out.println("Enter ProductID ");
		int pcid = sc.nextInt();
		mapproduct.entrySet().stream().forEach(product->{
			Product prd = product.getValue();
			if(prd.getProductID()== pcid) {
				System.out.println("Product name "+prd.getProductName());
				System.out.println("Product ID "+prd.getProductID());
				System.out.println("Product price is "+prd.getBuyingPrice());
			}
		});
	}
	public void searchByProductName() {
		System.out.println("Enter ProductID ");
		String pcname = sc.next();
		mapproduct.entrySet().stream().forEach(product->{
			Product prd = product.getValue();
			if(prd.getProductName().equals(pcname)) {
				System.out.println("Product name "+prd.getProductName());
				System.out.println("Product ID "+prd.getProductID());
				System.out.println("Product price is "+prd.getBuyingPrice());
			}
		});
	}
	public void checkTotalAmount(){
		
		double totalamt = mapproduct.entrySet().stream().map(prod->prod.getValue().getBuyingPrice()).reduce(0.0, (a,b)->a+b);
		System.out.println("Product total Price "+totalamt);
	}
	public void findProfitbyCategory() {
		
		mapproduct.entrySet().stream().forEach(product->{
			Product prd = product.getValue();			
				double amt = (prd.getSellingPrice()-prd.getBuyingPrice());
				System.out.println("Profit Price for Product category "+ prd.getCategory()+" is: "+amt);			
		});
		
	}
	
	public void findTotalProfit(){
		
		double profitAmt = mapproduct.entrySet().stream().map(prod->(prod.getValue().getSellingPrice()-prod.getValue().getBuyingPrice())).reduce(0.0, (a,b)->a+b);
		System.out.println("Total Product Profit Price "+profitAmt);		
	}
	
	public void displayProductsByCategory(){
		
		mapproduct.entrySet().stream().forEach(product->{
			Product prd = product.getValue();			
				System.out.println("Product Name "+ prd.getProductName());
				System.out.println("Product Selling Price "+ prd.getSellingPrice());
				System.out.println("Product Available quantity "+ prd.getAvailableQuantity());
		});
		
	}
	
	/*public static void main(String[] args) {
		ProductDao pdao=new ProductDao();
		pdao.insertProduct();
		pdao.displayDetail();
		pdao.displayProductsByCategory();
		pdao.searchByCategory();
		pdao.searchByProductID();
		pdao.checkTotalAmount();
		pdao.findProfitbyCategory();
		pdao.findTotalProfit();
	}*/
}
