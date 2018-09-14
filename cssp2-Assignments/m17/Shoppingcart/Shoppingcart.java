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
    	if(catsize == catitems.length) {
    		catresize();
    	}
    	catitems[catsize++] = argitem; 
    }
    void addtocart(item argitem) {
    	if(cartsize == cartitems.length) {
    		cartresize();
    	}
    	cartitems[cartsize++] = argitem;
    }

}