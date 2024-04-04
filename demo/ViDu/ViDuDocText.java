package demo.ViDu;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ViDuDocText {
    public static void main(String[] args) {
//        File file = new File("D:\\CodeGym\\Module_2\\luyen_tap_code_java\\demo\\fileghitest.txt");
//        try {
//            BufferedReader bufferedReader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
//            String line = null;
//            while (true) {
//                line = bufferedReader.readLine();
//                if (line == null) {
//                    break;
//                }else {
//                    System.out.println(line);
//                }
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }

        File file = new File("D:\\CodeGym\\Module_2\\luyen_tap_code_java\\demo\\fileghitest.txt");
        try {
            List<String> allText = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            for (String line : allText) {
                System.out.println(line);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
