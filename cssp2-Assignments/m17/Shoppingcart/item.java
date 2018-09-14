class item {
	String proname;
	int proquantity;
	double prounitprice;
	item(String name, int quant, double price) {
		proname = name;
		proquantity = quant;
		prounitprice = price;
	}
	public String toString() {
		return proname + " " + proquantity + " " + prounitprice;
	}
}