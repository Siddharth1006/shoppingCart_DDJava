package com.cart.java;

abstract class Offers {
	static double veteranDiscount = 0.03;
	static double fresherDiscount = 0.2;
	static double festiveOccasionDiscount = 0.01;
	
	int MaxCnt = 6;
	boolean veteranCustomer = false;
	boolean normalCustomer = false;
	boolean festiveOccasion = false;
	
	abstract void setDiscount(boolean val);

	@Override
	public String toString() {
		return "VeteranDiscount: " + veteranDiscount + " FresherDiscount: " + 
	fresherDiscount + " FestiveOccasionDiscount: " + festiveOccasionDiscount;
	}
}

class Veteran extends Offers {
	void setDiscount(boolean val) {
		this.veteranCustomer = val;
	}
}

class Normal extends Offers {
	void setDiscount(boolean val) {
		this.normalCustomer = val;
	}
}

class festival extends Offers {
	void setDiscount(boolean val) {
		this.festiveOccasion = val;
	}
}