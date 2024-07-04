package com.item.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productname;
    private int quantity;
    private double price;
	public Object getName() {
		
		return productname;
	}
	public void setName(Object name2) {
		this.productname = productname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int i) {
		
	}
	public Object getPrice() {
		
		return price;
	}
	public void setPrice(Object price2) {
		
}

}