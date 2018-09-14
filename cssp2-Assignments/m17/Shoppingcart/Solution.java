import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Shoppingcart shop = new Shoppingcart();
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
        	String line = input.nextLine();
        	String[] tokens = line.split(" ");
        	switch(tokens[0]) {
        		case "Item":
        		            String[] par = tokens[1].split(",");
        		            item inpitem = new item(par[0], Integer.parseInt(par[1]), Integer.parseInt(par[2]));
        		            shop.addtocatalog(inpitem);
        		            break;
        		case "add":
        		            par = tokens[1].split(",");
        		            int price = 0;
        		            for(item catitem : shop.catitems) {
        		            	if(catitem.proname.equals(par[0])) {
                                     price = catitem.prounitprice;
        		            	}
        		            }
        		            inpitem = new item(par[0], Integer.parseInt(par[1]), price);
        		            shop.addtocart(inpitem);
        		            break;             
        	}
        }
	}
}