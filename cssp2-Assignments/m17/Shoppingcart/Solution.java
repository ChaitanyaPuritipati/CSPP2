import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Shoppingcart shop = new Shoppingcart();
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String line = input.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "Item":
				String[] par = tokens[1].split(",");
				item inpitem = new item(par[0], Integer.parseInt(par[1]), Double.parseDouble(par[2]));
				shop.addtocatalog(inpitem);
				break;
			case "add":
				par = tokens[1].split(",");
				double price = 0;
				for (item catitem : shop.catitems) {
					if (catitem.proname.equals(par[0])) {
						price = catitem.prounitprice;
						break;
					}
				}
				inpitem = new item(par[0], Integer.parseInt(par[1]), price);
				shop.addtocart(inpitem);
				break;
			case "remove":
				par = tokens[1].split(",");
				price = 0;
				for (item catitem : shop.catitems) {
					if (catitem.proname.equals(par[0])) {
						price = catitem.prounitprice;
						break;
					}
				}
				inpitem = new item(par[0], Integer.parseInt(par[1]), price);
				shop.removefromcart(inpitem);
				break;
			case "catalog":
				shop.showcatalog();
				break;
			case "show":
				shop.showcart();
				break;
			case "totalAmount":
			    System.out.println("totalAmount: " + shop.totalamount());
				break;
			default:
			}
		}
	}
}