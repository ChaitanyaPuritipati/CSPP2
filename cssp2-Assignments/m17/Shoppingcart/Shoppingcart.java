import java.util.Arrays;
class Shoppingcart {
	int catsize;
	int cartsize;
	item[] cartitems;
	item[] catitems;
	String[] coupons = new String[4];
	double discamt = 0;
	Shoppingcart() {
		catitems = new item[10];
		cartitems = new item[10];
		catsize = 0;
		cartsize = 0;
		coupons[0] = "IND10";
		coupons[1] = "IND20";
		coupons[2] = "IND30";
		coupons[3] = "IND50";
	}
	void catresize() {
		catitems = Arrays.copyOf(catitems, 2 * catsize);
	}
	void cartresize() {
		cartitems = Arrays.copyOf(cartitems, 2 * cartsize);
	}
	void addtocatalog(item argitem) {
		if (catsize == catitems.length) {
			catresize();
		}
		catitems[catsize] = argitem;
		catsize++;
	}
	void addtocart(item argitem) {
		if (cartsize == cartitems.length) {
			cartresize();
		}
		cartitems[cartsize] = argitem;
		cartsize++;
	}
	int indexof(item argitem) {
		for (int i = 0; i < cartsize; i++) {
			if (cartitems[i].proname.equals(argitem.proname)) {
				return i;
			}
		}
		return -1;
	}
	void removefromcart(item argitem) {
		cartitems[indexof(argitem)].proquantity = cartitems[indexof(argitem)].proquantity - argitem.proquantity;
	}
	void showcatalog() {
		for (item catitem : catitems) {
			if (catitem != null) {
				System.out.println(catitem);
			}
		}
	}
	void showcart() {
		for (item cartitem : cartitems) {
			if (cartitem != null) {
				System.out.println(cartitem.proname + " " + cartitem.proquantity);
			}
		}
	}
	double totalamount() {
		double totalamnt = 0;
		for (item cartitem : cartitems) {
			if (cartitem != null) {
				totalamnt = totalamnt + ((cartitem.proquantity) * (cartitem.prounitprice));
			}
		}
		return totalamnt;
	}
	void applycoupon(String couponcode) {
		int flag = 0;
		for (int i = 0; i < 4; i++) {
			if (coupons[i].equals(couponcode)) {
				flag = 1;
			}
		}
		if (flag == 0) {
			return;
		}
		switch (couponcode) {
		case "IND10":
			coupons[0] = null;
			discamt = discamt + (totalamount() * 0.1);
			break;
		case "IND20":
			coupons[1] = null;
			discamt = discamt + (totalamount() * 0.2);
			break;
		case "IND30":
			coupons[2] = null;
			discamt = discamt + (totalamount() * 0.3);
			break;
		case "IND50":
			coupons[3] = null;
			discamt = discamt + (totalamount() * 0.5);
			break;
		default:
		}

	}
	double payableamount() {
		double payamt = 0;
		payamt = totalamount() + (totalamount() * 0.15) + discamt;
		return payamt;
	}
}