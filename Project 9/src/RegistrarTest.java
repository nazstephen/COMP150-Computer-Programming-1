/* File: RegistrarTest.java
 * Author: Destin, Ahren, Ben
 * Date: December 7, 2017
 * Description: A class that tests the Registrar and
 *              student classes.
 */

public class RegistrarTest {
  public static void main(String [] args) {

    // Create a registrar object
    Registrar reg = new Registrar();
    
    // Add three students to the registrar
    reg.addStudent("Destin");
    reg.addStudent("Ahren");
    reg.addStudent("Ben");
    
    // Add some courses to the students
    reg.addCourse("Destin", 4, "A");
    reg.addCourse("Destin", 3, "B-");
    reg.addCourse("Ahren", 4, "A-");
    reg.addCourse("Ahren", 3, "C+");
    reg.addCourse("Ben", 3, "A");
    reg.addCourse("Ben", 3, "B+");
    
    // Add some transffered course to the students
    reg.addTransferredCourse("Ahren", 3);
    reg.addTransferredCourse("Ahren", 4);
    reg.addTransferredCourse("Ben", 3);
    reg.addTransferredCourse("Destin", 4);
    
    // Display information of students created with Registrar class
    System.out.println("Name: " + reg.getName(reg.getId("Destin")) + " id: " + reg.getId("Destin") +
                       " Earned units: " + reg.getUnits("Destin") + " GPA: " + reg.getGpa("Destin") +
                       " High grade: " + reg.getHighestGrade("Destin"));
    
    System.out.println("Name: " + reg.getName(reg.getId("Ahren")) + " id: " + reg.getId("Ahren") +
                       " Earned units: " + reg.getUnits("Ahren") + " GPA: " + reg.getGpa("Ahren") +
                       " High grade: " + reg.getHighestGrade("Ahren"));
    
    System.out.println("Name: " + reg.getName(reg.getId("Ben")) + " id: " + reg.getId("Ben") +
                       " Earned units: " + reg.getUnits("Ben") + " GPA: " + reg.getGpa("Ben") +
                       " High grade: " + reg.getHighestGrade("Ben"));
    
    
    // Create a student object
    Student stu = new Student("Santino", 8);
    
    // Add some courses to the student
    stu.addCourse(4, "A-");
    stu.addCourse(3, "B+");
    
    // Display information of the student created with Student class
    System.out.println(stu.toString());
  }
}