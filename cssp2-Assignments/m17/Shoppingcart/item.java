class item {
	String proname;
	int proquantity;
	int prounitprice;
	item(String name, int quant, int price) {
		proname = name;
		proquantity = quant;
		prounitprice = price;
	}
	public String toString() {
		return proname + "," + proquantity + "," + prounitprice;
	}
}