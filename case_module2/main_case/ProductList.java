package case_module2.main_case;

import case_module2.model.enum_product.Size;
import case_module2.model.product.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductList {
    public static void main(String[] args) {
//        List<Clothes> clothesList = new ArrayList<>();
//        //Viết mã tạo một đối tượng mới từ vào đây
//        Clothes clothes1 = new Clothes("Kimono", 2900.99, 17, "Hanabi Kimono", "Japan", Fabric.CHẤT_LIỆU_SILK);
//        Clothes clothes2 = new Clothes("Ao Dai", 4999.99, 30, "Sợi Chỉ Vàng", "Vietnam", Fabric.CHẤT_LIỆU_SILK);
//        Clothes clothes3 = new Clothes("Trang Phục Hiphop", 1500.5, 9, "Weave Your Style", "America", Fabric.CHẤT_LIỆU_JEAN);
//        Clothes clothes4 = new Clothes("Đồng Phục Gym", 3600.80, 25, "Stylish & Strong", "French", Fabric.CHẤT_LIỆU_NYLON);
//        Clothes clothes5 = new Clothes("Vest", 9999.99, 15, "Like a Boss", "Germany", Fabric.CHẤT_LIỆU_LEN);
//        Clothes clothes6 = new Clothes("Short Clothes", 1999.99, 60, "Comfortable", "Thailand", Fabric.CHẤT_LIỆU_COTTON);
//        Clothes clothes7 = new Clothes("Pyjama", 3333.99, 50, "Dream Embroider", "Korea", Fabric.CHẤT_LIỆU_KAKI);
//        Clothes clothes8 = new Clothes("Student Uniform", 3500.99, 40, "Fashion School", "China", Fabric.CHẤT_LIỆU_BAMBOO);
//
//        clothesList.add(clothes1);
//        clothesList.add(clothes2);
//        clothesList.add(clothes3);
//        clothesList.add(clothes4);
//        clothesList.add(clothes5);
//        clothesList.add(clothes6);
//        clothesList.add(clothes7);
//        clothesList.add(clothes8);
//
//        String clotheFile = "product_list.csv";
//
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(clotheFile, true))) {
//            for (Clothes clothes : clothesList) {
//                String[] clothesData = {clothes.getName(), String.valueOf(clothes.getPrice()), String.valueOf(clothes.getQuantity()), clothes.getManufacturer(), clothes.getCountry(), clothes.getFabricType().toString()};
//                bufferedWriter.write(String.join(",", clothesData));
//                bufferedWriter.newLine();
//            }
//            System.out.println("Đã ghi sản phẩm Clothes vào file CSV thành công");
//        } catch (IOException e) {
//            System.out.println("Đã xảy ra lỗi khi ghi sản phẩm vào file CSV: " + e.getMessage());
//        }

//        List<Shampoo> shampooList = new ArrayList<>();
//
//        Shampoo shampoo1 = new Shampoo("Sữa Tắm Love Beauty", 6800.99, 10, "Unilever", "England", Fragrance.HƯƠNG_LOTUS);
//        Shampoo shampoo2 = new Shampoo("Sữa Tắm Gervenne", 4500.99, 20, "Hương Thơm Việt", "Vietnam", Fragrance.HƯƠNG_STRAWBERRY);
//        Shampoo shampoo3 = new Shampoo("Sữa Tắm Hazeline", 4800.35, 25, "Unilever", "England", Fragrance.HƯƠNG_HONEY);
//        Shampoo shampoo4 = new Shampoo("Sữa Tắm Enchanteur", 5500.65, 30, "Wipro Unza", "French", Fragrance.HƯƠNG_ROSE);
//        Shampoo shampoo5 = new Shampoo("Sữa Tắm Lux Botanicals", 4300.75, 25, "Unilever", "England", Fragrance.HƯƠNG_MINT);
//
//        shampooList.add(shampoo1);
//        shampooList.add(shampoo2);
//        shampooList.add(shampoo3);
//        shampooList.add(shampoo4);
//        shampooList.add(shampoo5);
//
//        String shampooFile = "product_list.csv";
//
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(shampooFile, true))) {
//            for (Shampoo shampoo : shampooList) {
//                String[] shampoData = {shampoo.getName(), String.valueOf(shampoo.getPrice()), String.valueOf(shampoo.getQuantity()), shampoo.getManufacturer(), shampoo.getCountry(), shampoo.getFragranceType().toString()};
//                bufferedWriter.write(String.join(",", shampoData));
//                bufferedWriter.newLine();
//            }
//            System.out.println("Đã ghi sản phẩm Shampoo vào file CSV thành công");
//        } catch (IOException e) {
//            System.out.println("Đã xảy ra lỗi khi ghi sản phẩm vào file CSV: " + e.getMessage());
//        }
//
//        List<InstantNoodles> instantNoodlesList = new ArrayList<>();
//
//        InstantNoodles instantNoodles1 = new InstantNoodles("Mì Cay Hàn Quốc", 25.65, 15, "Lee Ang Kai", "Korea", Level.CẤP_ĐỘ_CAY_7);
//        InstantNoodles instantNoodles2 = new InstantNoodles("Mì Cay Thái Lan", 22.75, 18, "Red Spicy", "Thailand", Level.CẤP_ĐỘ_CAY_6);
//        InstantNoodles instantNoodles3 = new InstantNoodles("Mì Cay Nhật Bản", 30.99, 10, "SuBaKai", "Japan", Level.CẤP_ĐỘ_CAY_3);
//        InstantNoodles instantNoodles4 = new InstantNoodles("Mì Cay Trung Quốc", 13.5, 27, "Hỏa Diệm Mì", "China", Level.CẤP_ĐỘ_CAY_5);
//        InstantNoodles instantNoodles5 = new InstantNoodles("Mì Cay Việt Nam", 12.85, 35, "Hảo Mì Cay", "Vietnam", Level.CẤP_ĐỘ_CAY_4);
//        InstantNoodles instantNoodles6 = new InstantNoodles("Mì Cay Ý", 27.85, 15, "Pasta Spicy", "Italia", Level.CẤP_ĐỘ_CAY_2);
//        InstantNoodles instantNoodles7 = new InstantNoodles("Spicy Noodles", 31.99, 10, "Super Hot", "America", Level.CẤP_ĐỘ_CAY_1);
//
//        instantNoodlesList.add(instantNoodles1);
//        instantNoodlesList.add(instantNoodles2);
//        instantNoodlesList.add(instantNoodles3);
//        instantNoodlesList.add(instantNoodles4);
//        instantNoodlesList.add(instantNoodles5);
//        instantNoodlesList.add(instantNoodles6);
//        instantNoodlesList.add(instantNoodles7);
//
//        String instantNoodlesFile = "product_list.csv";
//
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(instantNoodlesFile, true))) {
//            for (InstantNoodles instantNoodles : instantNoodlesList) {
//                String[] instantNoodlesData = {instantNoodles.getName(),
//                        String.valueOf(instantNoodles.getPrice()),
//                        String.valueOf(instantNoodles.getQuantity()),
//                        instantNoodles.getManufacturer(),
//                        instantNoodles.getCountry(),
//                        instantNoodles.getSpicy().toString()};
//                bufferedWriter.write(String.join(",", instantNoodlesData));
//                bufferedWriter.newLine();
//            }
//            System.out.println("Đã ghi sản phẩm InstantNoodles vào file CSV thành công");
//        } catch (IOException e) {
//            System.out.println("Đã xảy ra lỗi khi ghi sản phẩm vào file CSV: " + e.getMessage());
//        }
//
        List<FoodBox> foodBoxList = new ArrayList<>();

        FoodBox foodBox1 = new FoodBox("Hộp Đựng Thực Phẩm Nhựa", 65.9, 20, "BoxForFood", "Italia", Size.SIZE_BIG);
        FoodBox foodBox2 = new FoodBox("Hộp Đựng Thực Phẩm Giấy", 25.9, 40, "Bento Rice", "Japan", Size.SIZE_MEDIUM);
        FoodBox foodBox3 = new FoodBox("Hộp Thực Phẩm Kim Loại", 200.5, 10, "FoodBoxVN", "Vietnam", Size.SIZE_SMALL);

        foodBoxList.add(foodBox1);
        foodBoxList.add(foodBox2);
        foodBoxList.add(foodBox3);

        String foodBoxFile = "product_list.csv";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(foodBoxFile, true))) {
            for (FoodBox foodBox : foodBoxList) {
                String[] foodBoxData = {foodBox.getName(),
                        String.valueOf(foodBox.getPrice()),
                        String.valueOf(foodBox.getQuantity()),
                        foodBox.getManufacturer(),
                        foodBox.getCountry(),
                        foodBox.getSizeBox().toString()};
                bufferedWriter.write(String.join(",", foodBoxData));
                bufferedWriter.newLine();
            }
            System.out.println("Đã ghi sản phẩm FoodBox vào file CSV thành công");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi sản phẩm vào file CSV: " + e.getMessage());
        }
//
//        List<Book> bookList = new ArrayList<>();
//
//        Book book1 = new Book("Sách Khoa Học Viễn Tưởng", 50.99, 15, "UniverseLab", "America", "400 trang");
//        Book book2 = new Book("Sách Dạy Nấu Ăn", 46.68, 30, "MasterChef", "French", "200 trang");
//        Book book3 = new Book("Sách Kinh Tế - Tài Chính", 27.50, 9, "Silicon Valley", "America", "300 trang");
//
//        bookList.add(book1);
//        bookList.add(book2);
//        bookList.add(book3);
//
//        String bookFile = "product_list.csv";
//
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(bookFile, true))) {
//            for (Book book : bookList) {
//                String[] bookData = {book.getName(),
//                        String.valueOf(book.getPrice()),
//                        String.valueOf(book.getQuantity()),
//                        book.getManufacturer(),
//                        book.getCountry(),
//                        String.valueOf(book.getPaperAmount())
//                };
//                bufferedWriter.write(String.join(",", bookData));
//                bufferedWriter.newLine();
//            }
//            System.out.println("Đã ghi sản phẩm Book vào file CSV thành công");
//        } catch (IOException e) {
//            System.out.println("Đã xảy ra lỗi khi ghi sản phẩm vào file CSV: " + e.getMessage());
//        }
    }
}
