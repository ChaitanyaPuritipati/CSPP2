import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedInputStream;
/**
 * Class for set.
 */
class Set {
    /**
     * { It is of int type }.
     */
    private int[] setarr;
    /**
     * { It is of int type }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Set() {
        final int ten = 10;
        setarr = new int[ten];
        size = 0;
    }
    /**
     * { get method }.
     *
     * @return     { description_of_the_return_value }
     */
    public int[] get() {
        return setarr;
    }
    /**
     * { To resize }.
     */
    public void resize() {
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
    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
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
/**
 * Class for sortedset adt.
 */
class Sortedsetadt extends Set {
    /**
     * Constructs the object.
     */
    Sortedsetadt() {
        super();
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        Arrays.sort(super.get(), 0, size());
        return super.toString();
    }
    /**
     * { subSet function }.
     *
     * @param      startelement  The startelement
     * @param      endelement    The endelement
     *
     * @return     { int array }
     */
    int[] subSet(final int startelement, final int endelement) throws Exception {
        if (startelement > endelement) {
            throw new Exception("Invalid Arguments to Subset Exception");
        }
        Arrays.sort(super.get(), 0, size());
        int count = 0;
        for (int i = 0; i < size(); i++) {
            if (super.get()[i] >= startelement && super.get()[i] < endelement) {
                count++;
            }
        }
        int[] subsetarr = new int[count];
        int j = 0;
        for (int i = 0; i < size(); i++) {
            if (super.get()[i] >= startelement && super.get()[i] < endelement) {
                subsetarr[j] = super.get()[i];
                j++;
            }
        }
        return subsetarr;
    }
    /**
     * { headSet function }.
     *
     * @param      testelement  The testelement
     *
     * @return     { Integer array }
     */
    int[] headSet(final int testelement) throws Exception {
        Arrays.sort(super.get(), 0, size());
        int count = 0;
        for (int i = 0; i < size(); i++) {
            if (super.get()[i] < testelement) {
                count++;
            }
        }
        if(count == 0) {
            throw new Exception("Set Empty Exception");
        }
        int[] headsetarr = new int[count];
        int j = 0;
        for (int i = 0; i < size(); i++) {
            if (super.get()[i] < testelement) {
                headsetarr[j] = super.get()[i];
                j++;
            }
        }
        return headsetarr;
    }
    /**
     * { To retrive last element }.
     *
     * @return     { Integer type }
     */
    int last() throws Exception {
        if (size() <= 0) {
            throw new Exception("Set Empty Exception");
            // System.out.println("Set Empty Exception");
        }
        Arrays.sort(super.get(), 0, size());
        return super.get()[size() - 1];
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }
     *
     * @return     { integer array }
     */
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
    /**
     * Returns a string representation of the object.
     *
     * @param      items  The items
     *
     * @return     String representation of the object.
     */
    public static String toString(final int[] items) {
        if (items.length == 0) {
            return "{}";
        } else {
            String str = "";
            str = str + "{";
            int i;
            for (i = 0; i < items.length - 1; i++) {
                str = str + items[i] + ", ";
            }
            str = str + items[i] + "}";
            return str;
        }
    }
    /**
     * { Main function starts here }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(new BufferedInputStream(System.in));
        Sortedsetadt inputset = new Sortedsetadt();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "size":
                System.out.println(inputset.size());
                break;
            case "contains":
                System.out.println(inputset.contains(
                                       Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(inputset);
                break;
            case "addAll":
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
                try {
                    System.out.println(
                        toString(
                            inputset.subSet(
                                Integer.parseInt(argtokens[0]),
                                Integer.parseInt(argtokens[1]))));
                } catch (Exception e) {
                    System.out.println("Invalid Arguments to Subset Exception");

                }
                break;
            case "headSet":
                try {
                    System.out.println(toString(
                                           inputset.headSet(
                                               Integer.parseInt(tokens[1]))));
                } catch(Exception e) {
                    System.out.println("Set Empty Exception");
                }

                break;
            case "last":
                try {
                    System.out.println(inputset.last());
                } catch (Exception e) {
                    System.out.println("Set Empty Exception");
                }
                break;
            default:
            }
        }
    }
}
