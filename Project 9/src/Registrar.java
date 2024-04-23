/* File: Registrar.java
 * Author: Destin, Ahren, Ben
 * Date: December 7, 2017
 * Description: A class that represents a registrar
 *   at a school
 */
public class Registrar
{
  // Data fields
  private Student [] students;
  private int numStudents;

  // Constructor
  public Registrar() {
    students = new Student[10];
    numStudents = 0;
  }

  // Methods

  /**
   * Adds a student to the registrar
   * @param name The name of the student to add
   * also creates a bigger array to store sudents
   * if the number of students stored in the students array
   * is equal to the size of the student array
   */
  public void addStudent(String name) {
     if(students.length==numStudents){
     resize(students);
     }
    students[numStudents] = new Student(name);
    numStudents++;
    }

   //instance method for a adding a student
   public void addStudent(String name, double units) {
   }


  /**
   * Returns the id of a student, given their name.
   * @param name The name of the student
   * @return The id of the student with the specified name,
   *       or -1 if the name is not present.
   */
  public int getId(String name) {
     Student student = this.getStudent(name);
     if (student != null) {
       return student.getId();
     }
     else {
       return -1;
     }
  }

  /**
   * Returns the gpa of a student, given their name.
   * @param name The name of the student
   * @return The gpa of the student with the specified name,
   *       or -1 if the name is not present.
   */
  public double getGpa(String name) {
    Student student = this.getStudent(name);
    if (student != null) {
      return student.getGpa();
    }
    else {
      return -1;
    }
  }

  /**
   * Returns the gpa of a student, given their id.
   * @param id The id of the student
   * @return The gpa of the student with the specified name,
   *       or -1 if the name is not present.
   */
  public double getGpa(int id) {
    Student student = this.getStudent(id);
    if (student != null) {
      return student.getGpa();
    }
    else {
      return -1;
    }
  }

  /**
   * Returns the name of a student, given their id.
   * @param name The id of the student
   * @return The name of the student with the specified id,
   *       or null if the name is not present.
   */
   public String getName(int id) {

     Student student = this.getStudent(id);
     if (student != null) {
       return student.getName();
     }
     else {
       return null;
     }
   }

  /**
   * Adds a course to a student record.
   * @param name The name of the student.
   * @param units The number of units in the course
   * @param grade The grade in the class.
   * @return true if the course was successfully added,
   *       false if not (because student does not exist,
   *       or grade is not valid).
   * Changes any lowercase letters in the grade parameter to uppercase
   */
   public boolean addCourse(String name, double units, String grade) {
     // Check that grade is valid
     if (!isValidGrade(grade))
       return false;

     // Check for student in the students array.
     Student student = getStudent(name);
     if (student == null)
       return false;

     // Add the course to the student.
     student.addCourse(units, grade.toUpperCase());
     return true;
   }

   /*
    * resize student array
    * @param ar is array to be resized
    * */
   private void resize(Student [] ar){
     Student [] ar1= new Student[students.length*2];
     for(int i=0; i<ar.length; i++){
       ar1[i]=ar[i];
     }
     ar=ar1;
   }

    /**
   * Adds a course to a student record.
   * @param name The name of the student.
   * @param units The number of units in the course
   * @param grade The grade in the class.
   * @return true if the course was successfully added,
   *       false if not (because student does not exist,
   *       or grade is not valid).
   */
   public boolean addCourse(int id, double units, String grade) {
     // Check that grade is valid
     if (!isValidGrade(grade))
       return false;

     // Check for student in the students array.
     Student student = getStudent(id);
     if (student == null)
       return false;

     // Add the course to the student.
     student.addCourse(units, grade);
     return true;
   }

   /*
    * adds transferred class the specified student
    * if the student is found
    * @param name the student to add units to
    * @param unitsToAdd the units to be added
    * */
   public boolean addTransferredCourse(String name, double unitsToAdd){
     Student student = getStudent(name);
     if (student == null)
       return false;
     else{
       student.addTransferredCourse(unitsToAdd);
       return true;}

   }

   /*returns units of students with speciifed name
    * @param name the student to return units of
    * */
   public double getUnits(String name){
       Student student = getStudent(name);
     if (student == null)
       return -1;

     else
     return student.getUnitsEarned();
   }

   /*returns highest grade of a student with specified name
    * but only if the student exists
    * @param name is the name of student to return highest grade of
    * */
   public String getHighestGrade(String name){
       Student student = getStudent(name);
     if (student == null)
       return null;
     else
       return student.getHighestGrade();
   }

   /*
    * computes and returns the overall gpa
    * of all classes taken by all students
    * if no studnet took courses for grade then
    * zero is returned
    * */
   public double overallGpa(){
     double sum=0;
     for(int i=0; i<numStudents; i++){
     sum+=students[i].getGpa();
     }
     return sum/numStudents;

   }

   // Private helper methods.

   /**
    * Finds a student with specified name.
    * @param name The name of the student.
    * @return Reference to the student with the specified name,
    *     or null if the student is not present.
    */
   private Student getStudent(String name) {
     // Search for student name.
     for (int i = 0; i < numStudents; i++) {
       if (students[i].getName().equals(name)) {
        return students[i];
       }
      }

     // Not found.
     return null;
   }

   /**
    * Finds a student with specified name.
    * @param name The name of the student.
    * @return Reference to the student with the specified name,
    *     or null if the student is not present.
    */
   private Student getStudent(int id) {
     // Search for student name.
     for (int i = 0; i < numStudents; i++) {
       if (students[i].getId() == id) {
        return students[i];
       }
      }

     // Not found.
     return null;
   }

   /** Validates a grade.
     * @param grade The grade.
     * @return true if the grade is valid, false if not.
     */
   private boolean isValidGrade(String grade) {
     if (grade.equals("A") || grade.equals("A-") || grade.equals("B+") ||
         grade.equals("B") || grade.equals("B-") || grade.equals("C+") ||
         grade.equals("C") || grade.equals("C-") || grade.equals("D+") ||
         grade.equals("D") || grade.equals("D-") || grade.equals("F"))
       return true;
     else
       return false;
   }
}