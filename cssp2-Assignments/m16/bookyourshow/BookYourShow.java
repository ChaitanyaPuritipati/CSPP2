class BookYourShow {
	int k;
	Show showobj = new Show();
	String[][] bookdetails = new String[10000][5];
	void add(String moviename, String moviedate, String movieseats) {
		showobj.addall(moviename, moviedate, movieseats);
	}
	String get(String moviename, String moviedate) {
		for (int i = 0; i < showobj.size; i++) {
			if (showobj.movname[i].equals(moviename) && showobj.movdate[i].equals(moviedate)) {
				String str = moviename + "," + moviedate;
				return str;
			}
		}
		return "No show";
	}
	int indexOf(String moviename, String moviedate) {
		for (int i = 0; i < showobj.size; i++) {
			if (get(moviename, moviedate).equals(moviename + "," + moviedate)) {
				System.out.println(i);
				return i;
			}
		}
		return -1;
	}
	void book(String moviename, String moviedate, String username, String usermobile, String movieseats) {
		Patron user = new Patron(username, usermobile);
		movieseats = movieseats.replace("[", "");
		movieseats = movieseats.replace("]", "");
		String[] testseats = movieseats.split(",");
		if(get(moviename, moviedate).equals("No show")) {
			System.out.println("No show");
			return;
		}
		if (get(moviename, moviedate).equals(moviename + "," + moviedate)) {
			String mainseats;
			String[] mainseatsarr;
			mainseats  = showobj.showseats[indexOf(moviename, moviedate)].replace("[", "");
			mainseats  = showobj.showseats[indexOf(moviename, moviedate)].replace("]", "");
			mainseatsarr = showobj.showseats[indexOf(moviename, moviedate)].split(",");
			int count = 0;
			for (int i = 0; i < testseats.length; i++) {
				for (int j = 0; j < mainseatsarr.length; j++) {
					if (testseats[i].equals(mainseatsarr[j])) {
						System.out.println(testseats[i] + "hello");
						System.out.println(showobj.showseats[indexOf(moviename, moviedate)]);
						showobj.showseats[indexOf(moviename, moviedate)] = showobj.showseats[indexOf(moviename, moviedate)].replaceFirst(testseats[i], "N/A");
					}
				}
			}
			bookdetails[k][0] = moviename;
			bookdetails[k][1] = moviedate;
			bookdetails[k][2] = user.patname;
			bookdetails[k][3] = user.patmob;
			bookdetails[k][4] = movieseats;
			k++;
			return;
		} else {
			return;
		}
	}
	String print(String moviename, String moviedate, String mobile) {
		for (int i = 0; i <= k - 1; i++) {
			if (bookdetails[i][0].equals(moviename) && bookdetails[i][1].equals(moviedate) && bookdetails[i][3].equals(mobile)) {
				return mobile + " " + moviename + " " + moviedate;
			}
		}
		return "Invalid";
	}
	void showAll() {
		for (int i = 0; i < showobj.size; i++) {
			System.out.println(showobj.movname[i] +","+ showobj.movdate[i] +"," + showobj.showseats[i] );
		}
	}
}

