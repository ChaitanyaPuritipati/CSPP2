import java.util.Arrays;
class Shoppingcart {
	int catsize;
	int cartsize;
	item[] cartitems;
	item[] catitems;
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
		for (int j = 0; j < catsize; j++) {
			if (catitems[j].proname.equals(argitem.proname)) {
				if (catitems[j].proquantity < argitem.proquantity) {
					return;
				}
				catitems[j].proquantity = catitems[j].proquantity - argitem.proquantity;
				break;
			}
		}
		for (int i = 0; i < cartsize; i++) {
			if (cartitems[i].proname.equals(argitem.proname)) {
				cartitems[i].proquantity = cartitems[i].proquantity + argitem.proquantity;
				return;
			}
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
		System.out.println(cartitems[indexof(argitem)] + "entered");
		if (cartitems[indexof(argitem)].proquantity == 0) {
			System.out.println("entered looppppppp");
			for (int i = indexof(argitem); i < cartsize - 1; i++) {
				System.out.println(cartitems[i].proname + "before");
				cartitems[i] = cartitems[i + 1];
				System.out.println(cartitems[i].proname + "after");
			}
			cartsize--;
		}
		for (int j = 0; j < catsize; j++) {
			if (catitems[j].proname.equals(argitem.proname)) {
				catitems[j].proquantity = catitems[j].proquantity + argitem.proquantity;
				break;
			}
		}
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
			// && cartitem.proquantity != 0
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
		if (coucnt >= 1) {
			return;
		}
		switch (couponcode) {
		case "IND10":
			discamt = discamt + (totalamount() * 0.1);
			coucnt++;
			break;
		case "IND20":
			discamt = discamt + (totalamount() * 0.2);
			coucnt++;
			break;
		case "IND30":
			discamt = discamt + (totalamount() * 0.3);
			coucnt++;
			break;
		case "IND50":
			discamt = discamt + (totalamount() * 0.5);
			coucnt++;
			break;
		default:
			System.out.println("Invalid coupon");
			break;
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
		for (int i = 0; i < cartsize; i++) {
			if (cartitems[i].proquantity != 0) {
				System.out.println(cartitems[i].proname + " " + cartitems[i].proquantity + " " + cartitems[i].prounitprice);
			}
		}
		System.out.println("Total:" + totalamount());
		System.out.println("Disc%:" + discamt);
		System.out.println("Tax:" + tax);
		System.out.println("Payable amount: " + payableamount());
	}
}