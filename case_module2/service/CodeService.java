package case_module2.service;

import case_module2.dto.CodeDTO;
import case_module2.model.Code.Code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CodeService {
    public static void createCode() {
        List<Code> codeList = CodeDTO.readFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập giá của mã:");
        double cost = scanner.nextDouble();
        scanner.nextLine();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = now.format(formatter);
        String code = "CG" + formattedDateTime;

        Code newCode = new Code(code, cost, true);
        codeList.add(newCode);

        CodeDTO.writeFile(codeList);
        System.out.println(newCode.getCode() + " đã được tạo");
    }

    public static void disableCode(String code) {
        List<Code> codeList = CodeDTO.readFile();
        for (Code code1 : codeList) {
            if (code1.getCode().equals(code)) {
                code1.setAvailable(!code1.isAvailable());
                break;
            }
        }
        CodeDTO.writeFile(codeList);
    }
}
