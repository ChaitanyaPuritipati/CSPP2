class BookYourShow {
	int k = 0;
	Show showobj = new Show();
	String[][] bookdetails = new String[10000][5];
	void add(String moviename, String moviedate, String movieseats) {
		showobj.add(moviename, moviedate, movieseats);
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
			if (get(moviename, moviedate).equals(moviename+","+moviedate)) {
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
		System.out.println(testseats.length + "counter");
		if (get(moviename, moviedate).equals(moviename+","+moviedate)) {
			System.out.println("entered booking loop");
			String[] mainseats;
			showobj.showseats[indexOf(moviename, moviedate)]  = showobj.showseats[indexOf(moviename, moviedate)].replace("[", "");
			showobj.showseats[indexOf(moviename, moviedate)]  = showobj.showseats[indexOf(moviename, moviedate)].replace("]", "");
			mainseats = showobj.showseats[indexOf(moviename, moviedate)].split(",");
			int count = 0;
			for (int i = 0; i < testseats.length; i++) {
				for (int j = 0; j < mainseats.length; j++) {
					System.out.println(testseats[i] + "test");
					System.out.println(mainseats[j] + "main");
					if (testseats[i].equals(mainseats[j])) {
						count++;
					}
				}
			}
			System.out.println(count + "HIIIIII");
			if (count != testseats.length) {
				return;
			} else {
				bookdetails[k][0] = moviename;
				bookdetails[k][1] = moviedate;
				bookdetails[k][2] = user.patname;
				bookdetails[k][3] = user.patmob;
				bookdetails[k][4] = movieseats;
				k++;
				return;
			}
		} else {
			return;
		}
	}
	String print(String moviename, String moviedate, String mobile) {
		for (int i = 0; i < bookdetails.length; i++) {
			// System.out.println(bookdetails[i][0] + "hello");
			// System.out.println(bookdetails[i][1] + "How");
			// System.out.println(bookdetails[i][3] + "I know");
			if (bookdetails[i][0].equals(moviename) && bookdetails[i][1].equals(moviedate) && bookdetails[i][3].equals(mobile)) {
				return moviename + moviedate + mobile;
			}
		}
		return "Invalid";
	}
	void showAll() {
		for (int i = 0; i < showobj.size; i++) {
			System.out.println(showobj.movname[i] + showobj.movdate[i] + showobj.showseats[i]);
		}
	}
}

