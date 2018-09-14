import java.util.Arrays;
class Shoppingcart {
	int catsize;
	int cartsize;
	item[] cartitems;
	item[] catitems;
	String[] coupons = new String[4];
	double discamt = 0;
	int coucnt;
	double tax;
	Shoppingcart() {
		catitems = new item[10];
		cartitems = new item[10];
		catsize = 0;
		cartsize = 0;
		coucnt = 0;
		tax = 0;
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
		if (coucnt >= 1) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (coupons[i].equals(couponcode)) {
				flag = 1;
			}
		}
		if (flag == 0) {
			System.out.println("Invalid Coupon");
			return;
		}
		switch (couponcode) {
		case "IND10":
			coupons[0] = "N/A";
			discamt = discamt + (totalamount() * 0.1);
			coucnt++;
			break;
		case "IND20":
			coupons[1] = "N/A";
			discamt = discamt + (totalamount() * 0.2);
			coucnt++;
			break;
		case "IND30":
			coupons[2] = "N/A";
			discamt = discamt + (totalamount() * 0.3);
			coucnt++;
			break;
		case "IND50":
			coupons[3] = "N/A";
			discamt = discamt + (totalamount() * 0.5);
			coucnt++;
			break;
		default:
		}

	}
	double payableamount() {
		double payamt = 0;
		payamt = totalamount() - discamt;
		tax = (payamt * 0.15);
		payamt = payamt + tax;
		return payamt;
	}
	void print() {
		System.out.println("Name   quantity   Price");
		for (int j = 0; j < catsize; j++) {
			for (int i = 0; i < cartsize; i++) {
				if (cartitems[i].proquantity != 0 && catitems[j].proname.equals(cartitems[i].proname)) {
					System.out.println(catitems[j].proname + " " + cartitems[i].proquantity + " " + cartitems[i].prounitprice);
				}
			}
		}
		System.out.println("Total:" + totalamount());
		System.out.println("Disc%:" + discamt);
		System.out.println("Tax:" + tax);
		System.out.println("Payable amount: " + payableamount());
	}
}