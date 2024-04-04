package quan_ly_sinh_vien;

import quan_ly_sinh_vien.StudentList;

import java.io.File;
import java.util.Scanner;

public class StudentMain {
    public StudentMain() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();

        int choice;
        do {
            System.out.println("---------------------------------------");
            System.out.println("Chọn chức năng bạn muốn:");
            System.out.println("""
                    1. Thêm một sinh viên vào danh sách\s
                    2. Hiển thị danh sách sinh viên\s
                    3. Hiển thị số lượng sinh viên\s
                    4. Kiểm tra danh sách sinh viên có trống không\s
                    5. Xóa toàn bộ sinh viên trong danh sách\s
                    6. Kiểm tra một sinh viên có trong sách không (dựa trên mã sinh viên)\s
                    7. Xóa một sinh viên khỏi danh sách (dựa trên mã sinh viên)\s
                    8. Tìm kiếm sinh viên dựa trên tên được nhập\s
                    9. Hiển thị danh sách sinh viên theo thứ tự điểm từ cao đến thấp\s
                    10. Lưu danh sách sinh viên xuống tập tin\s
                    11. Hiển thị danh sách sinh viên từ tập tin\s
                    0. Thoát khỏi chương trình\s
                    """);
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Nhập mã sinh viên: ");
                    String studentID = scanner.nextLine();
                    System.out.println("Nhập họ tên sinh viên: ");
                    String studentName = scanner.nextLine();
                    System.out.println("Nhập năm sinh: ");
                    int studentBirthDay = scanner.nextInt();
                    System.out.println("Nhập điểm trung bình: ");
                    double studentScore = scanner.nextDouble();
                    Student student = new Student(studentID, studentName, studentBirthDay, studentScore);
                    studentList.addStudent(student);
                    break;
                case 2:
                    studentList.getStudentList();
                    break;
                case 3:
                    System.out.println("Số lượng sinh viên trong danh sách: " + studentList.getStudentAmount());
                    break;
                case 4:
                    studentList.checkStudentList();
                    break;
                case 5:
                    studentList.deleteStudentList();
                    break;
                case 6:
                    System.out.println("Nhập mã sinh viên: ");
                    String studentID1 = scanner.nextLine();
                    Student student1 = new Student(studentID1);
                    studentList.checkStudentExist(student1);
                    break;
                case 7:
                    System.out.println("Nhập mã sinh viên: ");
                    String studentID2 = scanner.nextLine();
                    Student student2 = new Student(studentID2);
                    studentList.removeStudent(student2);
                    System.out.println("Đã xóa sinh viên " + studentID2 + " khỏi danh sách");
                    break;
                case 8:
                    System.out.println("Nhập họ tên sinh viên: ");
                    String fullName = scanner.nextLine();
                    System.out.println("kết quả tìm kiếm:");
                    studentList.getStudent(fullName);
                    break;
                case 9:
                    studentList.sortStudentList();
                    studentList.getStudentList();
                    break;
                case 10:
                    System.out.println("Nhập tên file: ");
                    scanner.nextLine();
                    String fileName1 = scanner.nextLine();
                    File file1 = new File(fileName1);
                    studentList.writeDownDataFile(file1);
                    break;
                case 11:
                    System.out.println("Nhập tên file: ");
                    scanner.nextLine();
                    String fileName2 = scanner.nextLine();
                    File file2 = new File(fileName2);
                    studentList.showUpDataFile(file2);
                    break;
                    //"D:\CodeGym\Module_2\luyen_tap_code_java\quan_ly_sinh_vien\dssv.txt"
            }
        } while(choice != 0);

    }
}