import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedInputStream;
class Set {
	/**
	 * { It is of int type }.
	 */
	int[] setarr;
	/**
	 * { It is of int type }.
	 */
	int size;
	/**
	 * Constructs the object.
	 */
	Set() {
		final int ten = 10;
		setarr = new int[ten];
		size = 0;
	}
	/**
	 * { To resize }.
	 */
	private void resize() {
		setarr = Arrays.copyOf(setarr, 2 * setarr.length);
	}
	/**
	 * { To return size value }.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int size() {
		return size;
	}
	/**
	 * { To check for element }.
	 *
	 * @param      item  The item
	 *
	 * @return     { boolean type }
	 */
	public boolean contains(final int item) {
		for (int i = 0; i < size; i++) {
			if (setarr[i] == item) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		if (size == 0) {
			return "{}";
		} else {
			String str = "";
			str = str + "{";
			int i = 0;
			for (i = 0; i < size - 1; i++) {
				str = str + setarr[i] + ", ";
			}
			str = str + setarr[i] + "}";
			return str;
		}
	}
	/**
	 * { To add an item }.
	 *
	 * @param      item  The item
	 */
	public void add(final int item) {
		if (size == setarr.length) {
			resize();
		}
		if (!(contains(item))) {
			setarr[size] = item;
			size++;
		}
	}
	/**
	 * { To add multiple items }.
	 *
	 * @param      items  The items
	 */
	public void addAll(final int[] items) {
		for (int i = 0; i < items.length; i++) {
			add(items[i]);
		}
	}
	/**
	 * { To return intersection }.
	 *
	 * @param      items  The items
	 *
	 * @return     { set type }
	 */
	public Set intersection(final Set items) {
		Set newsetarr = new Set();
		for (int i = 0; i < size; i++) {
			if (items.contains(setarr[i])) {
				newsetarr.add(setarr[i]);
			}
		}
		return newsetarr;
	}
	/**
	 * { To retain all the elements }.
	 *
	 * @param      items  The items
	 *
	 * @return     { set type }
	 */
	public Set retainAll(final int[] items) {
		Set newsetarr = new Set();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < items.length; j++) {
				if (setarr[i] == items[j]) {
					newsetarr.add(setarr[i]);
					break;
				}
			}
		}
		return newsetarr;
	}
	/**
	 * { To find cartesian product }.
	 *
	 * @param      other  The other
	 *
	 * @return     { 2D array }
	 */
	public int[][] cartesianProduct(final Set other) {
		if (size == 0 || other.size == 0) {
			return null;
		}
		int[][] cartarr = new int[size * other.size][2];
		for (int i = 0, k = 0; i < size; i++) {
			for (int j = 0; j < other.size; j++, k++) {
				cartarr[k][0] = setarr[i];
				cartarr[k][1] = other.setarr[j];
			}
		}
		return cartarr;
	}
	public int indexOf(final int item) {
		// Replace the code below
		for (int i = 0; i < size; i++) {
			if (setarr[i] == item) {
				return i;
			}
		}
		return -1;
	}
}

class sortedsetADT extends Set {
	sortedsetADT() {
		super();
	}
	public String toString() {
		Arrays.sort(setarr, 0, size);
		return super.toString();
	}
	Set subSet(int startelement, int endelement) {
		if (startelement > endelement) {
			System.out.println("Invalid Arguments to Subset Exception");
		}
		Arrays.sort(setarr, 0, size);
		Set subsetarr = new Set();
		for (int i = indexOf(startelement); i < indexOf(endelement); i++) {
			subsetarr.add(setarr[i]);
		}
		return subsetarr;
	}
	Set headSet(int testelement) {
		Arrays.sort(setarr, 0, size);
		Set headsetarr = new Set();
		for (int i = 0; i < indexOf(testelement); i++) {
			headsetarr.add(setarr[i]);
		}
		return headsetarr;
	}
	int last() {
		if (size <= 0) {
			System.out.println("Set Empty Exception");
			return -1;
		}
		Arrays.sort(setarr, 0, size);
		return setarr[size - 1];
	}
}

class Solution {
	public static int[] intArray(final String s) {
		String input = s;
		if (input.equals("[]")) {
			return new int[0];
		}
		if (s.contains("[")) {
			input = s.substring(1, s.length() - 1);
		}
		return Arrays.stream(input.split(","))
		       .mapToInt(Integer::parseInt)
		       .toArray();
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		sortedsetADT inputset = new sortedsetADT();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "size":
				System.out.println(inputset.size());
				break;
			case "contains":
				System.out.println(inputset.contains(Integer.parseInt(tokens[1])));
				break;
			case "print":
				System.out.println(inputset);
				break;
			case "add":
				int[] intarray = intArray(tokens[1]);
				if (intarray.length == 1) {
					inputset.add(intarray[0]);
				} else {
					inputset.addAll(intarray);
				}
				break;
			case "subSet":
				String[] argtokens = tokens[1].split(",");
				System.out.println(inputset.subSet(Integer.parseInt(argtokens[0]), Integer.parseInt(argtokens[1])));
				break;
			case "headSet":
				System.out.println(inputset.headSet(Integer.parseInt(tokens[1])));
				break;
			case "last":
				System.out.println(inputset.last());
				break;
			}
		}
	}


}