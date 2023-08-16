package com.cart.java;

import java.util.*;

import com.cart.java.Billing;
import com.cart.java.Admin.Item;

@SuppressWarnings("unused")
public class Admin {
	Scanner sc = new Scanner(System.in);
	
	public int maxCnt = 6; // number of items
	public int categories = 2; //Shopping categories = Food and Accessories
	
	class Item {
		String name; //name of the item
		double price;
		int ID;
		char theCategory;
		
		Item (int ID, String name , double price , char theCategory) {
			super();
			this.ID = ID;
			this.name = name;
			this.price = price;
			this.theCategory = theCategory;
		}
		
		private void setID(int theID) {
			this.ID = theID;
		}
		
		private void setCategory(char theCategory) {
			this.theCategory = theCategory;
		}
		
		private void setPrice(double price) {
			this.price = price;
		}
		
		private void setName(String name) {
			this.name = name;
		}
		
		public int getCategory() {
			return this.theCategory;
		}
		
		public double getPrice() {
			return this.price;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getID() {
			return this.ID;
		}
	}
	
	public Item [] itms = new Item[6];
	
	private void setMaxCnt(int maxCnt) {
		this.maxCnt = maxCnt;
	}
	
	public int getMaxCnt() {
		return this.maxCnt;
	}
	
	private void setNumberOfCategories(int categories) {
		this.categories = categories;
	}
	
	public int getNumberOfCategories() {
		return this.categories;
	}
	
	private void ListOfItems() {
		Admin ad = new Admin();

		itms[0] = ad.new Item(101 , "Olive Oil 1l", 850, 'f');
		itms[1] = ad.new Item(102 , "Cheese Slices", 50, 'f');
		itms[2] = ad.new Item(103 , "Bread", 30, 'f');
		itms[3] = ad.new Item(104, "Yoga Mat" , 1500 , 'a');
		itms[4] = ad.new Item(105 , "Eggs(1 dozen)" , 24 , 'f');
		
		/*
		 * 
		for (int i = 0 ; i < ad.maxCnt ; ++i) {
			int id = sc.nextInt();
			String str = sc.nextLine();
			double price = sc.nextDouble();
			char type = sc.next().charAt(0);
			
			itms[i] = ad.new Item(id, str , price , type);
		}
		*/
	}
	
	public static void main(String[] args) {
		int max = 50;
		int min = 10;
		double shipping = Math.random()*(max - min + 1) + min;
		Admin ad = new Admin();

		//setting the maximum count
		ad.setMaxCnt(6);
		System.out.println("The Max items: " + ad.getMaxCnt());
	
		Cart adC = new Cart();
		
		adC.addToCart(ad.itms[0]);
		adC.addToCart(ad.itms[1]);
		
		//adding a new items by admin - NOT initially in the list
		Item it1 = ad.new Item(777 , "Mosquito Bat" , 150 , 'a');
		//Item it2 = new Item(204, "Earbuds", 800 , 'a');
		adC.addToCart(it1);
	
		adC.showCart();
		
		adC.removefromCart(it1);
		
		adC.showCart();
		
		Billing adb = new Billing();
		adb.getAdminPayableAmount(adC);
	}

}


