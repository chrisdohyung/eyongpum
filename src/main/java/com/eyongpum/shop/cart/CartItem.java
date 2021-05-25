package com.eyongpum.shop.cart;

import com.eyongpum.shop.product.Product;

public class CartItem {
	private Product product;
	private int product_qty;
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	public CartItem(Product product, int product_qty) {
		super();
		this.product = product;
		this.product_qty = product_qty;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProduct_qty() {
		return product_qty;
	}
	public void setProduct_qty(int product_qty) {
		this.product_qty = product_qty;
	}
	public int getTotalPrice() {
		return product_qty * product.getP_price();
	}

}
