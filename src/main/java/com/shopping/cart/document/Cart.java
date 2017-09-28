package com.shopping.cart.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cart {

	@Id 
	private Integer id;
	private String itemName;
	private Integer quantity;
	private Double unitPrice;
	private String itemLink;
//	private Integer orderId;
	private Integer userId;
	
	
	/**
	 * @param id
	 * @param itemName
	 * @param quantity
	 * @param unitPrice
	 * @param itemLink
	 */
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public Cart(Integer id, String itemName, Integer quantity, Double unitPrice, String itemLink, Integer userId) {
		super();
		this.id = id;
		this.userId = userId;
//		this.orderId = orderId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.itemLink = itemLink;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getItemLink() {
		return itemLink;
	}
	public void setItemLink(String itemLink) {
		this.itemLink = itemLink;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
	
	
	
}
