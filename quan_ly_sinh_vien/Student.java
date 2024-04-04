package quan_ly_sinh_vien;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable, Comparable<Student> {
    public static final long serialVersionUID = 1L;
    private String studentID;
    private String fullName;
    private int birthDay;
    private double average;

    public Student(String studentID, String fullName, int birthDay, double average) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.average = average;
    }

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public double getAverageScore() {
        return this.average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String toString() {
        return "Thông tin sinh viên {Mã Sinh Viên = '" + this.studentID + "', họ tên = '" + this.fullName + "', năm sinh = " + this.birthDay + ", điểm trung bình = " + this.average + "}";
    }

    public int compareTo(Student o) {
        return this.studentID.compareTo(o.studentID);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Student student = (Student)o;
            return Objects.equals(this.studentID, student.studentID);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.studentID, this.fullName, this.birthDay, this.average});
    }
}