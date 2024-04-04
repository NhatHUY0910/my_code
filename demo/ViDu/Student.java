package demo.ViDu;

import java.io.Serializable;

public class Student implements Serializable {
    private String id, name;
    private int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "demo.ViDu.Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
