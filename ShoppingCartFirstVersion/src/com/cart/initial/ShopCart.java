package com.cart.initial;

import java.util.*;
import java.lang.Math;   

public class ShopCart {
	public static void listItems(ArrayList<String> lst , int[] prices) {
		System.out.println("\nListing items: ");
		
		System.out.println("Format: Item->Price");
		
		for (int i = 0 ; i < lst.size() ; ++i) {
			System.out.println(lst.get(i) + " -> " + prices[i]);
		}
		
		System.out.println();
	}

	public static void viewCart(LinkedHashMap<Integer, Integer> Cart , ArrayList<String> lst) {
		System.out.println("\n****** YOUR CART ******");
		
		for (int i = 0 ; i < lst.size() ; ++i) {
			System.out.println(lst.get(i) + "->" + Cart.get(i + 1));
		}
		
		System.out.println();
	}
	
	public static void addToCart(LinkedHashMap<Integer , Integer> Cart) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		char ch = 'n';
		
		while (true) {
			if (ch == 'y') break;
			
			while (true) {
				System.out.println("\nEnter the item number (Add To cart): ");
				int ItNumber = sc.nextInt();
				
				if (ItNumber >= 1 && ItNumber <= 6) {
					int cnt = Cart.get(ItNumber);
					Cart.put(ItNumber, cnt + 1);
					break;
				}
				else
					System.out.println("Invalid Number! Try Again! :( ");
			}
			
			System.out.println("\nDo you want to leave the cart? (Yes-y/No-any other key)");
			ch = sc.next().charAt(0);
		}
		
		System.out.println("Sorry to see you leave the cart :(. Come back again! :)");
		
		System.out.println();
	}
	
	public static void removeFromCart(LinkedHashMap<Integer , Integer> Cart) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		char ch = 'n';
		
		while (true) {
			if (ch == 'y') break;
			
			while (true) {
				System.out.println("\nEnter the item number (Remove from cart): ");
				int ItNumber = sc.nextInt();
				
				if (ItNumber >= 0 && ItNumber <= 6) {
					if (Cart.containsKey(ItNumber)) {
						int cnt = Cart.get(ItNumber);
						if(cnt > 0) 
							Cart.put(ItNumber, cnt - 1);
					}
					break;
				}
				else
					System.out.println("Invalid Number! Try Again! :( ");
			}	
			
			System.out.println("\nDo you want to leave the cart? (Yes-y/No-any other key)");
			ch = sc.next().charAt(0);
		}
		System.out.println("Sorry to see you leave the cart :(. Come back again! :)\n");
	}
	
	public static void offers() {
		System.out.println("\nList of offers: ");
		
		System.out.println("Independence Day offer - 5% off on payments more than 200 Rs.");
		System.out.println("Student Customers - 3% discount");
		System.out.println("Pregnant Customers - 5% discount");
		System.out.println("Disabled Customers - 3% discount");
		
		System.out.println();
	}
	
	public static void Payment(LinkedHashMap<Integer , Integer> Cart, int[] prices, int[] employeeType , 
			double[] discounts) {
		double totalCost = 0.0;
		double discountedCost = 0.0;
		double tax = 0.03; //3%
		
		int max = 50;
		int min = 10;
		double shipping = Math.random()*(max - min + 1) + min;
		
		for (int i = 0 ; i < prices.length ; ++i) {
			totalCost += (double) ((int) Cart.get(i + 1) * prices[i]);
		}
		
		System.out.println("Total Cost (Before discounts and tax): " + totalCost);
		
		for (int i = 0 ; i < 3 ; ++i) {
			discountedCost += (employeeType[i] == 1 ? discounts[i]*totalCost : 0);
		}
		
		System.out.println("Tax: " + tax);
		System.out.println("Discounted Cost: " + discountedCost);
		System.out.println("Shipping: " + shipping);
		
		totalCost -= discountedCost;
		totalCost += shipping;
		totalCost += tax*totalCost;
		
		System.out.println("Final Cost (After discounts, shipping and tax) : " + totalCost);
	
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to TheSHOP");
		System.out.println("Note: Please choose from the list of items provided.");
		
		ArrayList<String> lst = new ArrayList<String>();
		lst.add("1. Chocolate Box");
		lst.add("2. Eggs");
		lst.add("3. Perfume");
		lst.add("4. Bread");
		lst.add("5. Earbuds");
		lst.add("6. Salt");
		
		final int prices[] = {150 , 24 , 250 , 30 , 35 , 25};
		
		LinkedHashMap<Integer , Integer> Cart = new LinkedHashMap<Integer , Integer>();
		
		for(int i = 1 ; i <= 6 ; ++i) {
			Cart.put(i , 0);
		}
		
		int [] employeeType = new int[4];
		int i = -1 , ans = 0;
		
		System.out.println();
		System.out.println("First, please enter your type of customer: ");
		System.out.println("Are you a student(1/0)?");
		ans = sc.nextInt();
		employeeType[++i] = (ans == 1 ? 1 : 0); 
		
		System.out.println("Are you pregnant(1/0)?");
		ans = sc.nextInt();
		employeeType[++i] = (ans == 1 ? 1 : 0); 
		
		System.out.println("Are you disabled(1/0)?");
		ans = sc.nextInt();
		employeeType[++i] = (ans == 1 ? 1 : 0); 
		
		final double discounts[] = {0.03 , 0.05 , 0.03};
		
		System.out.println("\n***** WELCOME TO SHOPPING CART *****");
		
		while (true) {
			System.out.println();
			System.out.println("Choose one of the following options to get started! :) ");
			
			System.out.println("1. List Items");
			System.out.println("2. ADD to Cart");
			System.out.println("3. REMOVE from Cart");
			System.out.println("4. Offers/Coupons");
			System.out.println("5. View Cart");
			System.out.println("6. Payment");
			System.out.println("7. Exit");
			
			int choice = sc.nextInt();		
			
			switch (choice) {
			case 1:	listItems(lst , prices);
					break;
					
			case 2: addToCart(Cart);
					break;
					
			case 3: removeFromCart(Cart);
					break;
					
			case 4: offers();
					break;
					
			case 5: viewCart(Cart , lst);
					break;
					
			case 6: Payment(Cart , prices , employeeType , discounts);
					break;
					
			case 7: System.out.println("Exiting!.. See you again!");
					System.exit(0);
					
			default : System.out.println("WARNING : Entered wrong choice. Try again! :( ");
			}
		}
		
	}
}