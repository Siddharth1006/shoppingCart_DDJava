package com.cart.java;

import com.cart.java.Admin;
import com.cart.java.User;

@SuppressWarnings("unused")
public class Billing {
	
	static double conveniencefee = 15.34;
	
	double gst = 0.03;
	double shipping = 150;
	double totalAmount = 0.0;
	double payableAmount = 0.0;
	
	public void setGST(Billing b , double gst) {
		this.gst = gst;
	}
	
	protected void setShipping(double shipping) {
		this.shipping = shipping;
	}
	
	protected double getGST() {
		return this.gst;
	}
	
	protected double getShipping() {
		return this.shipping;
	}
	
	@Override
	public String toString() {
		return "GST: " + this.gst + " and Shipping: " + this.shipping;
	}
	
	public double getAdminPayableAmount(Cart adC) {
		for(int i = 0 ; i < adC.getSize() ; ++i) {
			
		}
		return payableAmount;
	}
	
	public double getUserPayableAmount(Cart usC) {
		for(int i = 0 ; i < usC.getSize() ; ++i) {
			
		}
		return payableAmount;
	}
}
