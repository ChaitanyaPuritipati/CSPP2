/**
 * { item_description }.
 */
final class StudentDetails {
    /**
     * { String type }.
     */
    private String studentname;
    /**
     * { String type }.
     */
    private String studentID;
    /**
     * { double type }.
     */
    private double sub1marks;
    /**
     * { double type }.
     */
    private double sub2marks;
    /**
     * { double type }.
     */
    private double sub3marks;
    /**
     * Constructs the object.
     *
     * @param      name  String type
     * @param      id    String type
     * @param      sub1  int type
     * @param      sub2  int type
     * @param      sub3  int type
     */
    private StudentDetails(final String name, final String id,
                           final double sub1, final double sub2,
                           final double sub3) {
        this.studentname = name;
        this.studentID = id;
        this.sub1marks = sub1;
        this.sub2marks = sub2;
        this.sub3marks = sub3;
    }
    /**
     * Calculates the gpa.
     *
     * @return     It is of double Type.
     */
    public double calculategpa() {
        double gpa;
        final int three = 3;
        gpa = (this.sub1marks + this.sub2marks + this.sub3marks) / three;
        return gpa;
    }
    /**
     *
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final double sevenPointfive = 7.5;
        final double sevenPointZero = 7.0;
        final double eightPointFive = 8.5;
        final double sixPointZero = 6.0;
        final double eightPointzero = 8.0;
        final double ninePointzero = 9.0;
        StudentDetails student1 = new StudentDetails("Sangay", "IT201985001",
                sevenPointfive, sevenPointZero, eightPointzero);
        StudentDetails student2 = new StudentDetails("Bidhya", "IT201985003",
                eightPointFive, sixPointZero, sevenPointfive);
        StudentDetails student3 = new StudentDetails("Kelzang", "IT201985065",
                sevenPointfive, eightPointzero, ninePointzero);
        System.out.format("%.1f \n", student1.calculategpa());
        System.out.format("%.1f \n", student2.calculategpa());
        System.out.format("%.1f \n", student3.calculategpa());
    }
}
