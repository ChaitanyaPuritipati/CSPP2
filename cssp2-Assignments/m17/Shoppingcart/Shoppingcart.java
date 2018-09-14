import java.util.Arrays;
class Shoppingcart {
	int catsize;
	int cartsize;
	item[] cartitems;
	item[] catitems;
	Shoppingcart() {
		catitems = new item[10];
		cartitems = new item[10];
		catsize = 0;
		cartsize = 0;
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
		for (int i = indexof(argitem); i < cartsize; i++) {
			cartitems[i] = cartitems[i + 1];
			System.out.println(cartitems[i]);
		}
		cartsize--;
	}

}