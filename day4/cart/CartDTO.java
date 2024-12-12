package cart;

import java.util.ArrayList;

public class CartDTO {
	String id; 
	String productname; 
	int amount; 
	int totalprice;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public CartDTO(String id, String productname, int amount, int totalprice) {
		super();
		this.id = id;
		this.productname = productname;
		this.amount = amount;
		this.totalprice = totalprice;
	}
	public CartDTO() {
		
	}
	@Override
	public String toString() {
		return "CartDTO [id=" + id + ", productname=" + productname + ", amount=" + amount + ", totalprice="
				+ totalprice + "]";
	}
	
}
