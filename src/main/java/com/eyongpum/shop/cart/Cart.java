package com.eyongpum.shop.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.eyongpum.shop.product.Product;
import com.eyongpum.user.User;

public class Cart {
	private int cart_no;
	/****** User ************/
	private User user;
	/**** Product **********/
	private HashMap<Integer, CartItem> cartItemsMap = null;
	public Cart() {
		cartItemsMap = new HashMap<Integer, CartItem>();
	}
	public synchronized int add(String sUserId,int p_no,Product product, int cart_qty) {
		if (cartItemsMap.containsKey(p_no)) {
			CartItem cartItem = (CartItem) cartItemsMap.get(p_no);
			cartItem.setProduct_qty(cartItem.getProduct_qty()+cart_qty);
		} else {
			CartItem newItem = new CartItem(product,cart_qty);
			cartItemsMap.put(p_no, newItem);
		}
		return cartItemsMap.size();
	}
	public int update(String sUserId,int p_no,Product product,int cart_qty) {
		if (cartItemsMap.containsKey(p_no)) {
			CartItem cartItem = (CartItem) cartItemsMap.get(p_no);
			cartItem.setProduct_qty(cartItem.getProduct_qty()+cart_qty);
			if (cartItem.getProduct_qty()<= 0){
				cartItemsMap.remove(p_no);
			}
		}
		return cartItemsMap.size();
	}
	public  int deleteCartItem(int p_no)  throws Exception{
		if(cartItemsMap.containsKey(p_no)) {
			cartItemsMap.remove(p_no);
		}
		return cartItemsMap.size();
	}
	public synchronized int deleteCart(String sUserId)  throws Exception{
		cartItemsMap.clear();
		return cartItemsMap.size();
	}
	public synchronized double getTotal() {
		double amount = 0.0;
		for (Iterator cartItemKeyIter = cartItemsMap.keySet().iterator(); cartItemKeyIter.hasNext();) {
			Integer cartItemKey = (Integer) cartItemKeyIter.next();
			CartItem cartItem = cartItemsMap.get(cartItemKey);
			amount+= cartItem.getProduct_qty()+cartItem.getProduct().getP_price();
		}
		return roundOff(amount);
	}
	private double roundOff(double x) {
		long val = Math.round(x * 100);
		return val / 100.0;
	}
	public synchronized void clear() {
		cartItemsMap.clear();
	}
	public synchronized Collection<CartItem> getCartItemList(String sUserId) throws Exception{
		return cartItemsMap.values();
	}

}
