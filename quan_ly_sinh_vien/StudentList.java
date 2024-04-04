package quan_ly_sinh_vien;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class StudentList {
    private ArrayList<Student> studentArrayList;

    public StudentList() {
        this.studentArrayList = new ArrayList();
    }

    public StudentList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public void addStudent(Student student) {
        this.studentArrayList.add(student);
    }

    public void getStudentList() {
        Iterator var1 = this.studentArrayList.iterator();

        while(var1.hasNext()) {
            Student student = (Student)var1.next();
            System.out.println(student);
        }

    }

    public void checkStudentList() {
        boolean checkEmpty = this.studentArrayList.isEmpty();
        if (checkEmpty) {
            System.out.println("Danh sách đang rỗng");
        } else {
            System.out.println("Không! Danh sách đang có ít nhất một bạn sinh viên");
        }

    }

    public int getStudentAmount() {
        return this.studentArrayList.size();
    }

    public void deleteStudentList() {
        this.studentArrayList.removeAll(this.studentArrayList);
    }

    public void checkStudentExist(Student student) {
        boolean exists = this.studentArrayList.contains(student);
        if (exists) {
            System.out.println("Sinh viên " + student.getStudentID() + " có tồn tại trong danh sách");
        } else {
            System.out.println("Sinh viên " + student.getStudentID() + " không tồn tại trong danh sách");
        }

    }

    public void removeStudent(Student student) {
        this.studentArrayList.remove(student);
    }

    public void getStudent(String name) {
        Iterator var2 = this.studentArrayList.iterator();

        while(var2.hasNext()) {
            Student student = (Student)var2.next();
            if (student.getFullName().contains(name)) {
                System.out.println(student);
            }
        }

    }

    public void sortStudentList() {
        Collections.sort(this.studentArrayList, (student1, student2) -> {
            if (student1.getAverageScore() < student2.getAverageScore()) {
                return 1;
            } else {
                return student1.getAverageScore() > student2.getAverageScore() ? -1 : 0;
            }
        });
    }

    public void writeDownDataFile(File file) {
        try {
            OutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            for (Student student : studentArrayList) {
                objectOutputStream.writeObject(student);
            }

            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showUpDataFile(File file) {
        try {
            InputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Student student;
            while(true) {
                Object object = objectInputStream.readObject();
                if (object == null) {
                    break;
                }
                if (object != null) {
                    student = (Student) object;
                    this.studentArrayList.add(student);
                }
            }
                objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}