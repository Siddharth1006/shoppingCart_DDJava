package com.cart.java;

import com.cart.java.Admin.Item;
import com.cart.java.Cart;

@SuppressWarnings("unused")

public class User {
	public static void main(String[] args) {
		Cart usC = new Cart();
		Admin ad = new Admin();
		
		/* adding items to the cart */
	    usC.addToCart(ad.itms[1]);
	    usC.addToCart(ad.itms[2]);
	    usC.addToCart(ad.itms[3]);
	  
	    System.out.println();
	    usC.showCart();
	    
	    usC.removefromCart(ad.itms[3]);
	    
	    Billing usB = new Billing();
	    usB.getUserPayableAmount(usC);
	
	}
}
