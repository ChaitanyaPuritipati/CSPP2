import java.util.*;
import java.util.Scanner;
class food {
	private String itemname;
	private double itemquantity;
	private String itemtime;
	private String itemdate;
	food(String testname, double quantity, String time, String date) {
		this.itemname = testname;
		this.itemquantity = quantity;
		this.itemtime = time;
		this.itemdate = date;
	}
	public String getitemname() {
		return this.itemname;
	}
	public double getitemquantity() {
		return this.itemquantity;
	}
	public String getitemtime() {
		return this.itemtime;
	}
	public String getitemdate() {
		return this.itemdate;
	}
	public String toString() {
		return "Time:  " + getitemtime() + "    -    " + "Name:  " + getitemname() + "    -    " + "Quantity:  " + getitemquantity() + "KG";
	}
}
class water {
	private int wateramount;
	private String watertime;
	private String waterdate;
	water(int amount, String time, String date) {
		this.wateramount = amount;
		this.watertime = time;
		this.waterdate = date;
	}
	public int getwateramount() {
		return this.wateramount;
	}
	public String getwatertime() {
		return this.watertime;
	}
	public String getwaterdate() {
		return this.waterdate;
	}
	public String toString() {
		return "Time:  " + getwatertime() + "   -   " + "Amount:  " + getwateramount() + "(in ml)";
	}
}
class physicalactivity {
	private String activityname;
	private String activitydate;
	private String activitystarttime;
	private String activityendtime;
	physicalactivity(String name, String date, String starttime, String endtime) {
		this.activityname = name;
		this.activitydate = date;
		this.activitystarttime = starttime;
		this.activityendtime = endtime;
	}
	public String getactivityname() {
		return this.activityname;
	}
	public String getactivitydate() {
		return this.activitydate;
	}
	public String getactivitystarttime() {
		return this.activitystarttime;
	}
	public String getactivityendtime() {
		return this.activityendtime;
	}
	public String toString() {
		return "Activity:  " + getactivityname() + "   -   " + "Start time:  " + getactivitystarttime() + "   -   " + "End Time:  " + getactivityendtime();
	}
}
class weight {
	private int weight;
	private double fatpercent;
	private String weightdate;
	weight(int wt, double fat, String date) {
		this.weight = wt;
		this.fatpercent = fat;
		this.weightdate = date;
	}
	public int getweight() {
		return this.weight;
	}
	public double getfatpercent() {
		return this.fatpercent;
	}
	public String getweightdate() {
		return this.weightdate;
	}
	public String toString() {
		return "Weight:  " + getweight() + "    -    " + "Fatpercent:  " + getfatpercent();
	}
}
class sleep {
	private String sleepdate;
	private String sleepstarttime;
	private String sleependtime;
	sleep(String date, String starttime, String endtime) {
		this.sleepdate = date;
		this.sleepstarttime = starttime;
		this.sleependtime = endtime;
	}
	public String getsleepdate() {
		return this.sleepdate;
	}
	public String getsleepstarttime() {
		return this.sleepstarttime;
	}
	public String getsleependtime() {
		return this.sleependtime;
	}
	public String toString() {
		return "Start Time:  " + getsleepstarttime() + "    -    " + "End Time:  " + getsleependtime();
	}
}
class logger {
	private ArrayList<food> foodlog;
	private ArrayList<water> waterlog;
	private ArrayList<physicalactivity> physicalactivitylog;
	private ArrayList<weight> weightlog;
	private ArrayList<sleep> sleeplog;
	logger() {
		foodlog = new ArrayList<food>();
		waterlog = new ArrayList<water>();
		physicalactivitylog = new ArrayList<physicalactivity>();
		weightlog = new ArrayList<weight>();
		sleeplog = new ArrayList<sleep>();
	}
	public ArrayList<food> getfoodlog() {
		return foodlog;
	}
	public ArrayList<water> getwaterlog() {
		return waterlog;
	}
	public ArrayList<physicalactivity> getphysicalactivitylog() {
		return physicalactivitylog;
	}
	public ArrayList<weight> getweightlog() {
		return weightlog;
	}
	public ArrayList<sleep> getsleeplog() {
		return sleeplog;
	}
	public void addtofoodlog(food argfood) {
		foodlog.add(argfood);
	}
	public void addtowaterlog(water argwater) {
		waterlog.add(argwater);
	}
	public void addtophysicalactivitylog(physicalactivity argactivity) {
		physicalactivitylog.add(argactivity);
	}
	public void addtoweightlog(weight argweight) {
		weightlog.add(argweight);
	}
	public void addtosleeplog(sleep argsleep) {
		sleeplog.add(argsleep);
	}
	public String reportlog(String date) {
		String report = "";
		String foodreport = "";
		String waterreport = "";
		String physicalactivityreport = "";
		String weightreport = "";
		String sleepreport = "";
		for (int i = 0; i < getfoodlog().size(); i++) {
			if (getfoodlog().get(i).getitemdate().equals(date)) {
				foodreport = foodreport + getfoodlog().get(i).toString() + "\n";
			}
		}
		foodreport = foodreport + "-----------------------------------------------------------------------------";
		if (!(foodreport.equals("-----------------------------------------------------------------------------"))) {
			report = report + "Food Log:" + "\n" + foodreport + "\n";
		}
		for (int j = 0; j < getwaterlog().size(); j++) {
			if (getwaterlog().get(j).getwaterdate().equals(date)) {
				waterreport = waterreport + getwaterlog().get(j).toString() + "\n";
			}
		}
		waterreport = waterreport + "-----------------------------------------------------------------------------";
		if (!(waterreport.equals("-----------------------------------------------------------------------------"))) {
			report = report + "Water Log:" + "\n" + waterreport + "\n";
		}
		for (int l = 0; l < getphysicalactivitylog().size(); l++) {
			if (getphysicalactivitylog().get(l).getactivitydate().equals(date)) {
				physicalactivityreport = physicalactivityreport + getphysicalactivitylog().get(l).toString() + "\n";
			}
		}
		physicalactivityreport = physicalactivityreport + "-----------------------------------------------------------------------------";
		if (!(physicalactivityreport.equals("-----------------------------------------------------------------------------"))) {
			report = report + "Physcicalactivity Log:" + "\n" + physicalactivityreport + "\n";
		}
		for (int k = 0; k < getweightlog().size(); k++) {
			if (getweightlog().get(k).getweightdate().equals(date)) {
				weightreport = weightreport + getweightlog().get(k).toString() + "\n";
			}
		}
		weightreport = weightreport + "-----------------------------------------------------------------------------";
		if (!(weightreport.equals("-----------------------------------------------------------------------------"))) {
			report = report + "Weight Log:" + "\n" + weightreport + "\n";
		}
		for (int m = 0; m < getsleeplog().size(); m++) {
			if (getsleeplog().get(m).getsleepdate().equals(date)) {
				sleepreport = sleepreport + getsleeplog().get(m).toString() + "\n";
			}
		}
		sleepreport = sleepreport + "-----------------------------------------------------------------------------";
		if (!(sleepreport.equals("-----------------------------------------------------------------------------"))) {
			report = report + "Sleep Log:" + "\n" + sleepreport + "\n";
		}
		return report;
	}
}
class Solution {
	Solution() {
		//unused;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		logger logadder = new logger();
		ArrayList<String> dates = new ArrayList<String>();
		int testcases = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < testcases; i++) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "addfood":
				if (!(dates.contains(tokens[4]))) {
					dates.add(tokens[4]);
				}
				food newfooditem = new food(tokens[1], Double.parseDouble(tokens[2]), tokens[3], tokens[4]);
				logadder.addtofoodlog(newfooditem);
				break;
			case "addwater":
				if (!(dates.contains(tokens[3]))) {
					dates.add(tokens[3]);
				}
				water newwateramount = new water(Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
				logadder.addtowaterlog(newwateramount);
				break;
			case "addphysicalactivity":
				if (!(dates.contains(tokens[2]))) {
					dates.add(tokens[2]);
				}
				physicalactivity newphysicalactivity = new physicalactivity(tokens[1], tokens[2], tokens[3], tokens[4]);
				logadder.addtophysicalactivitylog(newphysicalactivity);
				break;
			case "addweight":
				if (!(dates.contains(tokens[3]))) {
					dates.add(tokens[3]);
				}
				weight newweight = new weight(Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]), tokens[3]);
				logadder.addtoweightlog(newweight);
				break;
			case "addsleep":
				if (!(dates.contains(tokens[1]))) {
					dates.add(tokens[1]);
				}
				sleep newsleep = new sleep(tokens[1], tokens[2], tokens[3]);
				logadder.addtosleeplog(newsleep);
				break;
			case "print":
				if (dates.size() == 1) {
					System.out.println("DataLog for the date: " + dates.get(0) + "   is");
					System.out.println("-----------------------------------------------------------------------------");
					System.out.println(logadder.reportlog(dates.get(0)));
					break;
				} else {
					System.out.println("DataLog for the date: " + tokens[1] + "   is");
					System.out.println("-----------------------------------------------------------------------------");
					if (logadder.reportlog(tokens[1]).equals("")) {
						System.out.println("No Data Log found for this day");
						System.out.println("-----------------------------------------------------------------------------");
						break;
					}
					System.out.print(logadder.reportlog(tokens[1]));
				}
				break;
			case "foodlog":
				if (dates.size() == 1) {
					System.out.println("FoodLog for the date: " + dates.get(0) + "   is");
					System.out.println("-----------------------------------------------------------------------------");
					if (logadder.getfoodlog().size() == 0) {
						System.out.println("No Food Log");
                        break;
					}
					for (int n = 0; n < logadder.getfoodlog().size(); i++) {
						System.out.println(logadder.getfoodlog().get(n));
					}
					break;
				} else {
					int count = 0;
					System.out.println("FoodLog for the date: " + tokens[1] + "   is");
					System.out.println("-----------------------------------------------------------------------------");
					for (int n = 0; n < logadder.getfoodlog().size(); n++) {
						if (logadder.getfoodlog().get(n).getitemdate().equals(tokens[1])) {
							System.out.println(logadder.getfoodlog().get(n));
							count++;
						}
					}
					if(count == 0) {
						System.out.println("No food log");
					}
				}
				break;
			case "waterlog":
				if (dates.size() == 1) {
					System.out.println("WaterLog for the date: " + dates.get(0) + "   is");
					System.out.println("-----------------------------------------------------------------------------");
					if(logadder.getwaterlog().size() == 0) {
						System.out.println("No water log");
						break;
					}
					for (int j = 0; j < logadder.getwaterlog().size(); j++) {
						System.out.println(logadder.getwaterlog().get(j));
					}
					break;
				} else {
					int countwater = 0;
					System.out.println("WaterLog for the date: " + tokens[1] + "   is");
					System.out.println("-----------------------------------------------------------------------------");
					for (int j = 0; j < logadder.getwaterlog().size(); j++) {
						if (logadder.getwaterlog().get(j).getwaterdate().equals(tokens[1])) {
							System.out.println(logadder.getwaterlog().get(j));
							countwater++;
						}
					}
					if(countwater == 0) {
						System.out.println("No water log");
						break;
					}
				}
				break;
			case "physicalactivitylog":
				if (dates.size() == 1) {
					System.out.println("PhysicalActivityLog for the date: " + dates.get(0) + "   is");
					System.out.println("-----------------------------------------------------------------------------");
					if(logadder.getphysicalactivitylog().size() == 0) {
						System.out.println("No Activity Log");
						break;
					}
					for (int k = 0; i < logadder.getphysicalactivitylog().size(); k++) {
						System.out.println(logadder.getphysicalactivitylog().get(k));
					}
					break;
				} else {
					int countact = 0;
					System.out.println("PhysicalActivityLog for the date: " + tokens[1] + "   is");
					System.out.println("-----------------------------------------------------------------------------");
					for (int k = 0; k < logadder.getphysicalactivitylog().size(); k++) {
						if (logadder.getphysicalactivitylog().get(k).getactivitydate().equals(tokens[1])) {
							System.out.println(logadder.getphysicalactivitylog().get(k));
							countact++;
						}
					}
					if(countact == 0) {
						System.out.println("No Physical Activity");
						break;
					}
				}
				break;
			case "weightlog":
				if (dates.size() == 1) {
					System.out.println("WeightLog for the date: " + dates.get(0) + "   is");
					System.out.println("-----------------------------------------------------------------------------");
					if(logadder.getweightlog().size() == 0) {
						System.out.println("No weight log");
						break;
					}
					for (int l = 0; l < logadder.getweightlog().size(); l++) {
						System.out.println(logadder.getweightlog().get(l));
					}
					break;
				} else {
					int countwt = 0;
					System.out.println("WeightLog for the date: " + tokens[1] + "   is");
					System.out.println("-----------------------------------------------------------------------------");
					for (int l = 0; l < logadder.getweightlog().size(); l++) {
						if (logadder.getweightlog().get(l).getweightdate().equals(tokens[1])) {
							System.out.println(logadder.getweightlog().get(l));
							countwt++;
						}
					}
					if(countwt == 0) {
						System.out.println("No weight log");
						break;
					}
				}
				break;
			case "sleeplog":
				if (dates.size() == 1) {
					System.out.println("SleepLog for the date: " + dates.get(0) + "   is");
					System.out.println("-----------------------------------------------------------------------------");
					if(logadder.getsleeplog().size() == 0) {
						System.out.println("No sleep log");
						break;
					}
					for (int m = 0; m < logadder.getsleeplog().size(); m++) {
						System.out.println(logadder.getsleeplog().get(m));
					}
					break;
				} else {
					int countsleep = 0;
					System.out.println("SleepLog for the date: " + tokens[1] + "   is");
					System.out.println("-----------------------------------------------------------------------------");
					for (int m = 0; m < logadder.getsleeplog().size(); m++) {
						if (logadder.getsleeplog().get(m).getsleepdate().equals(tokens[1])) {
							System.out.println(logadder.getsleeplog().get(m));
							countsleep++;
						}
					}
					if(countsleep == 0) {
						System.out.println("No sleep log");
						break;
					}
				}
				break;
			default:
			}
		}
	}
}