package com.cart.java;

import java.util.ArrayList;
import java.util.ListIterator;

import com.cart.java.Admin.Item;

@SuppressWarnings("unused")
public class Cart {
	ArrayList<Item> item;
	Cart() {
		this.item = new ArrayList<Item>();
	}
	
	public void addToCart(Item theitem) {
		this.item.add(theitem);
	}
	
	public void showCart() {
		ListIterator<Item> iterator = item.listIterator();
		while(iterator.hasNext()) {
			Item theitem = iterator.next();
			System.out.println(theitem);
		}
	}
	
	public void removefromCart(Item it) {
		ListIterator<Item> iterator = item.listIterator();
		while(iterator.hasNext()) {
			Item item2 = iterator.next();
			if (item2.getName().equals(it.getName())) {
				this.item.remove(it);
				break;
			}
		}
	}
	
	public int getSize() {
		ListIterator<Item> iterator = item.listIterator();
		int cnt = 0;
		while(iterator.hasNext()) {
			Item theitem = iterator.next();
			cnt++;
		}
		return cnt;
	}
}