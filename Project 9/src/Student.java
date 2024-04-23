/* File: Student.java
 * Author: Destin, Ahren, Ben
 * Date: December 7, 2017
 * Description: A class that represents a student
 *   at a school
 */

public class Student
{
  // Static variable
  private static int nextId = 1; // One copy of nextId shared by all
                                 // student objects.

  // Data fields (also called instance variables)
  private String name;
  private int id;
  private double gradePoints;
  private double totalUnits;
  private double totalUsdUnits;
  private String highestGrade;


  // Constructor
  /**
   * @param n The name to be given to the student
   * calls the new constructor below to initialize
   * instance variables
   */
  public Student(String name) {
    this(name, 0);

  }
  /*
  //new constructor
  @param n the name to be given to student
  @param unitsTransferred the units to be transferred
  */
  public Student(String name, double unitsTransferred){
    name=name;
    totalUnits+= unitsTransferred;
    this.name = name;
    this.id = nextId++;
    this.totalUsdUnits = 0;
    this.gradePoints = 0;
    this.highestGrade = "none";
  }

 /*instance method that adds a transferred class
 to the student record
 @param units is amount of units to be added
 *
 */
  public void addTransferredCourse(double units){
    totalUnits+=units;
  }

  // Methods
  /**
   * @return The name of the student
   */
  public String getName() {
    return this.name; // "this" is a reference to the object that called the
                      // method.
  }

  /**
   * @return The id of the student
   */
  public int getId() {
    return this.id;
  }

  /**
   * @return The gpa of the student
   * for course taken only at USD
   */
  public double getGpa() {
    if (this.totalUsdUnits == 0) {
      return 0;
    }
    else {
      return this.gradePoints / this.totalUsdUnits;
    }
  }

  /**
   * Adds a course to the record of the calling student.
   * @param classUnits The units in the class to be added
   * only to the total units taken at Usd
   * @param grade The grade of the student
   * only counts if a "D-" or above
   * also updates highest grade
   */
  public void addCourse(double classUnits, String grade) {
    double compareGrade;
    double compareHighestGrade;
    this.totalUsdUnits += classUnits;

    if (grade.equals("A")) {
      this.gradePoints += 4 * classUnits;
      compareGrade = 4;
    }
    else if (grade.equals("A-")) {
      this.gradePoints += 3.67 * classUnits;
      compareGrade = 3.67;
    }
    else if (grade.equals("B+")) {
      this.gradePoints += 3.33 * classUnits;
      compareGrade = 3.33;
    }
    else if (grade.equals("B")) {
      this.gradePoints += 3 * classUnits;
      compareGrade = 3;
    }
    else if (grade.equals("B-")) {
      this.gradePoints += 2.67 * classUnits;
      compareGrade = 2.67;
    }
    else if (grade.equals("C+")) {
      this.gradePoints += 2.33 * classUnits;
      compareGrade = 2.33;
    }
    else if (grade.equals("C")) {
      this.gradePoints += 2 * classUnits;
      compareGrade = 2;
    }
    else if (grade.equals("C-")) {
      this.gradePoints += 1.67 * classUnits;
      compareGrade = 1.67;
    }
    else if (grade.equals("D+")) {
      this.gradePoints += 1.33 * classUnits;
      compareGrade = 1.33;
    }
    else if (grade.equals("D")) {
      this.gradePoints += 1 * classUnits;
      compareGrade = 1;
    }
    else if (grade.equals("D-")) {
      this.gradePoints += 0.67 * classUnits;
      compareGrade = 0.67;
    }
    else {
      this.gradePoints += 0 * classUnits;
      compareGrade = 0;
    }

    // Set a value to compare highestGrade to grade of added course
    if (highestGrade.equals("A")) {
      compareHighestGrade = 4;
    }
    else if (highestGrade.equals("A-")) {
      compareHighestGrade = 3.67;
    }
    else if (highestGrade.equals("B+")) {
      compareHighestGrade = 3.33;
    }
    else if (highestGrade.equals("B")) {
      compareHighestGrade = 3;
    }
    else if (highestGrade.equals("B-")) {
      compareHighestGrade = 2.67;
    }
    else if (highestGrade.equals("C+")) {
      compareHighestGrade = 2.33;
    }
    else if (highestGrade.equals("C")) {
      compareHighestGrade = 2;
    }
    else if (highestGrade.equals("C-")) {
      compareHighestGrade = 1.67;
    }
    else if (highestGrade.equals("D+")) {
      compareHighestGrade = 1.33;
    }
    else if (highestGrade.equals("D")) {
      compareHighestGrade = 1;
    }
    else if (highestGrade.equals("D-")) {
      compareHighestGrade = 0.67;
    }
    else if (highestGrade.equals("F")){
      compareHighestGrade = 0;
    }
    else {
      compareHighestGrade = 0;
    }
    
    // Compare and update highestGrade
    if (compareGrade > compareHighestGrade) {
      highestGrade = grade;
    }
  }

  /*
   * returns the number of units earned at USD
   * with a grade of a "D-" or better
   * and transferred in
    */
  public double getUnitsEarned(){
    return totalUnits;
  }

  /*
   * returns the number of units earned at USD
   * with a grade of a "D-" only
   */
  public double getUnitsForGrade(){
    return totalUsdUnits;
  }

  /*returns the number of grade
    points the student has earned
    (only USD courses).
  */
  public double getGradePoints(){
    return gradePoints;
  }

  /*
    returns the highest grade
    received by the student.
    */
  public String getHighestGrade(){
    if(highestGrade.equals("None")){
      return "None"; }
    else
      return highestGrade;
  }

  //returns a string
  public String toString(){
    return "Name: "+name+" id: "+id+" Earned units: "+totalUnits
      +" Grade units: "+totalUsdUnits +" GPA: "+getGpa()+
      " High grade: "+getHighestGrade();
  }
}