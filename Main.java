import java.io.*;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println("=== Student Object Serialization and Deserialization ===");

System.out.println("\n1. Creating a Student Object");
System.out.print("Enter Student ID: ");
int id = scanner.nextInt();
scanner.nextLine();
System.out.print("Enter Student Name: ");
String name = scanner.nextLine();
System.out.print("Enter Student Grade: ");
String grade = scanner.nextLine();

Student student = new Student(id, name, grade);
System.out.println("Created: " + student);

String filename = "student.ser";

try {
System.out.println("\n2. Serializing Student Object to File: " + filename);

FileOutputStream fileOut = new FileOutputStream(filename);
ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

objectOut.writeObject(student);
objectOut.close();
fileOut.close();

System.out.println("Serialization completed successfully!");

} catch (IOException e) {
System.out.println("Error during serialization: " + e.getMessage());
return;
}

try {
System.out.println("\n3. Deserializing Student Object from File: " + filename);

FileInputStream fileIn = new FileInputStream(filename);
ObjectInputStream objectIn = new ObjectInputStream(fileIn);

Student deserializedStudent = (Student) objectIn.readObject();
objectIn.close();
fileIn.close();

System.out.println("Deserialization completed successfully!");

System.out.println("\n4. Deserialized Student Data:");
System.out.println("Student ID: " + deserializedStudent.getStudentID());
System.out.println("Name: " + deserializedStudent.getName());
System.out.println("Grade: " + deserializedStudent.getGrade());
System.out.println("Full Object: " + deserializedStudent);

System.out.println("\n5. Verification:");
System.out.println("Original object equals deserialized object: " + 
student.toString().equals(deserializedStudent.toString()));

} catch (IOException | ClassNotFoundException e) {
System.out.println("Error during deserialization: " + e.getMessage());
}

scanner.close();
}
}
