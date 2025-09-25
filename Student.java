import java.io.Serializable;

public class Student implements Serializable {
private static final long serialVersionUID = 1L;

private int studentID;
private String name;
private String grade;

public Student(int studentID, String name, String grade) {
this.studentID = studentID;
this.name = name;
this.grade = grade;
}

public int getStudentID() {
return studentID;
}

public String getName() {
return name;
}

public String getGrade() {
return grade;
}

@Override
public String toString() {
return "Student ID: " + studentID + ", Name: " + name + ", Grade: " + grade;
}
}
