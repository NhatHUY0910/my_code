package demo.ViDu;

import demo.ViDu.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class ViDuGhiText {
    public static void main(String[] args) {
        try {
            PrintWriter printWriter = new PrintWriter("D:\\CodeGym\\Module_2\\luyen_tap_code_java\\tu_dien\\fileghitest.txt", StandardCharsets.UTF_8);
            printWriter.println("Xin chào, đây là ví dụ ghi file");

            printWriter.print("Dữ liệu: ");
            printWriter.print(3.14);
            printWriter.print(' ');
            printWriter.print(" là số PI");
            printWriter.println();

            Student student = new Student("SV001", "Nguyen Van A", 18);
            printWriter.println(student);
            printWriter.println();

            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
