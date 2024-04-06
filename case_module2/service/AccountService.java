package case_module2.service;

import case_module2.controller.HomePageController;
import case_module2.read_write_file.AccountDTO;
import case_module2.model.enum_user.GenderCustomer;
import case_module2.model.user_account.Account;
import case_module2.model.user_account.CustomerAccount;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountService {
    private List<Account> accountList;
    private Scanner scanner;

    public AccountService() {
        this.scanner = new Scanner(System.in);
    }

    public AccountService(List<Account> accountList) {
        this.accountList = accountList;
        this.scanner = new Scanner(System.in);
    }

    public void createCustomerAccount() throws InterruptedException {
        if (this.scanner == null) {
            this.scanner = new Scanner(System.in);
        }
        System.out.println("---------Tạo Tài Khoản Khách Hàng---------");

        List<CustomerAccount> customerAccountList = AccountDTO.readCustomerAccount();

        String userName;
        boolean validUserName = false;
        do {
            System.out.println("Nhập tên đăng nhập:");
            userName = scanner.nextLine();

            //Kiểm tra xem tên đăng nhập đã tồn tại chưa
            String finalUserName = userName;
            boolean userNameExist = customerAccountList.stream().anyMatch(customerAccount -> customerAccount.getUserName().equals(finalUserName));

            if (userNameExist) {
                System.out.println("Tên đăng nhập đã tồn tại. Vui lòng chọn tên đăng nhập khác");
                return;
        } else {
                //Kiểm tra tên đăng nhập hợp lệ
                String userNamePattern = "^[A-Za-z0-9]+$";
                if (!Pattern.matches(userNamePattern, userName)) {
                    System.out.println("Tên đăng nhập không hợp lệ! Vui lòng chỉ sử dụng chữ cái, số và không có kí tự đặc biệt");
                    System.out.println();
                } else {
                    validUserName = true;
                }
            }
        } while (!validUserName);

        String password;
        boolean validPassword = false;
        do {
            System.out.println("Nhập mật khẩu:");
            password = scanner.nextLine();

            //Kiểm tra mật khẩu hợp lệ
            String passwordPattern = "^(?=.*[A-Z])(?=.*\\d).{6,24}$";
            if (!Pattern.matches(passwordPattern, password)) {
                System.out.println("Mật khẩu không hợp lệ! Mật khẩu phải có ít nhất 6 kí tự, bao gồm ít nhất một chữ số và một kí tự viết hoa");
                System.out.println();
            } else {
                validPassword = true;
            }
        } while (!validPassword);

        System.out.println("Nhập họ và tên:");
        String fullName = scanner.nextLine();

        int age = 0;
        boolean validAge = false;
        do {
            System.out.println("Nhập tuổi:");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age < 3 || age > 200) {
                    System.out.println("Tuổi không hợp lệ! Vui lòng nhập độ tuổi hợp lí");
                    System.out.println();
                } else {
                    validAge = true;
                }
                validAge = true;
            } catch (NumberFormatException e) {
                System.out.println("Tuổi không hợp lệ! Vui lòng nhập số nguyên");
                System.out.println();
            }
        } while (!validAge);

        String gender;
        GenderCustomer genderCustomer = null;
        boolean validGender = false;
        do {
            System.out.println("Nhập giới tính:");
            gender = scanner.nextLine();

            //Kiểm tra giới tính hợp lệ
            if (gender.equalsIgnoreCase("Nam")) {
                genderCustomer = GenderCustomer.MALE;
                validGender = true;
            } else if (gender.equalsIgnoreCase("Nữ")) {
                genderCustomer = GenderCustomer.FEMALE;
                validGender = true;
            } else {
                System.out.println("Giới tính không hợp lệ! Vui lòng chọn Nam hoặc Nữ");
                System.out.println();
            }
        } while (!validGender);

        int phoneNumber = 0;
        boolean validPhoneNumber = false;
        do {
            System.out.println("Nhập số điện thoại:");
            try {
                phoneNumber = Integer.parseInt(scanner.nextLine());
                validPhoneNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("Số điện thoại không hợp lệ! Vui lòng nhập số nguyên");
                System.out.println();
            }
        } while (!validPhoneNumber);

        String country;
        boolean validCountry = false;
        do {
            System.out.println("Nhập quốc gia:");
            country = scanner.nextLine();

            if (country.matches(".*\\d.*")) {
                System.out.println("Tên quốc gia không hợp lệ! Vui lòng chỉ nhập chữ");
                System.out.println();
            } else {
                validCountry = true;
            }
        } while (!validCountry);

        CustomerAccount customerAccount = new CustomerAccount(userName, password, fullName, age, genderCustomer, phoneNumber, country);

        customerAccountList.add(customerAccount);

        //Ghi lại danh sách tài khoản khách hàng sau khi tạo
        AccountDTO.writeCustomerAccounts(customerAccountList);

        System.out.println("Tạo tài khoản thành công!");
        HomePageController.load();
    }

    public void changePassword(String userName) throws InterruptedException {
        if (this.scanner == null) {
            this.scanner = new Scanner(System.in);
        }

        List<CustomerAccount> customerAccountList = AccountDTO.readCustomerAccount();

        boolean validUserName = false;
        CustomerAccount customerAccount = null;

        for (CustomerAccount account : customerAccountList) {
            if (account.getUserName().equals(userName)) {
                validUserName = true;
                customerAccount = account;
                break;
            }
        }
        if (!validUserName) {
            System.out.println("Tên đăng nhập không tồn tại!");
            return;
        }

        String oldPassword;
        boolean validOldPassword = false;
        do {
            System.out.println("Nhập mật khẩu cũ:");
            oldPassword = scanner.nextLine();

            if (!oldPassword.equals(customerAccount.getPassWord())) {
                System.out.println("Mật khẩu cũ không chính xác! Vui lòng nhập lại");
            } else {
                validOldPassword = true;
            }
        } while (!validOldPassword);

        String newPassword;
        boolean validNewPassword = false;
        do {
            System.out.println("Nhập mật khẩu mới:");
            newPassword = scanner.nextLine();

            String passwordPattern = "^(?=.*[A-Z])(?=.*\\d).{6,24}$";
            if (!Pattern.matches(passwordPattern, newPassword)) {
                System.out.println("Mật khẩu không hợp lệ! Mật khẩu phải có ít nhất 6 kí tự, bao gồm ít nhất một chữ số và một kí tự viết hoa");
        } else {
                validNewPassword = true;
            }
        } while (!validNewPassword);

        customerAccount.setPassWord(newPassword);
        AccountDTO.writeCustomerAccounts(customerAccountList);
        System.out.println("Đã thay đổi mật khẩu mới thành công");
        System.out.println();
        HomePageController.load();
        }
    }
